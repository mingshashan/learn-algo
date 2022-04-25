package com.mingshashan.learn.lt.l227;

public class Solution_227_V1 {
    // 可以直接调用，能够返回 i 是否认识 j
    boolean knows(int i, int j) {
        return false;
    }

    // 请你实现：返回「名人」的编号
    int findCelebrity(int n) {
        for (int candidate = 0; candidate < n; candidate++) {
            int other;
            for (other = 0; other < n; other++) {
                if (candidate == other) {
                    continue;
                }

                if (knows(candidate, other) || !knows(other, candidate)) {
                    break;
                }
            }

            if (other == n) {
                return candidate;
            }
        }

        return -1;
    }
}
