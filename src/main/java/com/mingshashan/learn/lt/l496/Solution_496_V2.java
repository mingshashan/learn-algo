package com.mingshashan.learn.lt.l496;

import java.util.HashMap;
import java.util.Map;

public class Solution_496_V2 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }

        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int n2Index = map.get(nums1[i]);
            int t = 0;
            for (int j = n2Index; j < nums2.length; j++) {
                if (nums2[j] > nums1[i]) {
                    t = j;
                    break;
                }
            }
            result[i] = t == 0 ? -1 : nums2[t];
        }

        return result;
    }
}