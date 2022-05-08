package com.mingshashan.learn.lt;

import com.mingshashan.learn.lt.l007.Solution_007;
import org.junit.Assert;
import org.junit.Test;

public class Solution_007_Test {

    @Test
    public void test_01() {
        int x = 123;
        int result = new Solution_007().reverse(x);
        int except = 321;
        Assert.assertEquals("ok", except, result);
    }

    @Test
    public void test_02() {
        int x = -123;
        int result = new Solution_007().reverse(x);
        int except = -321;
        Assert.assertEquals("ok", except, result);
    }

    @Test
    public void test_03() {
        int x = 120;
        int result = new Solution_007().reverse(x);
        int except = 21;
        Assert.assertEquals("ok", except, result);
    }

    @Test
    public void test_04() {
        int x = -12000;
        int result = new Solution_007().reverse(x);
        int except = -21;
        Assert.assertEquals("ok", except, result);
    }

    @Test
    public void test_05() {
        int x = -12090;
        int result = new Solution_007().reverse(x);
        int except = -9021;
        Assert.assertEquals("ok", except, result);
    }

    @Test
    public void test_06() {
        int x = 10101010;
        int result = new Solution_007().reverse(x);
        int except = 1010101;
        Assert.assertEquals("ok", except, result);
    }

}
