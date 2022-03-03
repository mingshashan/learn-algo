package com.mingshashan.learn.lt.l599;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_599 {

    public String[] findRestaurant(String[] list1, String[] list2) {

        int x = 0b00000001_00000000_00000000_00000000;
        int y = 0b01111110_11111111_11111111_11111111;

        List<String> result = new ArrayList<>();

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                int d = map.get(list2[i]) + i;
                int dd = x | d;
                map.put(list2[i], dd);
            }
        }

        int smallIndex = Integer.MAX_VALUE;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if ((entry.getValue() & x) != x) {
                continue;
            }

            int sumIndex = entry.getValue() & y;

            if (sumIndex <= smallIndex) {
                if (sumIndex < smallIndex) {
                    result.clear();
                }
                result.add(entry.getKey());
                smallIndex = sumIndex;
            }
        }

        return result.toArray(new String[]{});
    }
}