package com.mingshashan.learn.lt.l381;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class RandomizedCollection {
    ArrayList<Integer> valList;
    HashMap<Integer, List<Integer>> val2IndexMap;

    public RandomizedCollection() {
        this.valList = new ArrayList<>();
        this.val2IndexMap = new HashMap<>();
    }

    public boolean insert(int val) {
        if (val2IndexMap.containsKey(val)) {
            val2IndexMap.get(val).add(valList.size());
            valList.add(val);
            return false;
        }

        List<Integer> indexList = new ArrayList<>();
        indexList.add(valList.size());
        val2IndexMap.put(val, indexList);
        valList.add(val);
        return true;
    }

    /**
     * 这里只删除的时候，删除最靠前（index最先放进去的）
     *
     * @param val
     * @return
     */
    public boolean remove(int val) {
        if (!val2IndexMap.containsKey(val)) {
            return false;
        }

        List<Integer> indexList = val2IndexMap.get(val);
        int index = indexList.get(indexList.size() - 1);
        int lastIndex = valList.size() - 1;
        int lastVal = valList.get(lastIndex);

        // 交换
        valList.set(index, lastVal);
        valList.set(lastIndex, val);

        // 先更新最后一个对应的indexList
        List<Integer> lastValIndexList = val2IndexMap.get(lastVal);
        val2IndexMap.get(lastVal).remove(lastValIndexList.size() - 1);
        val2IndexMap.get(lastVal).add(index);

        // 删除
        valList.remove(lastIndex);

        // 更新map
        if (1 == indexList.size()) {
            val2IndexMap.remove(val);
        } else {
            val2IndexMap.get(val).remove(val2IndexMap.get(val).size() - 1);
        }
        return true;
    }

    public int getRandom() {
        int random = new Random().nextInt();
        random = random >= 0 ? random : -random;
        return valList.get(random % valList.size());
    }
}