package com.mingshashan.learn.lt.l004;

/**
 * 4. Median of Two Sorted Arrays
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 * <p>
 * The overall run time complexity should be O(log (m+n)).
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 * Example 2:
 * <p>
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 * <p>
 * l1 == m
 * l2 == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 */
public class Solution_004_V2 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0) {
            return 0;
        }
        int i = 0, j = 0, k = 0;
        int l1 = nums1.length;
        int l2 = nums2.length;
        int[] temp = new int[l1 + l2];

        while (i < l1 && j < l2) {
            if (nums1[i] < nums2[j]) {
                temp[k] = nums1[i];
                i++;
            } else {
                temp[k] = nums2[j];
                j++;
            }
            k++;
        }

        while (i < l1) {
            temp[k++] = nums1[i++];
        }
        while (j < l2) {
            temp[k++] = nums2[j++];
        }

        int mid = (l1 + l2) / 2;
        if ((l1 + l2) % 2 == 0) {
            return (temp[mid - 1] + temp[mid]) / 2.0;
        }

        return temp[mid];
    }
}