package com.mingshashan.learn.lt.l009;

/**
 * Palindrome Number
 * Given an integer x, return true if x is palindrome integer.
 * <p>
 * An integer is a palindrome when it reads the same backward as forward.
 * <p>
 * For example, 121 is a palindrome while 123 is not.
 */
public class Solution_009 {


    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        // 特殊情况
        if (x < 10) {
            return true;
        }

        int temp = x;
        int t = 0;
        while (temp > 0) {
            t = t * 10 + (temp % 10);
            temp /= 10;
        }

        return t == x;
    }
}