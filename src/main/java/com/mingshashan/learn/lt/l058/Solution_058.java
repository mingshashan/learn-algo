package com.mingshashan.learn.lt.l058;

public class Solution_058 {

    public int lengthOfLastWord(String s) {
        if (null == s || 0 == s.length()) {
            return 0;
        }
        int length = s.length();
        int result = 0;
        int spaceFlag = 0;
        for (int i = length - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ' && spaceFlag == 0) {
                continue;
            }
            if (s.charAt(i) != ' ') {
                result++;
                spaceFlag = 1;
                continue;
            }
            if (s.charAt(i) == ' ' && spaceFlag == 1) {
                break;
            }
        }

        return result;
    }
}