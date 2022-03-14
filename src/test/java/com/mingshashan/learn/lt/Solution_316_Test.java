package com.mingshashan.learn.lt;

import com.mingshashan.learn.lt.l316.Solution_316;
import org.junit.Assert;
import org.junit.Test;

public class Solution_316_Test {

    @Test
    public void test_01() {
        String s = "bcabc";
        String result = new Solution_316().removeDuplicateLetters(s);
        String expect = "abc";

        Assert.assertTrue("ok", result.equals(expect));
    }

    @Test
    public void test_02() {
        String s = "cbacdcbc";
        String result = new Solution_316().removeDuplicateLetters(s);
        String expect = "acdb";

        Assert.assertTrue("ok", result.equals(expect));
    }
}
