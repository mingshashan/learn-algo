package com.mingshashan.learn.lt.l438;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 字母异位词
 * <p>
 * Given two strings s and p, return an array of all the start indices of p's anagrams in s.
 * You may return the answer in any order.
 * <p>
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 * <p>
 * Input: s = "cbaebabacd", p = "abc"
 * Output: [0,6]
 * <p>
 * Input: s = "abab", p = "ab"
 * Output: [0,1,2]
 * <p>
 * 分析：其实还是滑动窗口的问题
 */
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> need = new HashMap<>(), window = new HashMap<>();
        for (char c : p.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        List<Integer> result = new LinkedList<>();
        int left = 0, right = 0;
        int valid = 0;
        while (right < s.length()) {
            char rightChar = s.charAt(right);
            right++;
            if (need.containsKey(rightChar)) {
                window.put(rightChar, window.getOrDefault(rightChar, 0) + 1);
                if (need.get(rightChar).equals(window.get(rightChar))) {
                    valid++;
                }
            }
            while (right - left >= p.length()) {
                // 如果有一个连续排列right-left = p.size
                if (valid == need.size()) {
                    result.add(left);
                }

                char leftChar = s.charAt(left);
                left++;
                if (need.containsKey(leftChar)) {
                    // 需要注意顺序，一定是先判断valid要不要-1
                    // 然后窗口是必需要更新的
                    if (window.get(leftChar).equals(need.get(leftChar))) {
                        valid--;
                    }
                    window.put(leftChar, window.getOrDefault(leftChar, 0) - 1);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";
        List<Integer> res1 = new Solution().findAnagrams(s, p);
        System.out.println(res1);
    }
}