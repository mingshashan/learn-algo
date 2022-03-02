package com.mingshashan.learn.lt.l160;

/**
 * Given the heads of two singly linked-lists headA and headB,
 * return the node at which the two lists intersect. If the two linked lists have no intersection at all,
 * return null.
 * <p>
 * For example, the following two linked lists begin to intersect at node c1:
 */
public class Solution_160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0, lenB = 0;
        ListNode p1 = headA, p2 = headB;
        for (; p1 != null; p1 = p1.next) {
            lenA++;
        }
        for (; p2 != null; p2 = p2.next) {
            lenB++;
        }

        p1 = headA;
        p2 = headB;
        if (lenA > lenB) {
            for (int i = 0; i < lenA - lenB; i++) {
                p1 = p1.next;
            }
        }
        if (lenA < lenB) {
            for (int i = 0; i < lenB - lenA; i++) {
                p2 = p2.next;
            }
        }
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1;
    }
}