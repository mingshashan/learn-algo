package com.mingshashan.learn.lt;

import com.mingshashan.learn.lt.l556.Solution_556;
import org.junit.Assert;
import org.junit.Test;

/**
 * Solution_556_Test
 *
 * @author mingshashan
 */
public class Solution_556_Test {

    @Test
    public void test_01() {
        int n = 12;
        int result = new Solution_556().nextGreaterElement(n);
        int expect = 21;

        Assert.assertTrue("ok", result == expect);
    }


    @Test
    public void test_02() {
        int n = 21;
        int result = new Solution_556().nextGreaterElement(n);
        int expect = -1;

        Assert.assertTrue("ok", result == expect);
    }


    @Test
    public void test_03() {
        int n = 2111121;
        int result = new Solution_556().nextGreaterElement(n);
        int expect = 2111211;

        Assert.assertTrue("ok", result == expect);
    }

    @Test
    public void test_04() {
        int n = 33211111;
        int result = new Solution_556().nextGreaterElement(n);
        int expect = -1;

        Assert.assertTrue("ok", result == expect);
    }

    @Test
    public void test_05() {
        int n = 230241;
        int result = new Solution_556().nextGreaterElement(n);
        int expect = 230412;

        Assert.assertTrue("ok", result == expect);
    }
}
