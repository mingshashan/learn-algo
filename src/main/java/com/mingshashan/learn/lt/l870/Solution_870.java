package com.mingshashan.learn.lt.l870;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * You are given two integer arrays nums1 and nums2 both of the same length.
 * The advantage of nums1 with respect to nums2 is the number of indices i for
 * which nums1[i] > nums2[i].
 * <p>
 * Return any permutation of nums1 that maximizes its advantage with respect to nums2.
 * <p>
 * 1 <= nums1.length <= 105
 * nums2.length == nums1.length
 * 0 <= nums1[i], nums2[i] <= 109
 * <p>
 * Input: nums1 = [2,7,11,15], nums2 = [1,10,4,11]
 * Output: [2,11,7,15]
 * <p>
 * Input: nums1 = [12,24,8,32], nums2 = [13,25,32,11]
 * Output: [24,32,8,12]
 * <p>
 * 田忌赛马
 */
public class Solution_870 {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];

        int n = nums1.length;
        PriorityQueue<int[]> maxpq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });

        for (int i = 0; i < n; i++) {
            maxpq.offer(new int[]{i, nums2[i]});
        }

        Arrays.sort(nums1);

        int left = 0, right = n - 1;
        while (!maxpq.isEmpty()) {
            int[] q = maxpq.poll();
            int index = q[0];
            int iValue = q[1];
            if (iValue < nums1[right]) {
                result[index] = nums1[right];
                right--;
            } else {
                result[index] = nums1[left];
                left++;
            }
        }
        return result;
    }
}