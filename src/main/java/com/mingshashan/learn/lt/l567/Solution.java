package com.mingshashan.learn.lt.l567;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s1 and s2,
 * return true if s2 contains a permutation of s1, or false otherwise.
 * <p>
 * In other words, return true if one of s1's permutations is the substring of s2.
 */
class Solution {
    /**
     * s1是子串
     *
     * @param s1 1 <= s1.length, s2.length <= 104
     * @param s2 s1 and s2 consist of lowercase English letters.
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {

        // 滑动窗口
        int left = 0, right = 0;
        Map<Character, Integer> need = new HashMap<>(), window = new HashMap<>();
        for (char c : s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        // 满足1个字符valid+1
        int valid = 0;
        while (right < s2.length()) {
            char rightChar = s2.charAt(right);
            right++;
            if (need.containsKey(rightChar)) {
                window.put(rightChar, window.getOrDefault(rightChar, 0) + 1);
                // 如果窗口里面某个字符个数和need里面相同，说明该字符找到
                if (need.get(rightChar).equals(window.get(rightChar))) {
                    valid++;
                }
            }

            // 当窗口里面字符串长度>=子串长度需要判断是否已经满足条件
            while (right - left >= s1.length()) {
                // 满足条件，返回true
                if (valid == need.size()) {
                    return true;
                }

                char leftChar = s2.charAt(left);
                left++;
                // 将左边数据移出窗口的同时需要注意更新window和valid
                if (need.containsKey(leftChar)) {
                    if (need.get(leftChar).equals(window.get(leftChar))) {
                        valid--;
                    }
                    window.put(leftChar, window.getOrDefault(leftChar, 0) - 1);
                }
            }

        }
        return false;
    }

    public static void main(String[] args) {
        String s11 = "ab", s21 = "eidbaooo";
        System.out.println(new Solution().checkInclusion(s11, s21));

        String s12 = "aoo", s22 = "eidbaooo";
        System.out.println(new Solution().checkInclusion(s12, s22));

        String s13 = "ab", s23 = "eidboaoo";
        System.out.println(new Solution().checkInclusion(s13, s23));

        String s14 = "ab", s24 = "acb";
        System.out.println(new Solution().checkInclusion(s14, s24));

        String s15 = "a", s25 = "b";
        System.out.println(new Solution().checkInclusion(s15, s25));

        String s16 = "a", s26 = "a";
        System.out.println(new Solution().checkInclusion(s16, s26));

    }
}