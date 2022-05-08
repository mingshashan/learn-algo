package com.mingshashan.learn.lt.l007;

/**
 * 7. Reverse Integer
 * Given a signed 32-bit integer x, return x with its digits reversed.
 * If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 * <p>
 * Input: x = 123
 * Output: 321
 * Input: x = -123
 * Output: -321
 * Input: x = 120
 * Output: 21
 * <p>
 * -231 <= x <= 231 - 1
 */
public class Solution_007 {

    public int reverse(int x) {
        if (0 == x) {
            return x;
        }

        int quotient = x;
        int mod = x;

        long result = 0;
        while (quotient != 0) {
            mod = quotient % 10;
            result = result * 10 + mod;
            quotient /= 10;
        }
        if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
            return 0;
        }

        return (int) result;
    }
}
