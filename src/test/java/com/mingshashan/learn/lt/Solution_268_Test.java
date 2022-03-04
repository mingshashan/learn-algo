package com.mingshashan.learn.lt;

import com.mingshashan.learn.lt.l268.Solution_268;
import org.junit.Assert;
import org.junit.Test;

public class Solution_268_Test {

    @Test
    public void test_01() {
        int[] nums = {3, 0, 1};
        int expect = 2;
        int result = new Solution_268().missingNumber(nums);

        Assert.assertTrue("ok", expect == result);
    }

    @Test
    public void test_02() {
        int[] nums = {0, 1};
        int expect = 2;
        int result = new Solution_268().missingNumber(nums);

        Assert.assertTrue("ok", expect == result);
    }

    @Test
    public void test_03() {
        int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        int expect = 8;
        int result = new Solution_268().missingNumber(nums);

        Assert.assertTrue("ok", expect == result);
    }
}
