package com.mingshashan.learn.lt.l160;

/**
 * Given the heads of two singly linked-lists headA and headB,
 * return the node at which the two lists intersect. If the two linked lists have no intersection at all,
 * return null.
 * <p>
 * For example, the following two linked lists begin to intersect at node c1:
 */
public class Solution_160_2 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {
            if (p1 == null) {
                p1 = headB;
            } else {
                p1 = p1.next;
            }

            if (p2 == null) {
                p2 = headA;
            } else {
                p2 = p2.next;
            }
        }

        return p1;
    }
}