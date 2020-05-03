package com.xy1m.playground.twitter.sdk;

import com.google.common.base.Joiner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.net.URLEncoder;
import java.time.Instant;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * Created by gzhenpeng on 2019/4/8
 */
public class TwitterUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(TwitterUtils.class);

    private static final String OAUTH_SIGNATURE_METHOD = "HMAC-SHA1";
    private static final String OAUTH_VERSION = "1.0";

    public static String getOAuthToken(String oauthConsumerKey,
                                       String oauthConsumerSecret,
                                       String oauthToken,
                                       String oauthTokenSecret,
                                       String httpMethod,
                                       String baseUrl,
                                       Map<String, String> params) {
        // collect parameters
        Map<String, String> allParams = new TreeMap<>();

        Map<String, String> oauthParams = new TreeMap<>();
        oauthParams.put("oauth_consumer_key", oauthConsumerKey);
        oauthParams.put("oauth_nonce", nonce());
        oauthParams.put("oauth_signature_method", OAUTH_SIGNATURE_METHOD);
        oauthParams.put("oauth_timestamp", String.valueOf(Instant.now().getEpochSecond()));
        oauthParams.put("oauth_token", oauthToken);
        oauthParams.put("oauth_version", OAUTH_VERSION);

        allParams.putAll(oauthParams);
        allParams.putAll(params);

        String parameterString = generateParameterString(allParams);
        LOGGER.debug("parameterString {}", parameterString);

        String signatureBaseString = generateSignatureBaseString(httpMethod, baseUrl, parameterString);
        LOGGER.debug("signatureBaseString {}", signatureBaseString);

        String oauthSignature = generateSignature(signatureBaseString, oauthConsumerSecret, oauthTokenSecret);
        LOGGER.debug("oauthSignature {}", encode(oauthSignature));

        oauthParams.put("oauth_signature", encode(oauthSignature));

        List<String> oauthHeaders = oauthParams.entrySet().stream()
                .map(e -> encode(e.getKey()) + "=" + doubleQuoted(e.getValue()))
                .collect(Collectors.toList());

        String headerStr = Joiner.on(",").join(oauthHeaders);
        LOGGER.debug("HeaderString {}", headerStr);
        return headerStr;
    }

    private static String generateParameterString(Map<String, String> params) {
        // build parameter string with key and value encoded
        List<String> paramPairs = params.entrySet().stream()
                .map(e -> encode(e.getKey()) + "=" + encode(e.getValue()))
                .collect(Collectors.toList());
        return Joiner.on("&").join(paramPairs);
    }

    private static String generateSignatureBaseString(String httpMethod, String baseUrl, String parameterString) {
        // be careful here, we need to encode parameter string again.
        return httpMethod.toUpperCase() + "&" +
                encode(baseUrl) + "&" +
                encode(parameterString);
    }

    private static String nonce() {
        byte[] randomBytes = new byte[32];
        new Random().nextBytes(randomBytes);
        return Base64.getEncoder().encodeToString(randomBytes).replaceAll("[^a-zA-Z0-9]", "");
    }

    private static String encode(String value) {
        String encoded = "";
        try {
            encoded = URLEncoder.encode(value, "UTF-8");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        // replace reserved characters
        StringBuilder sb = new StringBuilder();
        char cur;
        for (int i = 0; i < encoded.length(); i++) {
            cur = encoded.charAt(i);
            if (cur == '*') {
                sb.append("%2A");
            }
            else if (cur == '+') {
                // is from ' '
                sb.append("%20");
            }
            else {
                sb.append(cur);
            }
        }
        return sb.toString();
    }

    private static String generateSignature(String baseStr, String consumerSecret, String tokenSecret) {
        byte[] byteHMAC = null;
        try {
            Mac mac = Mac.getInstance("HmacSHA1");
            SecretKeySpec spec;
            if (null == tokenSecret) {
                String signingKey = encode(consumerSecret) + '&';
                spec = new SecretKeySpec(signingKey.getBytes(), "HmacSHA1");
            }
            else {
                String signingKey = encode(consumerSecret) + '&' + encode(tokenSecret);
                spec = new SecretKeySpec(signingKey.getBytes(), "HmacSHA1");
            }
            mac.init(spec);
            byteHMAC = mac.doFinal(baseStr.getBytes());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return Base64.getEncoder().encodeToString(byteHMAC);
    }

    private static String doubleQuoted(String str) {
        return "\"" + str + "\"";
    }

}
