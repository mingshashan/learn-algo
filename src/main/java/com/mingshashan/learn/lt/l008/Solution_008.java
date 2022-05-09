package com.mingshashan.learn.lt.l008;

/**
 * 8. String to Integer (atoi)
 */
public class Solution_008 {

    public int myAtoi(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }
        int result = 0;
        char negativeFlag = 0;
        int length = s.length();
        int index = 0;
        while (index < length && s.charAt(index) == ' ') {
            index++;
        }
        if (index == length) {
            return 0;
        }

        if (s.charAt(index) == '-' || s.charAt(index) == '+') {
            negativeFlag = s.charAt(index);
            index++;
        } else if (s.charAt(index) < '0' || s.charAt(index) > '9') {
            return 0;
        }

        while (index < length && isDigit(s.charAt(index))) {
            int last = s.charAt(index) - '0';
            if (result > (Integer.MAX_VALUE - last) / 10) {
                return negativeFlag == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            result = result * 10 + last;
            index++;
        }

        return negativeFlag == '-' ? -result : result;
    }

    static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }
}