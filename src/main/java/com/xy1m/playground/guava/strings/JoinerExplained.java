package com.xy1m.playground.guava.strings;

import com.google.common.base.Joiner;

/**
 * Created by gzhenpeng on 2019/3/19
 */
public class JoinerExplained {
    public static void testJoiner() {
        Joiner joiner = Joiner.on("; ").skipNulls();
        System.out.println(joiner.join("Harry", null, "Ron"));
        Joiner joiner1 = Joiner.on("; ").useForNull("NULL");
        System.out.println(joiner1.join("Harry", null, "Ron"));
    }

    public static void main(String[] args) {
        testJoiner();
    }
}
