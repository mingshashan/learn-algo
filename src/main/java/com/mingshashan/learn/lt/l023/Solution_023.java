package com.mingshashan.learn.lt.l023;

import java.util.PriorityQueue;

public class Solution_023 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (null == lists || 0 == lists.length) {
            return null;
        }

        PriorityQueue<ListNode> pq = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        for (ListNode node : lists) {
            if (null != node) {
                pq.offer(node);
            }
        }

        ListNode dumpy = new ListNode(-1), p = dumpy;
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            p.next = node;
            if (null != node.next) {
                pq.offer(node.next);
            }
            p = p.next;
        }

        return dumpy.next;
    }
}