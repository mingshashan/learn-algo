package com.mingshashan.learn.lt.l876;

/**
 * Given the head of a singly linked list, return the middle node of the linked list.
 * <p>
 * If there are two middle nodes, return the second middle node.
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        ListNode dumpy = new ListNode(-1);
        dumpy.next = head;

        ListNode fast = dumpy, slow = dumpy;
        while (fast != null) {
            if (fast.next == null || fast.next.next == null) {
                break;
            }
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow.next;
    }
}