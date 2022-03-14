package com.mingshashan.learn.lt.l739;

import java.util.Stack;

/**
 * Given an array of integers temperatures represents the daily temperatures,
 * return an array answer such that answer[i] is the number of days
 * you have to wait after the ith day to get a warmer temperature.
 * If there is no future day for which this is possible, keep answer[i] == 0 instead.
 * <p>
 * Input: temperatures = [73,74,75,71,69,72,76,73]
 * Output: [1,1,4,2,1,1,0,0]
 * <p>
 * Input: temperatures = [30,40,50,60]
 * Output: [1,1,1,0]
 * <p>
 * Input: temperatures = [30,60,90]
 * Output: [1,1,0]
 */
public class Solution_739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int result[] = new int[temperatures.length];

        Stack<Integer> stack = new Stack<>();
        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }

            result[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }

        return result;
    }
}