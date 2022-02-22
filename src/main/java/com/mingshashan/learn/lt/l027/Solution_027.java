package com.mingshashan.learn.lt.l027;

/**
 * Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The relative order of the elements may be changed.
 * <p>
 * Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.
 * <p>
 * Return k after placing the final result in the first k slots of nums.
 * <p>
 * Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * 不能简单的统计重复数，还要保证nums，前k个数正确
 * <p>
 * 0 <= nums.length <= 100
 * 0 <= nums[i] <= 50
 * 0 <= val <= 100
 */
public class Solution_027 {
    public int removeElement(int[] nums, int val) {
        if (0 == nums.length) {
            return 0;
        }

        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] != val && left <= right) {
                nums[left] = nums[right];
                left++;
            }
            right++;
        }

        return left;
    }
}