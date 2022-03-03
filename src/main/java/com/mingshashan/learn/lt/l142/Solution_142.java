package com.mingshashan.learn.lt.l142;

/**
 * Given the head of a linked list, return the node where the cycle begins.
 * If there is no cycle, return null.
 * <p>
 * There is a cycle in a linked list if there is some node in the list
 * that can be reached again by continuously following the next pointer.
 * Internally, pos is used to denote the index of the node
 * that tail's next pointer is connected to (0-indexed).
 * It is -1 if there is no cycle. Note that pos is not passed as a parameter.
 * <p>
 * Do not modify the linked list.
 * <p>
 * The number of the nodes in the list is in the range [0, 104].
 * -105 <= Node.val <= 105
 * pos is -1 or a valid index in the linked-list.
 */
public class Solution_142 {
    public ListNode detectCycle(ListNode head) {
        if (null == head || null == head.next) {
            return null;
        }

        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (null == fast || null == slow) {
                return null;
            }

            if (fast == slow) {
                break;
            }
        }
        if (null == fast || null == fast.next) {
            return null;
        }

        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }
}