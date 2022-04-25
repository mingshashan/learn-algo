package com.mingshashan.learn.lt.l227;

/**
 * 不妨认为这两个人的编号分别是 cand 和 other，然后我们逐一分析每种情况，看看怎么排除掉一个人。
 * 对于情况一，cand 认识 other，所以 cand 肯定不是名人，排除。因为名人不可能认识别人。
 * 对于情况二，other 认识 cand，所以 other 肯定不是名人，排除。
 * 对于情况三，他俩互相认识，肯定都不是名人，可以随便排除一个。
 * 对于情况四，他俩互不认识，肯定都不是名人，可以随便排除一个。因为名人应该被所有其他人认识。
 */
public class Solution_227_V3 {
    // 可以直接调用，能够返回 i 是否认识 j
    boolean knows(int i, int j) {
        return false;
    }

    // 请你实现：返回「名人」的编号
    int findCelebrity(int n) {
        // 先假设candidate（从0开始）是名人
        int candidate = 0;
        for (int other = 1; other < n; other++) {
            if (!knows(other, candidate) || knows(candidate, other)) {
                // 如果other不认识candidate或者candidate认识other那么candidate肯定不是名人
                candidate = other;
            } else {
                // 不可能是名人，排除，什么都不用做
            }
        }

        // 现在的candidate是排除后的结果，但并不能保证一定是名人
        for (int other = 0; other < n; other++) {
            if (candidate == other) {
                continue;
            }

            if (!knows(other, candidate) || knows(candidate, other)) {
                return -1;
            }
        }
        return candidate;
    }
}
