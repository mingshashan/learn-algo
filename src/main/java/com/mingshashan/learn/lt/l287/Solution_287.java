package com.mingshashan.learn.lt.l287;

public class Solution_287 {
    public int findDuplicate(int[] nums) {

        int fast = nums[0], slow = nums[0];

        while (fast <= nums.length - 1 && nums[fast] <= nums.length - 1) {
            fast = nums[fast];
            fast = nums[fast];
            slow = nums[slow];

            if (fast > nums.length - 1 || slow > nums.length - 1) {
                return -1;
            }

            if (fast == slow) {
                // 快慢指针相遇
                break;
            }
        }

        if (fast > nums.length - 1 || nums[fast] > nums.length - 1) {
            return -1;
        }

        fast = nums[0];

        while (fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }

        return fast;
    }

}