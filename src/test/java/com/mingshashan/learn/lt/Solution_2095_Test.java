package com.mingshashan.learn.lt;

import com.mingshashan.learn.lt.l2095.ListNode;
import com.mingshashan.learn.lt.l2095.Solution_2095;
import org.junit.Assert;
import org.junit.Test;

/**
 * Slution_2095_Test
 *
 * @author mingshashan
 */
public class Solution_2095_Test {
    @Test
    public void test_01() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(7);
        head.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(6);

        ListNode except = new ListNode(1);
        except.next = new ListNode(3);
        except.next.next = new ListNode(4);
        except.next.next.next = new ListNode(1);
        except.next.next.next.next = new ListNode(2);
        except.next.next.next.next.next = new ListNode(6);

        ListNode result = new Solution_2095().deleteMiddle(head);

        Assert.assertTrue("ok", isSame(except, result));
    }

    @Test
    public void test_02() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        ListNode except = new ListNode(1);
        except.next = new ListNode(2);
        except.next.next = new ListNode(4);

        ListNode result = new Solution_2095().deleteMiddle(head);

        Assert.assertTrue("ok", isSame(except, result));
    }

    @Test
    public void test_03() {
        ListNode head = new ListNode(2);
        head.next = new ListNode(1);

        ListNode except = new ListNode(2);

        ListNode result = new Solution_2095().deleteMiddle(head);

        Assert.assertTrue("ok", isSame(except, result));
    }

    @Test
    public void test_04() {
        ListNode head = new ListNode(2);

        ListNode except = new ListNode(2);

        ListNode result = new Solution_2095().deleteMiddle(head);

        Assert.assertTrue("ok", isSame(except, result));
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
