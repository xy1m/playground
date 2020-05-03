package com.xy1m.playground.okhttp;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Map;

/**
 * Created by gzhenpeng on 2019/4/8
 */
public class OkHttpParsingJSonResponseExample {

    private final static OkHttpClient client = new OkHttpClient();

    static class Gist {
        Map<String, GistFile> files;
    }

    static class GistFile {
        String content;
    }

    static Runnable request = () -> {
        Request request = new Request.Builder()
                .url("https://api.github.com/gists/c2a7c39532239ff261be")
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
