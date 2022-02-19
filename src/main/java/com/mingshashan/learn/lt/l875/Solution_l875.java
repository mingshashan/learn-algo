package com.mingshashan.learn.lt.l875;

/**
 * Koko loves to eat bananas. There are n piles of bananas,
 * the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
 * <p>
 * Koko can decide her bananas-per-hour eating speed of k.
 * Each hour, she chooses some pile of bananas and eats k bananas from that pile.
 * If the pile has less than k bananas,
 * she eats all of them instead and will not eat any more bananas during this hour.
 * <p>
 * Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
 * <p>
 * <p>
 * Return the minimum integer k such that she can eat all the bananas within h hours.
 * <p>
 * 1 <= piles.length <= 104
 * piles.length <= h <= 109
 * 1 <= piles[i] <= 109
 */
public class Solution_l875 {
    public int minEatingSpeed(int[] piles, int h) {
        // 最慢一次吃1个，最块一次
        int left = 1;
        int right = 1000000000;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int t = findTimes(piles, mid);
            if (t == h) {
                right = mid - 1;
            }
            // 吃的太慢需要吃快点
            if (t > h) {
                left = mid + 1;
            }
            // 吃的太快需要吃慢点
            if (t < h) {
                right = mid - 1;
            }
        }
        return left;
    }

    int findTimes(int[] piles, int speed) {
        int t = 0;
        for (int i = 0; i < piles.length; i++) {
            t += piles[i] / speed;
            if (piles[i] % speed > 0) {
                t++;
            }
        }

        return t;
    }
}