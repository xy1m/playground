package com.xy1m.playground.datastructure;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    private static PrintStream ps = System.out;
    private static List<Geo> data = new ArrayList<>(127022);
    private static Trie trie;
    private static String loopTemplate = "from data result in %s milliseconds";
    private static String trieTemplate = "from trie result in %s milliseconds";

    public static void main(String[] args) throws IOException {
        String geoFileName = "/Users/gzhenpeng/Downloads/zemanta-geolocations-20181001.csv";
        long s1 = System.currentTimeMillis();
        importGeoData(geoFileName);
        long e1 = System.currentTimeMillis();
        System.out.println(String.format("Geo data imported! used %s milliseconds", e1 - s1));

        long s2 = System.currentTimeMillis();
        trie = new Trie(data);
        long e2 = System.currentTimeMillis();
        System.out.println(String.format("Trie built! used %s milliseconds", e2 - s2));

        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String keyword = in.nextLine();

            long s3 = System.currentTimeMillis();
            List<Geo> queryResult = queryGeoByKeyword(keyword);
            long e3 = System.currentTimeMillis();
            System.out.println(String.format(loopTemplate, e3 - s3));
            printResult(queryResult);

            long s4 = System.currentTimeMillis();
            List<Geo> searchResult = searchGeoInTrie(keyword);
            long e4 = System.currentTimeMillis();
            System.out.println(String.format(trieTemplate, e4 - s4));

            printResult(searchResult);
        }
    }

    static void printResult(List<Geo> geo) {
        geo.forEach(g -> ps.println(g));
    }

    static List<Geo> searchGeoInTrie(String keyword) {
        List<Geo> res = new ArrayList<>();
        TrieNode lastNode = trie.getRoot();
        for (int i = 0; i < keyword.length(); i++) {
            lastNode = lastNode.getChild(keyword.charAt(i));
            if (lastNode == null) {
                return res;
            }
        }
        if (lastNode.isTerminates()) {
            res.add(lastNode.getData());
        }
        addChildren(res, lastNode.getChildren().values());
        return res;
    }

    public static void addChildren(List<Geo> res, Collection<TrieNode> children) {
        for (TrieNode node : children) {
            if (node.isTerminates()) {
                res.add(node.getData());
            }
            addChildren(res, node.getChildren().values());
        }
    }


    static List<Geo> queryGeoByKeyword(String keyword) {
        List<Geo> res = new ArrayList<>();
        for (Geo geo : data) {
            if (geo.getName().contains(keyword)) {
                res.add(geo);
            }
        }
        return res;
    }

    static List<Geo> importGeoData(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        int count = 127022;

        // skip first line;
        String line = br.readLine();
        while ((line = br.readLine()) != null) {
            data.add(parseToGeo(line));
        }
        br.close();
        return data;
    }

    static Geo parseToGeo(String raw) {
        int first = raw.indexOf(",");
        int second = raw.indexOf(",", first + 1);

        return new Geo(
                raw.substring(0, first),
                raw.substring(first + 1, second),
                raw.substring(second + 1).replaceAll("\"", ""));

    }

    static class Geo {
        private String id;
        private String type;
        private String name;

        public Geo(String id, String type, String name) {
            this.id = id;
            this.type = type;
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String toString() {
            return "id=" + id + ",type=" + type + ",name=" + name;
        }
    }
}
