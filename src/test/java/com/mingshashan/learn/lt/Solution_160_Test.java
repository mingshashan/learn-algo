package com.mingshashan.learn.lt;

import com.mingshashan.learn.lt.l160.ListNode;
import com.mingshashan.learn.lt.l160.Solution_160;
import org.junit.Assert;
import org.junit.Test;

public class Solution_160_Test {

    @Test
    public void test_01() {
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = new ListNode(8);
        headA.next.next.next = new ListNode(4);
        headA.next.next.next.next = new ListNode(5);

        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = headA.next.next;

        ListNode expect = new ListNode(8);
        expect.next = new ListNode(4);
        expect.next.next = new ListNode(5);

        ListNode result = new Solution_160().getIntersectionNode(headA, headB);

        Assert.assertTrue("ok", isSame(expect, result));
    }

    private static boolean isSame(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return true;
        }

        while (list1 != null && list2 != null) {
            if (list1.val != list2.val) {
                return false;
            }
            list1 = list1.next;
            list2 = list2.next;
        }

        if (list1 != null || list2 != null) {
            return false;
        }

        return true;
    }

}
