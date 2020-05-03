package com.xy1m.playground.okhttp;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.BufferedSink;

import java.io.File;
import java.io.IOException;

/**
 * Created by gzhenpeng on 2019/4/8
 */
public class OkHttpPostFileExample {
    public static final MediaType MEDIA_TYPE_MARKDOWN
            = MediaType.parse("text/x-markdown; charset=utf-8");
    private final static OkHttpClient client = new OkHttpClient();

    static Runnable request = () -> {
        File file = new File("README.md");

        Request request = new Request.Builder()
                .url("https://api.github.com/markdown/raw")
                .post(RequestBody.create(MEDIA_TYPE_MARKDOWN, file))
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            System.out.println(response.body().string());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    };

    public static void main(String[] args) {
        request.run();
    }
}
