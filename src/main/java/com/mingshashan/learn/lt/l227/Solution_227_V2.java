package com.mingshashan.learn.lt.l227;

import java.util.LinkedList;

/**
 * 不妨认为这两个人的编号分别是 cand 和 other，然后我们逐一分析每种情况，看看怎么排除掉一个人。
 * <p>
 * 对于情况一，cand 认识 other，所以 cand 肯定不是名人，排除。因为名人不可能认识别人。
 * <p>
 * 对于情况二，other 认识 cand，所以 other 肯定不是名人，排除。
 * <p>
 * 对于情况三，他俩互相认识，肯定都不是名人，可以随便排除一个。
 * <p>
 * 对于情况四，他俩互不认识，肯定都不是名人，可以随便排除一个。因为名人应该被所有其他人认识。
 */
public class Solution_227_V2 {
    // 可以直接调用，能够返回 i 是否认识 j
    boolean knows(int i, int j) {
        return false;
    }

    // 请你实现：返回「名人」的编号
    int findCelebrity(int n) {
        if (n == 1) {
            return 0;
        }

        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queue.addLast(i);
        }
        while (queue.size() >= 2) {
            int candidate = queue.removeFirst();
            int other = queue.removeFirst();
            if (knows(candidate, other) || !knows(other, candidate)) {
                // candidate 不可能是名人，排除，让 other 归队
                queue.addFirst(other);
            } else {
                // other不可能是名人，让candidate归队
                queue.addFirst(candidate);
            }
        }

        // 现在排除得只剩一个候选人，判断他是否真的是名人
        int candidate = queue.removeFirst();
        for (int other = 0; other < n; other++) {
            if (other == candidate) {
                continue;
            }
            if (!knows(other, candidate) || knows(candidate, other)) {
                return -1;
            }
        }

        return candidate;
    }
}
