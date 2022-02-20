package com.mingshashan.learn.lt.l1011;

/**
 * A conveyor belt has packages that must be shipped from one port to another within days days.
 * <p>
 * The ith package on the conveyor belt has a weight of weights[i].
 * Each day, we load the ship with packages on the conveyor belt (in the order given by weights).
 * We may not load more weight than the maximum weight capacity of the ship.
 * <p>
 * Return the least weight capacity of the ship that will result in all the packages
 * on the conveyor belt being shipped within days days.
 * <p>
 * 1 <= days <= weights.length <= 5 * 104
 * 1 <= weights[i] <= 500
 */
public class Solution_l1011 {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0, right = 0;
        for (int i = 0; i < weights.length; i++) {
            right += weights[i];
            left = left >= weights[i] ? left : weights[i];
        }

        int res = 0;
        while (left <= right) {
            // 一次运量
            int mid = left + (right - left) / 2;
            // 天数
            int d = cDays(weights, mid);
            // 相等，往左边找最小运量
            if (d == days) {
                right = mid - 1;
            }
            // 运的慢，往右边提升每天运量
            if (d > days) {
                left = mid + 1;
            }
            // 运的快，往左边减少每天运量
            if (d < days) {
                right = mid - 1;
            }
        }
        return left;
    }

    /**
     * @param weights 所有包裹
     * @param x       船的最大运载容量
     * @return
     */
    int cDays(int[] weights, int x) {
        int days = 0;
        for (int i = 0; i < weights.length; ) {
            int cap = x;
            while (i < weights.length) {
                if (cap < weights[i]) {
                    break;
                } else {
                    cap -= weights[i];
                }
                i++;
            }
            days++;
        }
        return days;
    }
}