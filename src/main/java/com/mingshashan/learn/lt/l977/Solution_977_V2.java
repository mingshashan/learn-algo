package com.mingshashan.learn.lt.l977;

public class Solution_977_V2 {
    public int[] sortedSquares(int[] nums) {
        int firstNonnegativeIndex = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                firstNonnegativeIndex = i;
                break;
            }
        }

        int i1 = firstNonnegativeIndex - 1;
        int i2 = firstNonnegativeIndex;
        int i = 0;
        int[] result = new int[nums.length];
        while (i1 >= 0 && i2 < nums.length) {
            if (-nums[i1] >= nums[i2]) {
                result[i++] = nums[i2] * nums[i2];
                i2++;
            } else {
                result[i++] = nums[i1] * nums[i1];
                i1--;
            }
        }

        while (i1 >= 0) {
            result[i++] = nums[i1] * nums[i1];
            i1--;
        }
        while (i2 < nums.length) {
            result[i++] = nums[i2] * nums[i2];
            i2++;
        }
        return result;
    }

}