package com.mingshashan.learn.lt.l206;

import com.mingshashan.learn.lt.common.ListNode;

public class Solution_206_V2 {
    public ListNode reverseList(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }

        ListNode prev = null, cur = head, next;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}