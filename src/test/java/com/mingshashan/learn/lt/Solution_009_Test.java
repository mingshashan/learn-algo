package com.mingshashan.learn.lt;

import com.mingshashan.learn.lt.l009.Solution_009;
import org.junit.Assert;
import org.junit.Test;

public class Solution_009_Test {

    @Test
    public void test_01() {
        int x = 121;
        boolean result = new Solution_009().isPalindrome(x);
        Assert.assertTrue("ok", result);
    }

    @Test
    public void test_02() {
        int x = -121;
        boolean result = new Solution_009().isPalindrome(x);
        Assert.assertFalse("ok", result);
    }

    @Test
    public void test_03() {
        int x = 11;
        boolean result = new Solution_009().isPalindrome(x);
        Assert.assertTrue("ok", result);
    }

    @Test
    public void test_04() {
        int x = 1231;
        boolean result = new Solution_009().isPalindrome(x);
        Assert.assertFalse("ok", result);
    }

    @Test
    public void test_05() {
        int x = 1001;
        boolean result = new Solution_009().isPalindrome(x);
        Assert.assertTrue("ok", result);
    }

}
