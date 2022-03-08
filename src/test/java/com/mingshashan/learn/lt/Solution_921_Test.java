package com.mingshashan.learn.lt;

import com.mingshashan.learn.lt.l921.Solution_921;
import org.junit.Assert;
import org.junit.Test;

public class Solution_921_Test {

    @Test
    public void test_01() {
        String s = "())";
        int result = new Solution_921().minAddToMakeValid(s);
        int expect = 1;
        Assert.assertTrue("ok", result == expect);
    }

    @Test
    public void test_02() {
        String s = ")";
        int result = new Solution_921().minAddToMakeValid(s);
        int expect = 1;
        Assert.assertTrue("ok", result == expect);
    }

    @Test
    public void test_03() {
        String s = "()";
        int result = new Solution_921().minAddToMakeValid(s);
        int expect = 0;
        Assert.assertTrue("ok", result == expect);
    }

    @Test
    public void test_04() {
        String s = "))";
        int result = new Solution_921().minAddToMakeValid(s);
        int expect = 2;
        Assert.assertTrue("ok", result == expect);
    }

    @Test
    public void test_05() {
        String s = "))(";
        int result = new Solution_921().minAddToMakeValid(s);
        int expect = 3;
        Assert.assertTrue("ok", result == expect);
    }
}
