package com.xy1m.playground.datastructure;

import java.util.List;

/**
 * Created by gzhenpeng on 11/15/18
 */
public class Trie {
    private TrieNode root;

    public Trie(List<App.Geo> list) {
        root = new TrieNode();
        for (App.Geo geo : list) {
            root.addWord(geo.getName(), geo);
        }
    }

    public Trie(App.Geo[] list) {
        root = new TrieNode();
        for (App.Geo geo : list) {
            root.addWord(geo.getName(), geo);
        }
    }

    public boolean contains(String prefix, boolean exact) {
        TrieNode lastNode = root;
        for (int i = 0; i < prefix.length(); i++) {
            lastNode = lastNode.getChild(prefix.charAt(i));
            if (lastNode == null) {
                return false;
            }
        }
        return !exact || lastNode.isTerminates();
    }

    public boolean contains(String prefix) {
        return contains(prefix, false);
    }

    public TrieNode getRoot() {
        return root;
    }

    public void setRoot(TrieNode root) {
        this.root = root;
    }
}
