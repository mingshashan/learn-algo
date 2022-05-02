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
 *
 * Example 1:
 *
 * Input: s = "III"
 * Output: 3
 * Explanation: III = 3.
 * Example 2:
 *
 * Input: s = "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 * Example 3:
 *
 * Input: s = "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 *
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 *
 * 需要注意减的情况
 */
public class Solution_013 {


    public int romanToInt(String s) {
        int result = 0;
         // I             1
         // V             5
         // X             10
         // L             50
         // C             100
         // D             500
         // M             1000

        // IV = 4
        // IX = 9
        // XL = 40
        // XC = 90
        // CD = 400
        // CM = 900

        String temp = s;
        while (0 != temp.length()) {
            if (0 == temp.indexOf("CM")) {
                result += 900;
                temp = temp.substring(2);
                continue;
            }
            if (0 == temp.indexOf("CD")) {
                result += 400;
                temp = temp.substring(2);
                continue;
            }
            if (0 == temp.indexOf("XC")) {
                result += 90;
                temp = temp.substring(2);
                continue;
            }
            if (0 == temp.indexOf("XL")) {
                result += 40;
                temp = temp.substring(2);
                continue;
            }
            if (0 == temp.indexOf("IX")) {
                result += 9;
                temp = temp.substring(2);
                continue;
            }
            if (0 == temp.indexOf("IV")) {
                result += 4;
                temp = temp.substring(2);
                continue;
            }

            if (0 == temp.indexOf("M")) {
                result += 1000;
                temp = temp.substring(1);
                continue;
            }
            if (0 == temp.indexOf("D")) {
                result += 500;
                temp = temp.substring(1);
                continue;
            }
            if (0 == temp.indexOf("C")) {
                result += 100;
                temp = temp.substring(1);
                continue;
            }
            if (0 == temp.indexOf("L")) {
                result += 50;
                temp = temp.substring(1);
                continue;
            }
            if (0 == temp.indexOf("X")) {
                result += 10;
                temp = temp.substring(1);
                continue;
            }
            if (0 == temp.indexOf("V")) {
                result += 5;
                temp = temp.substring(1);
                continue;
            }
            if (0 == temp.indexOf("I")) {
                result += 1;
                temp = temp.substring(1);
                continue;
            }
        }

        return result;
    }
}

// I             1
// V             5
// X             10
// L             50
// C             100
// D             500
// M             1000