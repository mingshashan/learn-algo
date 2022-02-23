package com.mingshashan.learn.lt;

import com.mingshashan.learn.lt.l083.ListNode;
import com.mingshashan.learn.lt.l083.Solution_083;
import org.junit.Assert;
import org.junit.Test;

/**
 * Solution_083_Test
 *
 * @author mingshashan
 */
public class Solution_083_Test {

    @Test
    public void test_01() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        ListNode result = new Solution_083().deleteDuplicates(head);
        ListNode expect = new ListNode(1);
        expect.next = new ListNode(2);

        Assert.assertArrayEquals("ok",
                result.toList().toArray(new Integer[]{}),
                expect.toList().toArray(new Integer[]{}));

    }

    @Test
    public void test_02() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);
        ListNode result = new Solution_083().deleteDuplicates(head);
        ListNode expect = new ListNode(1);
        expect.next = new ListNode(2);
        expect.next.next = new ListNode(3);

        Assert.assertArrayEquals("ok",
                result.toList().toArray(new Integer[]{}),
                expect.toList().toArray(new Integer[]{}));

//        while (result != null && expect != null) {
//            Assert.assertTrue("ok", result.val == expect.val);
//            result = result.next;
//            expect = expect.next;
//
//            Assert.assertTrue("ok", (null == result && null == expect) || (
//                    null != result && null != expect));
//        }

    }
}
