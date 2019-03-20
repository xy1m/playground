package com.xy1m.playground.guava.strings;

import com.google.common.base.Charsets;

/**
 * Created by gzhenpeng on 2019/3/19
 */
public class CharsetsExplained {
    public static void main(String[] args) {
        byte[] bytes = "hello".getBytes(Charsets.UTF_8);
        System.out.println(bytes);
    }
}
