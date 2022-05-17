package com.mingshashan.learn.lt.l977;

public class Solution_977 {

    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int i1 = 0, i2 = nums.length - 1;
        int i = nums.length - 1;
        while (i1 <= i2) {
            int v1 = nums[i1] * nums[i1];
            int v2 = nums[i2] * nums[i2];
            if (v1 >= v2) {
                result[i--] = v1;
                i1++;
            } else {
                result[i--] = v2;
                i2--;
            }
        }

        return result;
    }
}