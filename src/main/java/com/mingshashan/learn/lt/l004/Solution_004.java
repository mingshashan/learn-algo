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
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 */
class Solution_004 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0) {
            return 0;
        }
        if (nums1.length == 0) {
            return findMedianArray(nums1, 0, nums1.length);
        }
        if (nums2.length == 0) {
            return findMedianArray(nums2, 0, nums2.length);
        }

        // 二分法，从两个数组的中间开始找
        // [1, 3], [2, 5, 6, 7, 8] 这种情况，在num1中没找到，result = 5 / 2.0 = 2.5

        int l1 = nums1.length;
        int l2 = nums2.length;
        int totalLength = l1 + l2;
        // 初始
        int p1 = l1 / 2;
        int p2 = l2 / 2;

        int v1 = nums1[p1];
        int v2 = nums2[p2];

        // 两个指针，都向中间靠拢
        while (v1 < v2) {
            // [1,3], [2,5,7,8,9,10]
            if (p1 == nums1.length) {
                int mid = totalLength / 2;
                int left, right;
                if (totalLength % 2 == 0) {
                    right = mid - l1;
                    left = right - 1;
                    return findMedianArray(nums2, left, right);
                }
            }
            // [2,5,7,8,9,10], [1,3]
            if (p2 == nums2.length) {
                int mid = totalLength / 2;
                int left, right;
                if (totalLength % 2 == 0) {
                    right = mid - l2;
                    left = right - 1;
                    return findMedianArray(nums1, left, right);
                }
            }
            //[1,2,3,4,5,6], [7] -> [1,2,3,4,5,6,7] -> mid = 4 , result = 2.0


            // 一般情况什么时候算找到？
            // [1,3,7,11,13],[2,4,6,8,10], [1,2,3,4,6,7,8,10,11,13] -> 6,7

            // p1, p1-1, p1+1
            v1 = nums1[p1];

            // p2, p2-1, p2+1


//            if (p1 > 0 && p1 < l1 && p2 > 0 && p2 < l2) {
//                if ()
//            }


        }


        return 0;
    }

    private double findMedianArray(int[] nums, int start, int end) {
        if (nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        int mid = start + (end - start) / 2;
        if (length % 2 == 0) {
            return (nums[mid - 1] + nums[mid]) / 2.0;
        }

        return nums[mid] / 2.0;
    }

}