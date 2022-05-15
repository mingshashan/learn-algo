package com.mingshashan.learn.lt;

import com.mingshashan.learn.lt.l125.Solution_125;
import org.junit.Assert;
import org.junit.Test;

public class Solution_125_Test {

    @Test
    public void test_01() {
        String s = "A man, a plan, a canal: Panama";
        boolean result = new Solution_125().isPalindrome(s);
        boolean except = true;
        Assert.assertEquals("ok", except, result);
    }

    @Test
    public void test_02() {
        String s = "race a car";
        boolean result = new Solution_125().isPalindrome(s);
        boolean except = false;
        Assert.assertEquals("ok", except, result);
    }

    @Test
    public void test_03() {
        String s = " ";
        boolean result = new Solution_125().isPalindrome(s);
        boolean except = true;
        Assert.assertEquals("ok", except, result);
    }

    @Test
    public void test_04() {
        String s = "0P";
        boolean result = new Solution_125().isPalindrome(s);
        boolean except = false;
        Assert.assertEquals("ok", except, result);
    }


}
