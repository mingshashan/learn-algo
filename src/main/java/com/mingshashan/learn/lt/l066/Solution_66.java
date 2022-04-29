package com.mingshashan.learn.lt.l066;

/**
 * You are given a large integer represented as an integer array digits,
 * where each digits[i] is the ith digit of the integer.
 * The digits are ordered from most significant to least significant in left-to-right order.
 * The large integer does not contain any leading 0's.
 * <p>
 * Increment the large integer by one and return the resulting array of digits.
 * <p>
 * Input: digits = [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Incrementing by one gives 123 + 1 = 124.
 * Thus, the result should be [1,2,4].
 * <p>
 * Input: digits = [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 * Incrementing by one gives 4321 + 1 = 4322.
 * Thus, the result should be [4,3,2,2].
 * <p>
 * Input: digits = [9]
 * Output: [1,0]
 * Explanation: The array represents the integer 9.
 * Incrementing by one gives 9 + 1 = 10.
 * Thus, the result should be [1,0].
 * <p>
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 * digits does not contain any leading 0's.
 */
public class Solution_66 {

    public int[] plusOne(int[] digits) {
        int length = digits.length;
        int carry = 0;
        // base case最后一位
        int last = digits[length - 1] + 1;
        if (last <= 9) {
            // 如果没进位，则直接更新返回
            digits[length - 1] = last;
            return digits;
        }

        carry = 1;
        // 最后一位肯定是0
        digits[length - 1] = 0;
        int di = 0;
        // 有进位，则从后往前推，没有进位时直接break即可
        for (int i = length - 2; i >= 0; i--) {
            if (carry == 0) {
                break;
            }
            di = digits[i] + carry;
            if (di <= 9) {
                carry = 0;
                digits[i] = di;
                break;
            }
            carry = 1;
            digits[i] = 0;
        }

        // 最后还是为1，说明位数变了，如[9, 9] -> [1, 0, 0]
        if (carry == 1) {
            int[] newDigits = new int[length + 1];
            newDigits[0] = 1;
            for (int i = 0; i < length - 1; i++) {
                newDigits[i + 1] = digits[i];
            }
            return newDigits;
        }

        return digits;
    }
}