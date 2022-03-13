package com.mingshashan.learn.lt.l239;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution_239 {
    public int[] maxSlidingWindow(int[] nums, int k) {

        MonotonicQueue queue = new MonotonicQueue();
        List<Integer> re = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                queue.push(nums[i]);
            } else {
                queue.push(nums[i]);
                re.add(queue.max());
                queue.pop(nums[i - (k - 1)]);
            }
        }

        int[] result = new int[re.size()];
        for (int i = 0; i < re.size(); i++) {
            result[i] = re.get(i);
        }

        return result;
    }

    class MonotonicQueue {

        private LinkedList<Integer> q = new LinkedList<>();

        public void push(int n) {
            while (!q.isEmpty() && q.getLast() < n) {
                q.pollLast();
            }
            q.addLast(n);
        }

        public void pop(int n) {
            if (n == q.getFirst()) {
                q.pollFirst();
            }
        }

        public int max() {
            return q.getFirst();
        }
    }
}