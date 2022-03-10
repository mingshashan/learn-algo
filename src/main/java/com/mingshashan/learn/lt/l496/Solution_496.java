package com.mingshashan.learn.lt.l496;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 单调栈
 */
public class Solution_496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {


        Map<Integer, Integer> temp = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums1.length];
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums2[i] >= stack.peek()) {
                stack.pop();
            }
            int v = stack.isEmpty() ? -1 : stack.peek();
            temp.put(nums2[i], v);
            stack.push(nums2[i]);
        }

        for (int i = 0; i < nums1.length; i++) {
            result[i] = temp.get(nums1[i]);
        }

        return result;
    }
}