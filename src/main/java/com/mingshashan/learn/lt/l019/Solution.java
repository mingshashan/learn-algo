package com.mingshashan.learn.lt.l019;

/**
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 * <p>
 * <p>
 * The number of nodes in the list is sz.
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 */
public class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (null == head) {
            return null;
        }

        ListNode dumpy = new ListNode(-1);
        dumpy.next = head;

        // 找到前一个节点，
        ListNode node = findNthFromEnd(dumpy, n + 1);
        node.next = node.next.next;
        return dumpy.next;
    }

    private ListNode findNthFromEnd(ListNode head, int n) {
        ListNode p1 = head, p2 = head;
        for (int i = 0; i < n; i++) {
            p1 = p1.next;
        }
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p2;
    }
}