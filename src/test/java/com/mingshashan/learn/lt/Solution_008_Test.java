package com.mingshashan.learn.lt;

import com.mingshashan.learn.lt.l008.Solution_008;
import org.junit.Assert;
import org.junit.Test;

public class Solution_008_Test {

    @Test
    public void test_01() {
        String s = "42";
        int result = new Solution_008().myAtoi(s);
        int except = 42;
        Assert.assertEquals("ok", except, result);
    }

    @Test
    public void test_02() {
        String s = "   -42";
        int result = new Solution_008().myAtoi(s);
        int except = -42;
        Assert.assertEquals("ok", except, result);
    }

    @Test
    public void test_03() {
        String s = "4193 with words";
        int result = new Solution_008().myAtoi(s);
        int except = 4193;
        Assert.assertEquals("ok", except, result);
    }

    @Test
    public void test_04() {
        String s = "419ffdafasdf313412341231343123 with words";
        int result = new Solution_008().myAtoi(s);
        // MAX = 2147483647
        // MIN = 2147483648
        int except = 419;
        Assert.assertEquals("ok", except, result);
    }


    @Test
    public void test_05() {
        String s = "4341.bbaa-34 with words";
        int result = new Solution_008().myAtoi(s);
        int except = 4341;
        Assert.assertEquals("ok", except, result);
    }

    @Test
    public void test_06() {
        String s = "Hello World 996";
        int result = new Solution_008().myAtoi(s);
        int except = 0;
        Assert.assertEquals("ok", except, result);
    }

    @Test
    public void test_07() {
        String s = "000 - 1";
        int result = new Solution_008().myAtoi(s);
        int except = 0;
        Assert.assertEquals("ok", except, result);
    }

    @Test
    public void test_08() {
        String s = "000";
        int result = new Solution_008().myAtoi(s);
        int except = 0;
        Assert.assertEquals("ok", except, result);
    }

    @Test
    public void test_09() {
        String s = "+";
        int result = new Solution_008().myAtoi(s);
        int except = 0;
        Assert.assertEquals("ok", except, result);
    }

    @Test
    public void test_10() {
        String s = "-";
        int result = new Solution_008().myAtoi(s);
        int except = 0;
        Assert.assertEquals("ok", except, result);
    }

    @Test
    public void test_11() {
        String s = "-+";
        int result = new Solution_008().myAtoi(s);
        int except = 0;
        Assert.assertEquals("ok", except, result);
    }

    @Test
    public void test_12() {
        String s = "+ -";
        int result = new Solution_008().myAtoi(s);
        int except = 0;
        Assert.assertEquals("ok", except, result);
    }

    @Test
    public void test_13() {
        String s = "+ - 1";
        int result = new Solution_008().myAtoi(s);
        int except = 0;
        Assert.assertEquals("ok", except, result);
    }


    @Test
    public void test_14() {
        String s = "+ - a 1";
        int result = new Solution_008().myAtoi(s);
        int except = 0;
        Assert.assertEquals("ok", except, result);
    }

    @Test
    public void test_15() {
        String s = " ";
        int result = new Solution_008().myAtoi(s);
        int except = 0;
        Assert.assertEquals("ok", except, result);
    }
}
