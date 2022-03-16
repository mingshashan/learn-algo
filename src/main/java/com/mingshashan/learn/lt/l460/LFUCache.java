package com.mingshashan.learn.lt.l460;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public class LFUCache {

    private LinkedHashMap<Integer, Integer> key2Val;
    private LinkedHashMap<Integer, Integer> key2Frequently;
    private HashMap<Integer, LinkedHashSet<Integer>> frequently2Keys;

    private int capacity;
    private int minFrequently;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFrequently = 0;
        this.key2Val = new LinkedHashMap<>();
        this.key2Frequently = new LinkedHashMap<>();
        this.frequently2Keys = new HashMap<>();
    }

    public int get(int key) {
        // 不存在返回-1
        if (!key2Val.containsKey(key)) {
            return -1;
        }

        // 存在更新对应的key的使用频次
        int val = key2Val.get(key);
        updateFrequently(key);
        return val;
    }

    public void put(int key, int value) {
        // 1.在里面
        if (key2Val.containsKey(key)) {
            key2Val.put(key, value);
            updateFrequently(key);
            return;
        }
        // 不在里面，那么minFrequently肯定要设置为1
        // 2.不在里面
        // 2.1容量不够
        if (capacity <= key2Val.size()) {
            // should delete key
            deleteLeastFrequently();
        }
        if (capacity <= key2Val.size()) {
            return;
        }
        // 2.2容量不够
        // 删除应删除的key
        key2Val.put(key, value);
        updateFrequently(key);
    }

    void deleteLeastFrequently() {
        if (!frequently2Keys.containsKey(minFrequently)) {
            return;
        }

        LinkedHashSet<Integer> keyList = frequently2Keys.get(minFrequently);
        int oldestKey;
        if (0 == keyList.size()) {
            return;
        }
        oldestKey = keyList.iterator().next();
        // 删除
        key2Val.remove(oldestKey);
        key2Frequently.remove(oldestKey);
        if (1 == keyList.size()) {
            frequently2Keys.remove(minFrequently);
        } else {
            frequently2Keys.get(minFrequently).remove(oldestKey);
        }
    }

    // 更新
    private void updateFrequently(int key) {
        // 主要更新key2Frequently，frequently2Keys, minFrequently;
        // 如果key第一次放，那么minFrequently需要设置为1
        int freq = key2Frequently.getOrDefault(key, 0);
        if (0 == freq) {
            minFrequently = 1;
            freq = 1;
            // 且更新key2Frequently，frequently2Keys
            key2Frequently.put(key, freq);

            if (!frequently2Keys.containsKey(freq)) {
                frequently2Keys.put(freq, new LinkedHashSet<>());
            }
            frequently2Keys.get(freq).add(key);
            return;
        }
        // 如果不是第一次
        // 更新key2Frequently
        key2Frequently.put(key, freq + 1);

        // 更新frequently2Keys
        if (1 == frequently2Keys.getOrDefault(freq, new LinkedHashSet<>()).size()) {
            frequently2Keys.remove(freq);
        } else {
            frequently2Keys.get(freq).remove(key);
        }

        if (!frequently2Keys.containsKey(freq + 1)) {
            frequently2Keys.put(freq + 1, new LinkedHashSet<>());
        }
        frequently2Keys.get(freq + 1).add(key);

        // 更新minFrequently
        if (freq == minFrequently && !frequently2Keys.containsKey(minFrequently)) {
            minFrequently++;
        }
    }
}