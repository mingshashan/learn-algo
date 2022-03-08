package com.mingshashan.learn.lt.l921;

public class Solution_921 {

    public int minAddToMakeValid(String s) {
        int leftNeed = 0;
        int rightNeed = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                rightNeed++;
            }

            if (c == ')') {
                rightNeed--;
                if (rightNeed == -1) {
                    rightNeed = 0;
                    leftNeed++;
                }
            }
        }

        return leftNeed + rightNeed;
    }
}