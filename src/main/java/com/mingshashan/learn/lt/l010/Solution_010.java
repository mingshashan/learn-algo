package com.mingshashan.learn.lt.l010;

import java.util.HashMap;
import java.util.Map;

/**
 * 10. Regular Expression Matching
 * Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:
 * <p>
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 * <p>
 * Input: s = "aa", p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * <p>
 * Input: s = "aa", p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 * <p>
 * Input: s = "ab", p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 * 使用动态规划
 */
public class Solution_010 {

    Map<String, Boolean> memo = new HashMap<>();

    public boolean isMatch(String s, String p) {
        return dp(s, 0, p, 0);
    }

    private boolean dp(String s, int i, String p, int j) {
        int m = s.length(), n = p.length();
        // base case
        // 如果模式串走完，看匹配串是否走完即可
        if (j == n) {
            return i == m;
        }
        // 如果匹配串走完，需要处理一下，比如模式串是不是a*b*这种情况
        if (i == m) {
            // 如果不是偶数，肯定不匹配
            if ((n - j) % 2 == 1) {
                return false;
            }
            for (; j + 1 < n; j += 2) {
                if (p.charAt(j + 1) != '*') {
                    return false;
                }
            }
            return true;
        }

        String key = i + "_" + j;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        boolean res = false;
        // 匹配，则看下
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
            if (j < n - 1 && p.charAt(j + 1) == '*') {
                res = dp(s, i, p, j + 2) || dp(s, i + 1, p, j);
            } else {
                res = dp(s, i + 1, p, j + 1);
            }
        } else {
            if (j < n - 1 && p.charAt(j + 1) == '*') {
                res = dp(s, i, p, j + 2);
            } else {
                res = false;
            }
        }

        memo.put(key, res);
        return res;
    }
}