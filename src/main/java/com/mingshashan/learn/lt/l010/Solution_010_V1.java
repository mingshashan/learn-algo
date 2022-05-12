package com.mingshashan.learn.lt.l010;

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
 * <p>
 * 1 <= s.length <= 20
 * 1 <= p.length <= 30
 * s contains only lowercase English letters.
 * p contains only lowercase English letters, '.', and '*'.
 * It is guaranteed for each appearance of the character '*', there will be a previous valid character to match.
 */
public class Solution_010_V1 {

    public boolean isMatch(String s, String p) {
        char point = '.';
        char star = '*';

        int ls = s.length();
        int lp = p.length();
        int is = 0, ip = 0;
        char cs;
        char cp;
        char preceding = '\0';
        while (is < ls && ip < lp) {
            cs = s.charAt(is);
            cp = p.charAt(ip);

            // 如果是'.'，那直接可以过，但是需要考虑下一个是'*'，所以需要把这次的记下来，也就是preceding
            if (cp == point) {
                preceding = cp;
                is++;
                ip++;
                continue;
            }

            // 如果是'*'，需要考虑，如果上次是'.'那么可以通过，如果上次是其他的需要比较
            // It is guaranteed for each appearance of the character '*', there will be a previous valid character to match.
            // 所以无需考虑 "**的情况"
            if (cp == star) {
                if (preceding == point) {
                    is++;
                    continue;
                }
                if (preceding == cs) {
                    is++;
                    continue;
                }
                if (preceding != cs) {
                    preceding = cp;
                    ip++;
                    continue;
                }
            }
            // 不相同返回false
            if (cs != cp) {
                preceding = cp;
                ip++;
                continue;
            }
            // 如果不是上面的同问
            preceding = cp;
            is++;
            ip++;
        }

        // aa, a，
        if (is < ls && ip >= lp && (preceding != point || preceding != star)) {
            return false;
        }

        while (ip < lp) {
            cp = p.charAt(ip);
            if (cp == point || cp == star) {
                ip++;
                continue;
            } else if (cp == preceding) {
                ip++;
                continue;
            } else {
                return false;
            }
        }

        return true;
    }
}