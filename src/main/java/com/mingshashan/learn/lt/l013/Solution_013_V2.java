package com.mingshashan.learn.lt.l013;

/**
 * 13. Roman to Integer
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII,
 * which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "III"
 * Output: 3
 * Explanation: III = 3.
 * Example 2:
 * <p>
 * Input: s = "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 * Example 3:
 * <p>
 * Input: s = "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 * <p>
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * <p>
 * 需要注意减的情况
 */
public class Solution_013_V2 {


    // I             1
    // V             5
    // X             10
    // L             50
    // C             100
    // D             500
    // M             1000

    public int romanToInt(String s) {
        int result = 0;
        int prev = 0;
        for (int i = 0; i < s.length(); i++) {
            int curr = getVal(s.charAt(i));
            if (prev < curr) {
                result -= (prev * 2);
            }
            result += curr;
            prev = curr;
        }
        return result;
    }

    int getVal(char roman) {
        switch (roman) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
