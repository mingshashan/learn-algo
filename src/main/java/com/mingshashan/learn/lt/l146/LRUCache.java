package com.mingshashan.learn.lt.l146;

import java.util.LinkedHashMap;

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 * 
 * 使用LinkedHashMap
 */
class LRUCache {

    private int capacity;
    // 头为旧，尾为新
    private LinkedHashMap<Integer, Integer> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<>();
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        makeRecently(key);
        return cache.get(key);
    }

    public void put(int key, int value) {
        // 如果有，直接put覆盖
        if (cache.containsKey(key)) {
            cache.put(key, value);
            makeRecently(key);
            return;
        }
        if (cache.size() >= capacity) {
            // 删除头节点
            int headKey = cache.keySet().iterator().next();
            cache.remove(headKey);
        }
        cache.put(key, value);
    }

    /**
     * 即从链表中间放到尾部
     * 
     * @param key
     */
    private void makeRecently(int key) {
        int val = cache.get(key);
        cache.remove(key);
        cache.put(key, val);
    }
}
