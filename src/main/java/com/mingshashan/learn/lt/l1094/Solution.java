package com.mingshashan.learn.lt.l1094;

/**
 * There is a car with capacity empty seats.
 * The vehicle only drives east (i.e., it cannot turn around and drive west).
 * <p>
 * You are given the integer capacity and an array trips where trips[i] = [numPassengersi, fromi, toi]
 * indicates that the ith trip has numPassengersi passengers and the locations to pick them up and drop them off are fromi and toi respectively.
 * The locations are given as the number of kilometers due east from the car's initial location.
 * <p>
 * Return true if it is possible to pick up and drop off all passengers for all the given trips, or false otherwise.
 */
public class Solution {

    class Difference {
        int diff[];

        public Difference(int[] nums) {
            diff = new int[nums.length];

            diff[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                diff[i] = nums[i] - nums[i - 1];
            }
        }

        public void increment(int left, int right, int val) {
            diff[left] += val;
            if (right < diff.length - 1) {
                diff[right + 1] -= val;
            }
        }

        public int[] result() {
            int[] res = new int[diff.length];
            res[0] = diff[0];
            for (int i = 1; i < diff.length; i++) {
                res[i] = res[i - 1] + diff[i];
            }

            return res;
        }
    }

    public boolean carPooling(int[][] trips, int capacity) {
        int[] nums = new int[1001];
        Difference difference = new Difference(nums);
        for (int[] trip : trips) {
            int val = trip[0];
            int left = trip[1];
            int right = trip[2] - 1;
            difference.increment(left, right, val);
        }

        int[] res = difference.result();
        for (int i = 0; i < res.length; i++) {
            if (res[i] > capacity) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] trips1 = {{2, 1, 5}, {3, 3, 7}};
        int capacity1 = 4;
        boolean res1 = new Solution().carPooling(trips1, capacity1);
        System.out.println(false == res1);

        int[][] trips2 = {{2, 1, 5}, {3, 3, 7}};
        int capacity2 = 5;
        boolean res2 = new Solution().carPooling(trips2, capacity2);
        System.out.println(true == res2);


        int[][] trips3 = {{9, 0, 1}, {3, 3, 7}};
        int capacity3 = 4;
        boolean res3 = new Solution().carPooling(trips3, capacity3);
        System.out.println(false == res3);
    }
}