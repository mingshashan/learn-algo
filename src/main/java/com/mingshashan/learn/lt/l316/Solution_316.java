package com.mingshashan.learn.lt.l316;

import java.util.Stack;

public class Solution_316 {
    public String removeDuplicateLetters(String s) {
        byte[] count = new byte[256];
        byte[] inStack = new byte[256];
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            count[c]++;
        }

        for (char c : s.toCharArray()) {
            count[c]--;

            if (inStack[c] == 1) {
                continue;
            }

            while (!stack.isEmpty() && stack.peek() > c) {
                // 只出现一次，则不弹出
                if (count[stack.peek()] == 0) {
                    break;
                }
                inStack[stack.pop()] = 0;
            }
            inStack[c] = 1;
            stack.push(c);
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}