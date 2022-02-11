package com.mingshashan.learn.lt.l1109;

import java.util.Arrays;

/**
 * There are n flights that are labeled from 1 to n.
 * <p>
 * You are given an array of flight bookings bookings,
 * where bookings[i] = [firsti, lasti, seatsi]
 * represents a booking for flights firsti through lasti (inclusive)
 * with seatsi seats reserved for each flight in the range.
 * <p>
 * Return an array answer of length n,
 * where answer[i] is the total number of seats reserved for flight i.
 */
public class Solution {

    class Difference {
        int nums[];
        int diff[];

        public Difference(int nums[]) {
            this.nums = nums;
            diff = new int[nums.length];
            diff[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                diff[i] = diff[i] - diff[i - 1];
            }
        }

        public void increment(int lIndex, int rIndex, int k) {
            diff[lIndex] += k;
            if (rIndex < nums.length - 1) {
                diff[rIndex + 1] -= k;
            }
        }

        public int[] result() {
            int res[] = new int[diff.length];
            res[0] = diff[0];
            for (int i = 1; i < diff.length; i++) {
                res[i] = res[i - 1] + diff[i];
            }

            return res;
        }
    }

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = 0;
        }

        Difference difference = new Difference(nums);

        for (int[] booking : bookings) {
            int lIndex = booking[0] - 1;
            int rIndex = booking[1] - 1;
            int k = booking[2];
            difference.increment(lIndex, rIndex, k);
        }

        return difference.result();
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};
        int n = 5;
        int[] res = new Solution().corpFlightBookings(nums, n);
        System.out.println(Arrays.toString(res));
    }
}