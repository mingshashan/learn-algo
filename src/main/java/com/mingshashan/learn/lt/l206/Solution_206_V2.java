package com.mingshashan.learn.lt.l206;

import com.mingshashan.learn.lt.common.ListNode;

public class Solution_206_V2 {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null, next;
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}