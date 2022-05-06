package com.mingshashan.learn.lt.l005;

/**
 * 5. Longest Palindromic Substring
 * Given a string s, return the longest palindromic substring in s.
 * <p>
 * Example 1:
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 * Example 2:
 * Input: s = "cbbd"
 * Output: "bb"
 */
public class Solution_005 {
    public String longestPalindrome(String s) {
        int length = s.length();
        int palindromeLength = 0;
        int start = 0;
        for (int i = 0; i < length; i++) {
            // 奇偶都要考虑进去
            int pl = Math.max(searchPalindrome(s, i, i), searchPalindrome(s, i, i + 1));

            if (pl > palindromeLength) {
                palindromeLength = pl;
                start = i - (pl - 1) / 2;
            }
        }

        return s.substring(start, start + palindromeLength);
    }

    int searchPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            left--;
            right++;
        }

        return right - left - 1;
    }

}