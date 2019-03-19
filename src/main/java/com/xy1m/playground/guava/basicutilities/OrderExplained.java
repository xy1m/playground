package com.xy1m.playground.guava.basicutilities;

import com.google.common.base.Function;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;
import com.sun.istack.internal.Nullable;

import java.util.Arrays;

/**
 * Created by gzhenpeng on 2019/3/18
 */
public class OrderExplained {
    private class Foo {
        @Nullable
        String sortedBy;
        int notSortedBy;
    }

    public static void main(String[] args) {
        Ordering<String> byLengthOrding = new Ordering<String>() {
            @Override
            public int compare(String left, String right) {
                return Ints.compare(left.length(), right.length());
            }
        };

        Ordering<Foo> ordering = Ordering.natural().nullsFirst().onResultOf(new Function<Foo, Comparable>() {
            @Override
            public Comparable apply(Foo input) {
                return input.sortedBy;
            }
        });
        System.out.println(byLengthOrding.greatestOf(Arrays.asList("1", "11", "111"), 2));
        System.out.println(byLengthOrding.isOrdered(Arrays.asList("1", "11", "111")));
        System.out.println(byLengthOrding.isOrdered(Arrays.asList("1111", "11", "111")));
        System.out.println(byLengthOrding.min("1", "11"));

    }
}
