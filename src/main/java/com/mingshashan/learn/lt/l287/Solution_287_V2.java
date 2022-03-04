package com.mingshashan.learn.lt.l287;

public class Solution_287_V2 {
    public int findDuplicate(int[] nums) {
        int[] exist = new int[1000000];
        for (int i = 0; i < nums.length; i++) {
            if (exist[nums[i]] > 0) {
                return nums[i];
            }
            exist[nums[i]] = 1;
        }

        return -1;
    }

}