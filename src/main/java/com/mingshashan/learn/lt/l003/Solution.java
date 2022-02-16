package com.mingshashan.learn.lt.l003;

import java.util.HashMap;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 * <p>
 * Input: s = "abcabcbb"
 * Output: 3
 */
class Solution {

    public int lengthOfLongestSubstring(String s) {
        // 也可以用滑动窗口解决
        HashMap<Character, Integer> window = new HashMap<>();

        int res = 0;
        int left = 0, right = 0;
        while (right < s.length()) {
            char rightChar = s.charAt(right);
            right++;
            // 放到窗口里面
            window.put(rightChar, window.getOrDefault(rightChar, 0) + 1);

            // 考虑什么情况下移出窗口左边字符
            // window.size()相当于是所有不相同的字符个数
            // 新近来的在原来的子串里面有，则把左边移出
            while (window.getOrDefault(rightChar, 0) > 1) {
                char leftChar = s.charAt(left);
                left++;
                // 移出
                window.put(leftChar, window.getOrDefault(leftChar, 0) - 1);
            }
            res = res > (right - left) ? res : (right - left);
        }
        return res;
    }
}