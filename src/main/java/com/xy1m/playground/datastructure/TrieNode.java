package com.xy1m.playground.datastructure;

import java.util.HashMap;

/**
 * Created by gzhenpeng on 11/15/18
 */
public class TrieNode {
    private char key;
    private HashMap<Character, TrieNode> children;
    private boolean terminates = false;
    private App.Geo data;

    public TrieNode() {
        children = new HashMap<>();
    }

    public TrieNode(Character character) {
        children = new HashMap<>();
        key = character;
    }

    public char getKey() {
        return key;
    }

    public void setKey(char key) {
        this.key = key;
    }

    public HashMap<Character, TrieNode> getChildren() {
        return children;
    }

    public void setChildren(HashMap<Character, TrieNode> children) {
        this.children = children;
    }

    public boolean isTerminates() {
        return terminates;
    }

    public void setTerminates(boolean terminates) {
        this.terminates = terminates;
    }

    public App.Geo getData() {
        return data;
    }

    public void setData(App.Geo data) {
        this.data = data;
    }

    public void addWord(String geoName, App.Geo geo) {
        Character first = geoName.charAt(0);
        TrieNode child = getChild(first);
        if (child == null) {
            child = new TrieNode(first);
            children.put(first, child);
        }
        if (geoName.length() > 1) {
            child.addWord(geoName.substring(1), geo);
        }
        else {
            child.setTerminates(true);
            child.setData(geo);
        }
    }

    public TrieNode getChild(char c) {
        return children.get(c);
    }
}
