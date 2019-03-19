package com.xy1m.playground;

import com.google.common.base.Joiner;
import com.google.common.io.BaseEncoding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by gzhenpeng on 2019/3/8
 */
public class InvertedIndex {

    private static class QueryTerm {
        public String keyword;
        public int frequency;
        public List<String> users = new ArrayList<>();
        public List<Integer> positions = new ArrayList<>();

        public QueryTerm(String keyword) {
            this.keyword = keyword;
        }
    }

    private static final Map<String, QueryTerm> termDict = new HashMap<>();
    private static final Random random = new Random();

    public static String generate() {
        final byte[] buffer = new byte[1];
        random.nextBytes(buffer);
        return BaseEncoding.base64Url().omitPadding().encode(buffer); // or base32()
    }

    public static void buildDict(String user, String query) {
        String[] keywords = query.split(" ");

        for (int idx = 0; idx < keywords.length; idx++) {
            String keyword = keywords[idx];
            QueryTerm item = termDict.getOrDefault(keyword, new QueryTerm(keyword));
            item.frequency++;
            item.users.add(user);
            item.positions.add(idx);
            termDict.put(keyword, item);
        }

    }

    public static void main(String[] args) {
        String[][] data = new String[10000][2];

        for (int i = 0; i < 10000; i++) {
            List<String> keywords = new ArrayList<>();
            for (int j = 0; j < random.nextInt(10); j++) {
                keywords.add(generate());
            }

            data[i] = new String[]{generate(), Joiner.on(" ").join(keywords)};
        }

        for (String[] searchQuery : data) {
            buildDict(searchQuery[0], searchQuery[1]);
        }

        for (QueryTerm item : termDict.values()) {
            System.out.println(String.format("keyword=%s frequency=%s users=%s", item.keyword, item.frequency, item
                    .users));
        }
    }
}


