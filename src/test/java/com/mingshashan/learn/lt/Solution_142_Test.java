package com.mingshashan.learn.lt;

import com.mingshashan.learn.lt.l142.ListNode;
import com.mingshashan.learn.lt.l142.Solution_142;
import org.junit.Assert;
import org.junit.Test;

public class Solution_142_Test {

    @Test
    public void test_01() {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;

        ListNode result = new Solution_142().detectCycle(head);
        ListNode expect = head.next;
        Assert.assertTrue("ok", result == expect);
    }

    @Test
    public void test_02() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = head;

        ListNode result = new Solution_142().detectCycle(head);
        ListNode expect = head;
        Assert.assertTrue("ok", result == expect);
    }

    @Test
    public void test_03() {
        ListNode head = new ListNode(1);

        ListNode result = new Solution_142().detectCycle(head);
        ListNode expect = null;
        Assert.assertTrue("ok", result == expect);
    }


    @Test
    public void test_04() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);

        ListNode result = new Solution_142().detectCycle(head);
        ListNode expect = null;
        Assert.assertTrue("ok", result == expect);
    }


    @Test
    public void test_05() {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = new ListNode(-4);

        ListNode result = new Solution_142().detectCycle(head);
        ListNode expect = null;
        Assert.assertTrue("ok", result == expect);
    }


}
