package com.mingshashan.learn.lt.l206;

import com.mingshashan.learn.lt.common.ListNode;

public class Solution_206 {
    public ListNode reverseList(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }

        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }
}