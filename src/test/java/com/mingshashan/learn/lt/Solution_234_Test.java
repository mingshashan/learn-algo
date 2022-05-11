package com.mingshashan.learn.lt;

import com.mingshashan.learn.lt.common.ListNode;
import com.mingshashan.learn.lt.common.ListUtil;
import com.mingshashan.learn.lt.l234.Solution_234;
import org.junit.Assert;
import org.junit.Test;

public class Solution_234_Test {

    @Test
    public void test_01() {
        ListNode head = ListUtil.arrayToList(new int[]{1, 2, 2, 1});
        boolean result = new Solution_234().isPalindrome(head);
        boolean except = true;
        Assert.assertEquals("ok", except, result);
    }

    @Test
    public void test_02() {
        ListNode head = ListUtil.arrayToList(new int[]{1, 2});
        boolean result = new Solution_234().isPalindrome(head);
        boolean except = false;
        Assert.assertEquals("ok", except, result);
    }

    @Test
    public void test_03() {
        ListNode head = ListUtil.arrayToList(new int[]{1, 2, 3, 2, 1});
        boolean result = new Solution_234().isPalindrome(head);
        boolean except = true;
        Assert.assertEquals("ok", except, result);
    }

    @Test
    public void test_04() {
        ListNode head = ListUtil.arrayToList(new int[]{1});
        boolean result = new Solution_234().isPalindrome(head);
        boolean except = true;
        Assert.assertEquals("ok", except, result);
    }

    @Test
    public void test_05() {
        ListNode head = ListUtil.arrayToList(new int[]{1, 2, 3, 4, 4, 3, 2, 1});
        boolean result = new Solution_234().isPalindrome(head);
        boolean except = true;
        Assert.assertEquals("ok", except, result);
    }

    @Test
    public void test_06() {
        ListNode head = ListUtil.arrayToList(new int[]{1, 2, 3, 4, 4, 7});
        boolean result = new Solution_234().isPalindrome(head);
        boolean except = false;
        Assert.assertEquals("ok", except, result);
    }

    @Test
    public void test_07() {
        ListNode head = ListUtil.arrayToList(new int[]{1, 1, 2, 1});
        boolean result = new Solution_234().isPalindrome(head);
        boolean except = false;
        Assert.assertEquals("ok", except, result);
    }
}
