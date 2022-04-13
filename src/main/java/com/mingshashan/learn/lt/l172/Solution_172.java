package com.mingshashan.learn.lt.l172;

public class Solution_172 {
    public int trailingZeroes(int n) {

        int res = 0;
        for (int i = 5; i <= n; i *= 5) {
            res += n / i;
        }
        return res;
    }
}
