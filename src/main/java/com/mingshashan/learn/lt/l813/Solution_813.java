package com.mingshashan.learn.lt.l813;

/**
 * You are given an integer array nums and an integer k. You can partition the array into at most k non-empty adjacent subarrays. The score of a partition is the sum of the averages of each subarray.
 * <p>
 * Note that the partition must use every integer in nums, and that the score is not necessarily an integer.
 * <p>
 * Return the maximum score you can achieve of all the possible partitions. Answers within 10-6 of the actual answer will be accepted.
 */
public class Solution_813 {

    public double largestSumOfAverages(int[] nums, int k) {
        double[][] memo = new double[nums.length + 1][k + 1];
        double[] sum = new double[nums.length + 1];

        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
            memo[i][1] = sum[i] / i;
        }

        for (int i = 1; i <= nums.length; i++) {
            for (int p = 2; p <= k; p++) {
                for (int q = 0; q < i; q++) {
                    memo[i][p] = Math.max(memo[i][p], memo[q][p - 1] + (sum[i] - sum[q]) / (i - q));
                }
            }

        }
        return memo[nums.length][k];
    }
}