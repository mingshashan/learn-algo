package com.mingshashan.learn.lt;

import com.mingshashan.learn.lt.l021.ListNode;
import com.mingshashan.learn.lt.l021.Solution_021;
import org.junit.Assert;
import org.junit.Test;

/**
 * Solution_021_Test
 *
 * @author mingshashan
 */
public class Solution_021_Test {

    @Test
    public void test_01() {
        ListNode p1 = new ListNode(1);
        p1.next = new ListNode(2);
        p1.next.next = new ListNode(4);

        ListNode p2 = new ListNode(1);
        p2.next = new ListNode(3);
        p2.next.next = new ListNode(4);

        ListNode result = new Solution_021().mergeTwoLists(p1, p2);
        ListNode expect = new ListNode(1);
        expect.next = new ListNode(1);
        expect.next.next = new ListNode(2);
        expect.next.next.next = new ListNode(3);
        expect.next.next.next.next = new ListNode(4);
        expect.next.next.next.next.next = new ListNode(4);

        Assert.assertTrue("ok", isSame(result, expect));
    }

    @Test
    public void test_02() {
        ListNode p1 = null;

        ListNode p2 = null;

        ListNode result = new Solution_021().mergeTwoLists(p1, p2);
        ListNode expect = null;

        Assert.assertTrue("ok", isSame(result, expect));
    }

    @Test
    public void test_03() {
        ListNode p1 = null;

        ListNode p2 = new ListNode(0);

        ListNode result = new Solution_021().mergeTwoLists(p1, p2);
        ListNode expect = new ListNode(0);

        Assert.assertTrue("ok", isSame(result, expect));
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
