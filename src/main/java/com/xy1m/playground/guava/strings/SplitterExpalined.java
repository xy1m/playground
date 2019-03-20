package com.xy1m.playground.guava.strings;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;

import java.util.Arrays;

/**
 * Created by gzhenpeng on 2019/3/19
 */
public class SplitterExpalined {

    public static void testSplitter() {
        System.out.println(Arrays.asList(",a,,b,".split(",")));

        System.out.println(
                Splitter.on(",").trimResults().omitEmptyStrings().split(
                        "foo,bar,, qux, "
                ));

        System.out.println(
                Splitter.on(CharMatcher.anyOf(",;."))
                        .trimResults()
                        .omitEmptyStrings()
                        .split("foo,bar;, qux. ")
        );


        System.out.println(
                Splitter.onPattern("\r?\n")
                        .trimResults()
                        .omitEmptyStrings()
                        .split("foo\r\n" +
                                "bar\r\n" +
                                "qux\r\n")
        );

        System.out.println(
                Splitter.fixedLength(5)
                        .trimResults()
                        .omitEmptyStrings()
                        .split("abcdefthijk")
        );
        // note there is a space after _b_
        System.out.println(
                Splitter.on(',')
                        .trimResults(CharMatcher.is('_'))
                        .split("_a ,_b_ ,c__")
        );

        System.out.println(
                Splitter.on(',')
                        .trimResults(CharMatcher.is('_'))
                        .splitToList("_a ,_b_ ,c__")
        );

        System.out.println(
                Splitter.on(',')
                        .withKeyValueSeparator(':')
                        .split("a:1,b:2,c:3,d:4")
        );
    }

    public static void main(String[] args) {
        testSplitter();
    }
}
