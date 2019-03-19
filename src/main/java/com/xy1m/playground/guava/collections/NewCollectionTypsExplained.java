package com.xy1m.playground.guava.collections;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.MultimapBuilder;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Multiset;

import java.util.Arrays;
import java.util.Map;

/**
 * Created by gzhenpeng on 2019/3/18
 */
public class NewCollectionTypsExplained {

    public static enum COLOR {
        RED,
        YELLOW,
        BLUE
    }

    public static void testMultiset() {
        System.out.println("===== testMultiset =====");
        Multiset<String> multiset = HashMultiset.create();
        multiset.add("a");
        multiset.add("a");
        multiset.add("a");
        multiset.add("b");
        multiset.add("a", 3);

        for (Multiset.Entry<String> entry : multiset.entrySet()) {
            System.out.println(entry.getElement() + " " + entry.getCount());
        }
        System.out.println(multiset.size());
        System.out.println(multiset.count("a"));
        System.out.println(multiset.elementSet().size());

        multiset.remove("a", 5);
        multiset.remove("b", 2);
        System.out.println(multiset.size());
        System.out.println(multiset.count("a"));
        System.out.println(multiset.elementSet().size());
    }

    public static void testMultimap() {
        System.out.println("===== testMultimap =====");
        ListMultimap<String, Integer> map1 = MultimapBuilder.hashKeys().arrayListValues().build();

        map1.put("a", 3);
        map1.put("a", 4);
        System.out.println(map1.get("a"));
        map1.putAll("a", Arrays.asList(1, 2, 3));
        System.out.println(map1.get("a"));
        map1.remove("a", 3);
        System.out.println(map1.get("a"));
        map1.removeAll("a");
        System.out.println(map1.get("a"));
        map1.put("a", 6);
        map1.replaceValues("a", Arrays.asList(7, 8, 9));
        System.out.println(map1.get("a"));

        System.out.println(map1.asMap().get("a"));
        System.out.println(map1.asMap().get("b"));

        for (Map.Entry<String, Integer> entry : map1.entries()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        map1.keys();
        map1.keySet();
        map1.values();

        Multimaps.asMap(map1);
    }


    public static void main(String[] args) {
        testMultiset();
        testMultimap();
    }
}
