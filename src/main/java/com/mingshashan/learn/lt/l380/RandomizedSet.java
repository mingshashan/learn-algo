package com.mingshashan.learn.lt.l380;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Implement the RandomizedSet class:
 * <p>
 * RandomizedSet() Initializes the RandomizedSet object.
 * bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.
 * bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.
 * int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one element exists when this method is called). Each element must have the same probability of being returned.
 * <p>
 * You must implement the functions of the class such that each function works in average O(1) time complexity.
 */
public class RandomizedSet {

    ArrayList<Integer> valList;
    HashMap<Integer, Integer> val2IndexMap;

    public RandomizedSet() {
        this.valList = new ArrayList<>();
        this.val2IndexMap = new HashMap<>();
    }

    /**
     * 插入，如果没有正常插入，返回true；已有返回false
     *
     * @param val
     * @return 如果没有正常插入返回true；已有返回false
     */
    public boolean insert(int val) {
        if (val2IndexMap.containsKey(val)) {
            return false;
        }
        val2IndexMap.put(val, valList.size());
        valList.add(val);
        return true;
    }

    /**
     * 删除，如果没有返回false；有删除后返回true
     *
     * @param val
     * @return 如果没有返回false；有删除后返回true
     */
    public boolean remove(int val) {
        if (!val2IndexMap.containsKey(val)) {
            return false;
        }
        int index = val2IndexMap.get(val);
        // 交换index和最后一个元素
        int lastIndex = valList.size() - 1;
        int lastValue = valList.get(lastIndex);
        valList.set(index, lastValue);
        valList.set(lastIndex, val);
        valList.remove(lastIndex);
        val2IndexMap.put(lastValue, index);
        val2IndexMap.remove(val);
        return true;
    }

    public int getRandom() {
        int random = new Random().nextInt();
        random = random >= 0 ? random : -random;
        return valList.get(random % valList.size());
    }
}
