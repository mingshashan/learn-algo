package com.mingshashan.learn.lt.l146;

import java.util.LinkedHashMap;

class LRUCache {
    int capacity;
    // 头为旧，尾为新
    LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }

        makeRecently(key);
        return cache.get(key);
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            cache.put(key, value);
            makeRecently(key);
            return;
        }
        if (capacity <= cache.size()) {
            // header key
            int headerKey = cache.keySet().iterator().next();
            cache.remove(headerKey);
        }
        cache.put(key, value);
    }

    private void makeRecently(int key) {
        int val = cache.get(key);
        cache.remove(key);
        cache.put(key, val);
    }
}
