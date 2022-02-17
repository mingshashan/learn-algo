package com.mingshashan.learn.lt.l003;

import java.util.HashMap;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 * <p>
 * Input: s = "abcabcbb"
 * Output: 3
 */
class Solution2 {

    /**
     * 0 <= s.length <= 5 * 104
     * s consists of English letters, digits, symbols and spaces.
     * ASCII码是从0-127,可以利用这个特性
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int[] temp = new int[128];
        int left = 0, right = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (temp[c] > 0) {
                // 说明重复了，需要更新
                left = left > temp[c] ? left : temp[c];
            }
            temp[c] = right;
            int len = right - left;
            res = res > len ? res : len;
        }

        return  res == 0 ? s.length() : res;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(new Solution2().lengthOfLongestSubstring(s));
    }
}