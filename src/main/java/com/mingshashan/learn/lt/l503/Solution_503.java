package com.mingshashan.learn.lt.l503;

import java.util.Stack;

public class Solution_503 {
    public int[] nextGreaterElements(int[] nums) {
        int size = nums.length;
        int[] result = new int[size];

        Stack<Integer> stack = new Stack<>();
        for (int i = 2 * size - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i % size]) {
                stack.pop();
            }

            result[i % size] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i % size]);
        }

        return result;
    }
}