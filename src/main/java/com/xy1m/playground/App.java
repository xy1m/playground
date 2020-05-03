package com.xy1m.playground;

import com.google.common.collect.Sets;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Hello world!
 */
public class App {

    static class Stats {
        public String id;
        public int impressions;
        public int clicks;
        public int spend;

        public Stats(String id, int impressions, int clicks, int spend) {
            this.id = id;
            this.impressions = impressions;
            this.clicks = clicks;
            this.spend = spend;
        }

        @Override
        public String toString() {
            return "Stats{" +
                    "id='" + id + '\'' +
                    ", impressions=" + impressions +
                    ", clicks=" + clicks +
                    ", spend=" + spend +
                    '}';
        }
    }

    public static void main(String[] args) {
        Set<String> set1=Sets.newHashSet("haha");
        Set<String> set2=new HashSet<>();
        set2.add("haha");
        System.out.println(set1.equals(set2));
    }
}
