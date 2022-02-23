package com.mingshashan.learn.lt.l083;

/**
 * Given the head of a sorted linked list, delete all duplicates such that each
 * element appears only once. Return the linked list sorted as well.
 * <p>
 * 快慢指针
 * <p>
 * The number of nodes in the list is in the range [0, 300]
 * <p>
 * -100 <= Node.val <= 100
 */
public class Solution_083 {
    public ListNode deleteDuplicates(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }

        ListNode fast = head, slow = head;
        while (fast != null) {
            if (fast.val != slow.val) {
                slow = slow.next;
                slow.val = fast.val;
            }
            fast = fast.next;
        }
        slow.next = null;
        return head;
    }
}