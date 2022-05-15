package com.mingshashan.learn.lt.l278;

public class Solution_278 {

    int bad;

    public Solution_278(int bad) {
        this.bad = bad;
    }

    boolean isBadVersion(int version) {
        if (version >= bad) {
            return true;
        }
        return false;
    }

    public int firstBadVersion(int n) {

        int left = 1, right = n;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            mid = left + (right - left) / 2;
        }

        return mid;
    }

}