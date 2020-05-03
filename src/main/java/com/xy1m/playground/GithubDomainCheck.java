package com.xy1m.playground;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GithubDomainCheck {

    public static void main(String[] args) throws IOException {
        Boolean xx=null;
        boolean yy=xx;
        System.out.println(yy);
    }

    public static boolean available(String username) throws IOException {
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW");
        RequestBody body = RequestBody.create(mediaType, "------WebKitFormBoundary7MA4YWxkTrZu0gW\r\nContent" +
                "-Disposition: form-data; name=\"authenticity_token\"\r\n\r\n8xo21i32tfLNQoMBelQFkpNEIX3ZuD85V744kpD" +
                "/IPjBa8sBnbIEv2DgLlMcKf5qrpiSzqf5rojqskVih8oTxw==\r\n------WebKitFormBoundary7MA4YWxkTrZu0gW\r" +
                "\nContent-Disposition: form-data; name=\"value\"\r\n\r\n" + username + "\r\n" +
                "------WebKitFormBoundary7MA4YWxkTrZu0gW--");
        Request request = new Request.Builder()
                .url("https://github.com/signup_check/username")
                .post(body)
                .addHeader("content-type", "multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW")
                .addHeader("Connection", "keep-alive")
                .addHeader("Pragma", "no-cache")
                .addHeader("Cache-Control", "no-cache")
                .addHeader("Origin", "https://github.com")
                .addHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.108 Safari/537.36")
                .addHeader("Content-Type", "multipart/form-data; boundary=----WebKitFormBoundaryxgIQhaH8rfFrT0Vf")
                .addHeader("Accept", "*/*")
                .addHeader("Sec-Fetch-Site", "same-origin")
                .addHeader("Sec-Fetch-Mode", "cors")
                .addHeader("Referer", "https://github.com/settings/admin")
                .addHeader("Accept-Encoding", "gzip, deflate, br")
                .addHeader("Accept-Language", "en-US,en;q=0.9")
                .addHeader("Cookie", "_octo=GH1.1.592656636.1570057674; _ga=GA1.2.2132536789.1570057675; _device_id=3e9db1513daffb5f35b35fc8e058ae25; user_session=maGH_OVnu4ts3KB8in11oVi8goUjvkaEZBcrW92HFPGI4QGy; __Host-user_session_same_site=maGH_OVnu4ts3KB8in11oVi8goUjvkaEZBcrW92HFPGI4QGy; logged_in=yes; dotcom_user=xy1m; tz=America%2FLos_Angeles; ignored_unsupported_browser_notice=false; has_recent_activity=1; _gat=1; _gh_sess=czhwQkJuN1VPTElFQ0NzejB5R05pOUpwazR1M2lOcWJhN2N0NHFhVTlXOTYyTEc1Ym44V1U1ODlRT1RUL1dQNWF0Q204V1pIUUIyT1BqdFdrZFduRFJCdUpFM3lyYll5K2N4emJoTTFtdUdXNndwN3FxeHZKNnM5WHFVQXUvVVVVM0haRW42REt3Ny9MSmRXUmd0cldTNStGbjF5cWxWaVlyZ3BDYWFIQU9zbW9UeU1BcEZ3Yk14L3pnYUROZnNJL2JpdFhHeVNmVmdEbzE5ZXBsT0NhRithMHZlbVo2dlU2T1VVazVUektUR094Q0w4U0hPZFlxaFBVdS9BN2R0bm9ETGRicWZCUEtiNmEyRU1aS2V6R0JzM0drZE1nWHRWMTRHTjBDRi9kdlRpY2ZVM0Z0U05IUHg5UHp1S0JkVE0tLVNod1N0cUxraGdRZmpZV0NOVlJ3NGc9PQ%3D%3D--7cab8d807a3a18aedbccb434e77213851bcc43b7,_octo=GH1.1.592656636.1570057674; _ga=GA1.2.2132536789.1570057675; _device_id=3e9db1513daffb5f35b35fc8e058ae25; user_session=maGH_OVnu4ts3KB8in11oVi8goUjvkaEZBcrW92HFPGI4QGy; __Host-user_session_same_site=maGH_OVnu4ts3KB8in11oVi8goUjvkaEZBcrW92HFPGI4QGy; logged_in=yes; dotcom_user=xy1m; tz=America%2FLos_Angeles; ignored_unsupported_browser_notice=false; has_recent_activity=1; _gat=1; _gh_sess=czhwQkJuN1VPTElFQ0NzejB5R05pOUpwazR1M2lOcWJhN2N0NHFhVTlXOTYyTEc1Ym44V1U1ODlRT1RUL1dQNWF0Q204V1pIUUIyT1BqdFdrZFduRFJCdUpFM3lyYll5K2N4emJoTTFtdUdXNndwN3FxeHZKNnM5WHFVQXUvVVVVM0haRW42REt3Ny9MSmRXUmd0cldTNStGbjF5cWxWaVlyZ3BDYWFIQU9zbW9UeU1BcEZ3Yk14L3pnYUROZnNJL2JpdFhHeVNmVmdEbzE5ZXBsT0NhRithMHZlbVo2dlU2T1VVazVUektUR094Q0w4U0hPZFlxaFBVdS9BN2R0bm9ETGRicWZCUEtiNmEyRU1aS2V6R0JzM0drZE1nWHRWMTRHTjBDRi9kdlRpY2ZVM0Z0U05IUHg5UHp1S0JkVE0tLVNod1N0cUxraGdRZmpZV0NOVlJ3NGc9PQ%3D%3D--7cab8d807a3a18aedbccb434e77213851bcc43b7; has_recent_activity=1; user_session=maGH_OVnu4ts3KB8in11oVi8goUjvkaEZBcrW92HFPGI4QGy; __Host-user_session_same_site=maGH_OVnu4ts3KB8in11oVi8goUjvkaEZBcrW92HFPGI4QGy; _gh_sess=ckhpK2NLSWx2NS9GUEtCZkRkYXFSQkdLUEJBTWl4Vmp0TkVkWFNsRmtBODlJaGFXZGFjVjhNOWVqM1JSQ0pCZ09jdlQyN09BRE5YVlVpTmpsQUpjZWw1UE1TRUpzVEtVUzlaUmVyelgyWmJoV3R0VzMrQWlBN2FZSGZqek5PdUlLWlA3MkNmdEQ0N25lVE9KZUxpT0YvMVFBQm03cGNVSjltN1dvVU5rbU9ZZDFXamFhSXhiMmpaM0xLMUhnUkJJS2xwVnM5RytXNlJtemlRbDNlWFdtZDBkaEdVNGNpWnJHY004K2VZbkd6Tms5d1R2bWpmTUhlNmVoaTNZQ1JZY1kzY2F0czhzV3Y4WnEvWndkdElqKzZDSEhDSEJEdm5qRXZyREpSNktFRU9wWWcvS3hkSzFLRVlPZTFnOUM2TDAtLTFDaWVuejB5cmMwRmxnSFN0VmhndkE9PQ%3D%3D--c581aa21a6e72b8b88951d84c9056fce39e0d429")
                .addHeader("Postman-Token", "693ebdb8-9e74-40e9-bd1b-05b31592d104,b488a5f3-86ed-4dce-b927-612e29b61534")
                .addHeader("Host", "github.com")
                .addHeader("Content-Length", "332")
                .addHeader("cache-control", "no-cache")
                .build();

        Response response = client.newCall(request).execute();

        return !response.body().string().contains("not available");
    }
}
