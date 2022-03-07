package com.mingshashan.learn.lt.l020;

import java.util.Stack;

public class Solution_020 {
    public boolean isValid(String s) {
        if (null == s || 1 >= s.length()) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '{' || c == '(' || c == '[') {
                stack.push(c);
            } else if (!stack.isEmpty() && leftOf(c) == stack.peek()) {
                stack.pop();
            } else {
                return false;
            }
        }

        return stack.isEmpty();
    }

    private char leftOf(char c) {
        if (c == '}') {
            return '{';
        }

        if (c == ']') {
            return '[';
        }

        return '(';
    }
}