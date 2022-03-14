package com.mingshashan.learn.lt.l1081;

import java.util.Stack;

public class Solution_1081 {
    public String smallestSubsequence(String s) {
        byte[] inStack = new byte[256];
        byte[] count = new byte[256];
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            count[c]++;
        }

        for (char c : s.toCharArray()) {
            count[c]--;
            // 已经在了
            if (inStack[c] == 1) {
                continue;
            }

            // 单调栈
            while (!stack.isEmpty() && stack.peek() > c) {
                if (count[stack.peek()] == 0) {
                    break;
                }
                // 清除之前标记
                inStack[stack.pop()] = 0;
            }

            inStack[c] = 1;
            stack.push(c);
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}