package com.mingshashan.learn.lt;

import com.mingshashan.learn.lt.l010.Solution_010_V1;
import org.junit.Assert;
import org.junit.Test;

public class Solution_010_V1_Test {

    @Test
    public void test_01() {
        String s = "aa", p = "a";
        boolean result = new Solution_010_V1().isMatch(s, p);
        boolean except = false;
        Assert.assertEquals("ok", except, result);
    }

    @Test
    public void test_02() {
        String s = "aa", p = "a*";
        boolean result = new Solution_010_V1().isMatch(s, p);
        boolean except = true;
        Assert.assertEquals("ok", except, result);
    }

    @Test
    public void test_03() {
        String s = "ab", p = ".*";
        boolean result = new Solution_010_V1().isMatch(s, p);
        boolean except = true;
        Assert.assertEquals("ok", except, result);
    }

    // aabcc, aabc
    @Test
    public void test_04() {
        String s = "aabcc", p = "aabc";
        boolean result = new Solution_010_V1().isMatch(s, p);
        boolean except = false;
        Assert.assertEquals("ok", except, result);
    }

    // aaa .*,
    @Test
    public void test_05() {
        String s = "aabcc", p = "aabc.";
        boolean result = new Solution_010_V1().isMatch(s, p);
        boolean except = true;
        Assert.assertEquals("ok", except, result);
    }

    @Test
    public void test_06() {
        String s = "aabcc", p = "aabc.*";
        boolean result = new Solution_010_V1().isMatch(s, p);
        boolean except = true;
        Assert.assertEquals("ok", except, result);
    }

    // aaaaa a*
    @Test
    public void test_07() {
        String s = "aaaaaaaaa", p = "a*";
        boolean result = new Solution_010_V1().isMatch(s, p);
        boolean except = true;
        Assert.assertEquals("ok", except, result);
    }

    @Test
    public void test_08() {
        String s = "aaab", p = "a*";
        boolean result = new Solution_010_V1().isMatch(s, p);
        boolean except = false;
        Assert.assertEquals("ok", except, result);
    }
    // abc a.*

    @Test
    public void test_09() {
        String s = "abc", p = "a.*";
        boolean result = new Solution_010_V1().isMatch(s, p);
        boolean except = true;
        Assert.assertEquals("ok", except, result);
    }

    @Test
    public void test_10() {
        String s = "abcdefg", p = ".*";
        boolean result = new Solution_010_V1().isMatch(s, p);
        boolean except = true;
        Assert.assertEquals("ok", except, result);
    }

    @Test
    public void test_11() {
        String s = "aaacd", p = "a*.d";
        boolean result = new Solution_010_V1().isMatch(s, p);
        boolean except = true;
        Assert.assertEquals("ok", except, result);
    }

    // abcabc a*b*c*a*b*c*
    //
    @Test
    public void test_12() {
        String s = "abcabc", p = "a*b*c*a*b*c*";
        boolean result = new Solution_010_V1().isMatch(s, p);
        boolean except = true;
        Assert.assertEquals("ok", except, result);
    }

    @Test
    public void test_13() {
        String s = "aab", p = "c*a*b";
        boolean result = new Solution_010_V1().isMatch(s, p);
        boolean except = true;
        Assert.assertEquals("ok", except, result);
    }

    @Test
    public void test_14() {
        String s = "ab", p = ".*c";
        boolean result = new Solution_010_V1().isMatch(s, p);
        boolean except = false;
        Assert.assertEquals("ok", except, result);
    }

    @Test
    public void test_15() {
        String s = "abcde", p = ".*";
        boolean result = new Solution_010_V1().isMatch(s, p);
        boolean except = true;
        Assert.assertEquals("ok", except, result);
    }

    @Test
    public void test_16() {
        String s = "aaa", p = "a*a";
        boolean result = new Solution_010_V1().isMatch(s, p);
        boolean except = true;
        Assert.assertEquals("ok", except, result);
    }

    @Test
    public void test_17() {
        String s = "aaaaa", p = "a*a.";
        boolean result = new Solution_010_V1().isMatch(s, p);
        boolean except = true;
        Assert.assertEquals("ok", except, result);
    }

    @Test
    public void test_18() {
        String s = "aaaaa", p = "a*a.a";
        boolean result = new Solution_010_V1().isMatch(s, p);
        boolean except = true;
        Assert.assertEquals("ok", except, result);
    }

    @Test
    public void test_19() {
        String s = "aaaaa", p = "a*a.b";
        boolean result = new Solution_010_V1().isMatch(s, p);
        boolean except = false;
        Assert.assertEquals("ok", except, result);
    }

    @Test
    public void test_20() {
        String s = "aaaaab", p = "a*a.b";
        boolean result = new Solution_010_V1().isMatch(s, p);
        boolean except = true;
        Assert.assertEquals("ok", except, result);
    }

    @Test
    public void test_21() {
        String s = "aaaaabc", p = "a*a.bc";
        boolean result = new Solution_010_V1().isMatch(s, p);
        boolean except = true;
        Assert.assertEquals("ok", except, result);
    }
}
