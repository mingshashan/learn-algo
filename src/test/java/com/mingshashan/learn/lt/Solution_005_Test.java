package com.mingshashan.learn.lt;

import com.mingshashan.learn.lt.l005.Solution_005;
import org.junit.Assert;
import org.junit.Test;

public class Solution_005_Test {

    @Test
    public void test_01() {
        String s = "babad";
        String result = new Solution_005().longestPalindrome(s);
        String except = "bab";

        Assert.assertEquals("ok", except, result);
    }

    @Test
    public void test_02() {
        String s = "cbbd";
        String result = new Solution_005().longestPalindrome(s);
        String except = "bb";

        Assert.assertEquals("ok", except, result);
    }

    @Test
    public void test_03() {
        String s = "a";
        String result = new Solution_005().longestPalindrome(s);
        String except = "a";

        Assert.assertEquals("ok", except, result);
    }

}
