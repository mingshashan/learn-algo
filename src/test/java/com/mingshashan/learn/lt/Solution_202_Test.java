package com.mingshashan.learn.lt;

import com.mingshashan.learn.lt.l202.Solution_202;
import org.junit.Assert;
import org.junit.Test;

public class Solution_202_Test {

    @Test
    public void test_01() {
        boolean result = new Solution_202().isHappy(19);
        Assert.assertTrue("ok", result);
    }

    @Test
    public void test_02() {
        boolean result = new Solution_202().isHappy(2);
        Assert.assertTrue("ok", !result);
    }
}
