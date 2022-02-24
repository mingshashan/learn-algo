package com.mingshashan.learn.lt.l283;

/**
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * <p>
 * Note that you must do this in-place without making a copy of the array.
 * <p>
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 * <p>
 * 快慢指针，快的往前走
 */
public class Solution_283 {
    public void moveZeroes(int[] nums) {
        if (1 == nums.length) {
            return;
        }

        int fast = 0, slow = 0;
        while (fast < nums.length) {
            if (nums[fast] != 0 && slow <= fast) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }

        int p = slow;
        for (; p < nums.length; p++) {
            nums[p] = 0;
        }
    }
}