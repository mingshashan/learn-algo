package com.mingshashan.learn.lt.l088;

/**
 * 88. Merge Sorted Array
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing
 * order,
 * and two integers m and n, representing the number of elements in nums1 and
 * nums2 respectively.
 * <p>
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 * <p>
 * The final sorted array should not be returned by the function, but instead be
 * stored inside
 * the array nums1. To accommodate this, nums1 has a length of m + n,
 * where the first m elements denote the elements that should be merged,
 * and the last n elements are set to 0 and should be ignored. nums2 has a
 * length of n.
 * <p>
 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * Output: [1,2,2,3,5,6]
 * <p>
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -109 <= nums1[i], nums2[j] <= 109
 * <p>
 * Follow up: Can you come up with an algorithm that runs in O(m + n) time?
 * 1、可借助另一个数组
 */
public class Solution_088 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m + n == 0) {
            return;
        }

        int[] result = new int[m + n];
        int i1 = 0, i2 = 0, i = 0;
        while (i1 < m && i2 < n) {
            if (nums2[i2] <= nums1[i1]) {
                result[i++] = nums2[i2];
                i2++;
            } else {
                result[i++] = nums1[i1];
                i1++;
            }
        }
        if (i1 < m) {
            while (i1 < m) {
                result[i++] = nums1[i1++];
            }
        }
        if (i2 < n) {
            while (i2 < n) {
                result[i++] = nums2[i2++];
            }
        }

        for (int j = 0; j < m + n; j++) {
            nums1[j] = result[j];
        }
    }
}