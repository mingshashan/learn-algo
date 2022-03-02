package com.mingshashan.learn.lt;

import com.mingshashan.learn.lt.l141.ListNode;
import com.mingshashan.learn.lt.l141.Solution_141;
import org.junit.Assert;
import org.junit.Test;

/**
 * Solution_141_Test
 *
 * @author mingshashan
 */
public class Solution_141_Test {

    @Test
    public void test_01() {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;

        boolean result = new Solution_141().hasCycle(head);

        Assert.assertTrue("ok", result == true);
    }

    @Test
    public void test_02() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = head;

        boolean result = new Solution_141().hasCycle(head);

        Assert.assertTrue("ok", result == true);
    }

    @Test
    public void test_03() {
        ListNode head = new ListNode(1);

        boolean result = new Solution_141().hasCycle(head);

        Assert.assertTrue("ok", result == false);
    }


    @Test
    public void test_04() {
        ListNode head = new ListNode(1);
        head.next= new ListNode(2);

        boolean result = new Solution_141().hasCycle(head);

        Assert.assertTrue("ok", result == false);
    }
}
