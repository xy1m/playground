package com.xy1m.playground.guava.collections;

import com.google.common.collect.BiMap;
import com.google.common.collect.ClassToInstanceMap;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableRangeSet;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.MultimapBuilder;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Multiset;
import com.google.common.collect.MutableClassToInstanceMap;
import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import com.google.common.collect.RangeSet;
import com.google.common.collect.Table;
import com.google.common.collect.TreeRangeMap;
import com.google.common.collect.TreeRangeSet;

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
        map1.replaceValues("a", Arrays.asList(7, 7, 8, 9));
        map1.put("b", 101);
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

    public static void testBiMap() {
        System.out.println("===== testBiMap =====");
        BiMap<String, Integer> biMap = HashBiMap.create();
        biMap.put("a", 1);

        System.out.println(biMap.inverse().get(1));
        //System.out.println(biMap.put("b", 2));
        System.out.println(biMap.put("a", 2));
        System.out.println(biMap.putIfAbsent("a", 2));
        System.out.println(biMap.values());
        System.out.println(biMap.forcePut("b", 2));
        System.out.println(biMap.get("b"));
    }

    public static void testTable() {
        System.out.println("===== testTable =====");
        Table<String, String, String> table = HashBasedTable.create();
        table.put("0", "0", "hello");
        table.put("0", "1", "world");
        table.put("1", "0", "java");

        System.out.println(table.row("0"));
        System.out.println(table.rowKeySet());
        for (Table.Cell cell : table.cellSet()) {
            System.out.println(cell.getColumnKey() + " " + cell.getRowKey() + " " + cell.getValue());
        }
    }

    public static void testClassToInstanceMap() {
        System.out.println("===== testClassToInstanceMap =====");
        ClassToInstanceMap<Number> numberDefaults = MutableClassToInstanceMap.create();
        numberDefaults.putInstance(Integer.class, Integer.valueOf(0));
        numberDefaults.putInstance(Long.class, Long.valueOf(0));

        System.out.println(numberDefaults.get(Integer.class).getClass());
        System.out.println(numberDefaults.get(Long.class).getClass());
    }

    public static void testRangeSet() {
        System.out.println("===== testRangeSet =====");
        RangeSet<Integer> rangeSet = TreeRangeSet.create();
        rangeSet.add(Range.closed(1, 10)); // {[1, 10]}
        rangeSet.add(Range.closedOpen(11, 15)); // disconnected range: {[1, 10], [11, 15)}
        rangeSet.add(Range.closedOpen(15, 20)); // connected range; {[1, 10], [11, 20)}
        rangeSet.add(Range.openClosed(0, 0)); // empty range; {[1, 10], [11, 20)}
        rangeSet.remove(Range.open(5, 10)); // splits [1, 10]; {[1, 5], [10, 10], [11, 20)}

        System.out.println(Range.closed(1, 10).canonical(DiscreteDomain.integers()));

        System.out.println(rangeSet);
        System.out.println(rangeSet.complement());
        System.out.println(rangeSet.subRangeSet(Range.closed(1, 3)));
        ImmutableRangeSet<Integer> immutableRangeSet =
                ImmutableRangeSet.<Integer>builder().add(Range.closed(1, 2)).build();
        System.out.println(immutableRangeSet.asSet(DiscreteDomain.integers()));

    }

    public static void testRangeQuery() {
        RangeSet<Integer> rangeSet = TreeRangeSet.create();
        rangeSet.add(Range.closed(1, 10)); // {[1, 10]}
        rangeSet.add(Range.closed(12, 13)); // {[1, 10]}
        System.out.println("===== testRangeQuery=====");
        System.out.println(rangeSet.contains(1));
        System.out.println(rangeSet.rangeContaining(2));
        System.out.println(rangeSet.encloses(Range.closed(1, 5)));
        System.out.println(rangeSet.span());
    }

    public static void testRangeMap() {
        RangeMap<Integer, String> rangeMap = TreeRangeMap.create();
        rangeMap.put(Range.closed(1, 10), "foo"); // {[1, 10] => "foo"}
        rangeMap.put(Range.open(3, 6), "bar"); // {[1, 3] => "foo", (3, 6) => "bar", [6, 10] => "foo"}
        rangeMap.put(Range.open(10, 20), "foo"); // {[1, 3] => "foo", (3, 6) => "bar", [6, 10] => "foo", (10, 20) => "foo"}
        rangeMap.remove(Range.closed(5, 11)); // {[1, 3] => "foo", (3, 5) => "bar", (11, 20) => "foo"}
        System.out.println(rangeMap.asMapOfRanges());
        System.out.println(rangeMap.subRangeMap(Range.closed(1, 2)));
        System.out.println(rangeMap);
    }

    public static void main(String[] args) {
        testMultiset();
        testMultimap();
        testBiMap();
        testTable();
        testClassToInstanceMap();
        testRangeSet();
        testRangeQuery();
        testRangeMap();
    }
}
