package com.xy1m.playground.okhttp;

import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * Created by gzhenpeng on 2019/4/8
 */
public class OkHttpSyncGetExample {

    private final static OkHttpClient client = new OkHttpClient();

    static Runnable request = () -> {
        Request request = new Request.Builder()
                .url("https://publicobject.com/helloworld.txt")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            Headers responseHeaders = response.headers();
            for (int i = 0; i < responseHeaders.size(); i++) {
                System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
            }

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
