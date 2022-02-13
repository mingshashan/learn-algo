package com.mingshashan.learn.lt.l076;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t of lengths m and n respectively,
 * return the minimum window substring of s such that every character in t (including duplicates) is included in the window.
 * If there is no such substring, return the empty string "".
 * <p>
 * The testcases will be generated such that the answer is unique.
 * <p>
 * A substring is a contiguous sequence of characters within the string.
 */
class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>(), window = new HashMap<>();
        for (char tc : t.toCharArray()) {
            need.put(tc, need.getOrDefault(tc, 0) + 1);
        }

        int left = 0, right = 0;
        int start = 0;
        int len = Integer.MAX_VALUE;
        // 前面子串含t个数（不重复）
        int valid = 0;
        // 滑动
        while (right < s.length()) {

            // 当前移动到的字符
            char cCurrent = s.charAt(right);
            right++;

            // 如有满足，放到window里面
            if (need.containsKey(cCurrent)) {
                window.put(cCurrent, window.getOrDefault(cCurrent, 0) + 1);
                if (window.getOrDefault(cCurrent, 0).equals(need.get(cCurrent))) {
                    valid++;
                }
            }

            // 当子串含有t的全字符时，需要left往右滑动找最小的
            while (valid == need.size()) {
                // 来保证是不是最小子串
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }

                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (need.get(d).equals(window.getOrDefault(d, 0))) {
                        valid--;
                    }
                    // 对窗口进行操作
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        String result = new Solution().minWindow(s, t);
        String expectStr = "BANC";
        System.out.println(result.equals(expectStr));
    }
}