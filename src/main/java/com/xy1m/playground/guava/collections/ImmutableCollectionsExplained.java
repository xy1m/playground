package com.xy1m.playground.guava.collections;

import com.google.common.collect.ImmutableSet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * Created by gzhenpeng on 2019/3/18
 */
public class ImmutableCollectionsExplained {
    public static final ImmutableSet<String> COLORS = ImmutableSet.of("red", "yellow", "blue");


    public static void testBuilder() {
        System.out.println("===== testBuilder =====");
        ImmutableSet.builder().addAll(COLORS).add("brown").build().forEach(c -> System.out.println(c));
    }

    public static void testOriginalModification() {
        System.out.println("===== testOriginalModification =====");
        // Modify original collections won't affect immutable collections
        List<String> colors = new ArrayList<>();
        colors.add("black");
        Set<String> realColors = ImmutableSet.copyOf(colors);
        colors.add("white");

        realColors.forEach(c -> System.out.println(c));
    }

    public static void testJDKImmutableCollections() {
        System.out.println("===== testJDKImmutableCollections =====");
        List<String> colors = new ArrayList<>();
        colors.add("black");
        Collection<String> realColors = Collections.unmodifiableCollection(colors);
        colors.add("white");

        realColors.forEach(c -> System.out.println(c));

    }

    public static void main(String[] args) {
        testBuilder();
        testOriginalModification();
        testJDKImmutableCollections();
    }
}
