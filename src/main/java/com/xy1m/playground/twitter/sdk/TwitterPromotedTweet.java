package com.xy1m.playground.twitter.sdk;

import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by gzhenpeng on 2019/4/15
 */
public class TwitterPromotedTweet {
    private static final Logger LOGGER = LoggerFactory.getLogger(TwitterPromotedTweet.class);
    private final static OkHttpClient client = new OkHttpClient();
    private final static String CONSUMER_KEY = "x9WK66waTkFAdPcg4t6a7COrM";
    private final static String CONSUMER_SECRET = "Xxe9AJcOb43M1MjpgPb8f9EFXbutBZxNcoEnRfa2dtHuMt18FJ";
    private final static String TOKEN = "818091474-QST91vbiUxmdwtvRvPj0UqspnMu0nWlePYDVlXmu";
    private final static String TOKEN_SECRET = "9Axfli4LeiQd89n3nEK087epFqhXTGBAp96z1PulkYCQg";
    private final static String BASE_URL = "https://ads-api.twitter.com/5/accounts/dj2jf6/promoted_tweets";
    private final static Set<String> lineItemIds = new ImmutableSet.Builder<String>().add("dnvm4",
            "dnw29",
            "dnwbz",
            "dobit",
            "dodqa",
            "dosnz",
            "dosrs",
            "dosrt",
            "doswf",
            "dot08",
            "dot9p",
            "dotbn",
            "dotbp",
            "dotqc",
            "dp3br",
            "dp9th",
            "dpa7f",
            "dpabk",
            "dqxrm",
            "dqxrn",
            "dqxro",
            "dqxrp",
            "dqxrq",
            "dqxrr",
            "dqyl9",
            "dqyp2",
            "dr1ol",
            "dr5km",
            "eb5l0",
            "ecf39",
            "edm1y",
            "edory",
            "edozj",
            "ee9mm",
            "ee9mt",
            "ee9mu",
            "eeldb",
            "eeujh",
            "eeuqt",
            "eeuqv",
            "eeuu9",
            "eg4pg",
            "eh4jy",
            "ehbp8",
            "ehbtu",
            "ej06m",
            "ej50e",
            "ejav2",
            "ejav3",
            "ejjpe",
            "ekbu5",
            "enzgt",
            "es3ql",
            "esqn4",
            "esqv8",
            "esqws",
            "esqwt",
            "esqwu",
            "et1u4").build();
    private final static JsonParser PARSER = new JsonParser();

    static class Result {
        public String nextCursor;
        public JsonArray data;

        public String getNextCursor() {
            return nextCursor;
        }

        public void setNextCursor(String nextCursor) {
            this.nextCursor = nextCursor;
        }

        public JsonArray getData() {
            return data;
        }

        public void setData(JsonArray data) {
            this.data = data;
        }
    }

    static class PromotedTweet {
        private String lineItemId;
        private String id;
        private String tweetId;

        public PromotedTweet(String lineItemId, String id, String tweetId) {
            this.lineItemId = lineItemId;
            this.id = id;
            this.tweetId = tweetId;
        }

        public String getLineItemId() {
            return lineItemId;
        }

        public void setLineItemId(String lineItemId) {
            this.lineItemId = lineItemId;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTweetId() {
            return tweetId;
        }

        public void setTweetId(String tweetId) {
            this.tweetId = tweetId;
        }
    }

    public static PromotedTweet fun(String lineItemId) {
        Map<String, String> params = new HashMap<>();
        HttpUrl.Builder urlBuilder = HttpUrl.parse(BASE_URL).newBuilder();
        params.put("line_item_ids", lineItemId);
        params.put("with_deleted", "true");
        urlBuilder.addQueryParameter("with_deleted", "true");
        urlBuilder.addQueryParameter("line_item_ids", lineItemId);

        String accessToken = TwitterUtils.getOAuthToken(CONSUMER_KEY, CONSUMER_SECRET, TOKEN, TOKEN_SECRET, "GET",
                BASE_URL, params);

        Request request = new Request.Builder()
                .url(urlBuilder.build())
                .header("Authorization", "OAuth " + accessToken)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
            String json = response.body().string();
            JsonObject obj = PARSER.parse(json).getAsJsonObject();
            if (obj.has("data") && obj.get("data") != null) {
                JsonArray data = obj.get("data").getAsJsonArray();
                if (!data.isJsonNull() && data.size() != 0) {
                    JsonObject pt = data.get(0).getAsJsonObject();
                    String promote_tweet_id = pt.get("id").getAsString();
                    String tweet_id = pt.get("tweet_id").getAsString();
                    return new PromotedTweet(lineItemId, promote_tweet_id, tweet_id);
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void ff(){
        throw new RuntimeException("fool");
    }
    public static void main(String[] args) {

        /*List<PromotedTweet> promotedTweets = new ArrayList<>();

        for (String lineItemId : lineItemIds) {
            PromotedTweet pt = fun(lineItemId);
            if (pt != null) {
                promotedTweets.add(pt);
            }
        }

        for (PromotedTweet pt : promotedTweets) {
            LOGGER.info("update TWITTER_AD_GROUP set PROMOTED_TWEET_ID='{}', TWEET_ID='{}' where ID='{}'", pt.getId(), pt
                    .getTweetId(), pt.getLineItemId());
        }*/

        try{
            ff();
        }
        catch (Exception e){
            LOGGER.info("1,2={},3","i am wrong",e);
        }
    }
}
