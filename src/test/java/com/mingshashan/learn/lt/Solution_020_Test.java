package com.mingshashan.learn.lt;

import com.mingshashan.learn.lt.l020.Solution_020;
import org.junit.Assert;
import org.junit.Test;

/**
 * Solution_020_Test
 *
 * @author mingshashan
 */
public class Solution_020_Test {

    @Test
    public void test_01() {
        String s = "()";
        boolean result = new Solution_020().isValid(s);
        boolean except = true;
        Assert.assertTrue("ok", result == except);
    }

    @Test
    public void test_02() {
        String s = "()[]{}";
        boolean result = new Solution_020().isValid(s);
        boolean except = true;
        Assert.assertTrue("ok", result == except);
    }

    @Test
    public void test_03() {
        String s = "(]";
        boolean result = new Solution_020().isValid(s);
        boolean except = false;
        Assert.assertTrue("ok", result == except);
    }


    @Test
    public void test_04() {
        String s = ")(){}";
        boolean result = new Solution_020().isValid(s);
        boolean except = false;
        Assert.assertTrue("ok", result == except);
    }
}
