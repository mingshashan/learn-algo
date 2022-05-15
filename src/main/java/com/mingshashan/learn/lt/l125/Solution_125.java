package com.mingshashan.learn.lt.l125;

/**
 * 125. Valid Palindrome
 * 1 <= s.length <= 2 * 105
 * s consists only of printable ASCII characters.
 */
public class Solution_125 {

    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isAlphabetic(c) || ('0' <= c && c <= '9')) {
                if (c >= 'A' && c <= 'Z') {
                    c += 0x20;
                    sb.append(c);
                } else {
                    sb.append(c);
                }

            }
        }

        String ns = sb.toString();
        if (1 >= ns.length()) {
            return true;
        }
        int length = ns.length();
        int left = 0, right = length - 1;
        while (left <= right) {
            if (ns.charAt(left) != ns.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}