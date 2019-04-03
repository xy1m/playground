package com.xy1m.playground.guava.caches;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.RemovalListener;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by gzhenpeng on 2019/3/19
 */
public class ApplicabilityExplained {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        RemovalListener<String, String> removalListener = removal -> System.out.println(removal.getKey() + "_" + removal.getValue() + " removed");

        LoadingCache<String, String> graphs = CacheBuilder.newBuilder()
                .maximumSize(3)
                .expireAfterWrite(2, TimeUnit.SECONDS)
                .removalListener(removalListener)
                .build(
                        new CacheLoader<String, String>() {
                            public String load(String key) throws Exception {
                                return "expensive_" + key;
                            }
                        });

        while (true) {
            Thread.sleep(1000);
            System.out.println(graphs.get("hello"));
        }
    }
}
