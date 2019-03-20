package com.xy1m.playground.guava.collections;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.primitives.Ints;

import java.util.Arrays;
import java.util.List;

/**
 * Created by gzhenpeng on 2019/3/19
 */
public class CollectionUtilitiesExplained {

    public static void testIterables() {
        List<String> l1 = Lists.newArrayList("alpha", "beta", "gamma", "dog", "dog");
        List<String> l2 = Lists.newArrayList("alpha", "beta", "gamma", "dog", "dog");

        System.out.println(Iterables.concat(
                Ints.asList(1, 2, 3),
                Ints.asList(4, 5, 6)));
        System.out.println(Iterables.frequency(l1, "alpha"));
        System.out.println(Iterables.frequency(l1, "alpha1"));
        System.out.println(Iterables.getFirst(l1, "x"));
        System.out.println(Iterables.getLast(l1));
        System.out.println(Iterables.elementsEqual(l1, l2));
        System.out.println(Iterables.unmodifiableIterable(l1));
        System.out.println(Iterables.limit(l1, 2));
        System.out.println(Iterables.getOnlyElement(Arrays.asList("a")));
    }

    public static void main(String[] args) {
        testIterables();
    }
}
