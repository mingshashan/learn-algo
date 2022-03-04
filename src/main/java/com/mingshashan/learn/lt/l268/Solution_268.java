package com.mingshashan.learn.lt.l268;

public class Solution_268 {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int expectSum = (1 + n) * n / 2;
        int realSum = 0;
        for (int i = 0; i < nums.length; i++) {
            realSum += nums[i];
        }

        return expectSum - realSum;
    }
}