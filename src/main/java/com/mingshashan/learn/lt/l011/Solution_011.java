package com.mingshashan.learn.lt.l011;

public class Solution_011 {

    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;

        int res = 0;
        while (left < right) {
            int currentArea = Math.min(height[left], height[right]) * (right - left);
            res = Math.max(res, currentArea);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return res;
    }
}