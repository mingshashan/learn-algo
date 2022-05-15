package com.mingshashan.learn.lt;

import com.mingshashan.learn.lt.l278.Solution_278;
import org.junit.Assert;
import org.junit.Test;

public class Solution_278_Test {

    @Test
    public void test_01() {
        int n = 5;
        int bad = 4;
        int result = new Solution_278(bad).firstBadVersion(n);
        int except = 4;
        Assert.assertEquals("ok", except, result);
    }

    @Test
    public void test_02() {
        int n = 1;
        int bad = 1;
        int result = new Solution_278(bad).firstBadVersion(n);
        int except = 1;
        Assert.assertEquals("ok", except, result);
    }

    @Test
    public void test_03() {
        int n = 3;
        int bad = 2;
        int result = new Solution_278(bad).firstBadVersion(n);
        int except = 2;
        Assert.assertEquals("ok", except, result);
    }

    @Test
    public void test_04() {
        int n = 3000;
        int bad = 1786;
        int result = new Solution_278(bad).firstBadVersion(n);
        int except = 1786;
        Assert.assertEquals("ok", except, result);
    }
}
