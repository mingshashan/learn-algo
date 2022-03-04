package com.mingshashan.learn.lt;

import com.mingshashan.learn.lt.l136.Solution_136;
import org.junit.Assert;
import org.junit.Test;

public class Solution_136_Test {

    @Test
    public void test_01() {
        int[] nums = {2, 2, 1};
        int expect = 1;
        int result = new Solution_136().singleNumber(nums);
        Assert.assertTrue("ok", expect == result);
    }

    @Test
    public void test_02() {
        int[] nums = {4,1,2,1,2};
        int expect = 4;
        int result = new Solution_136().singleNumber(nums);
        Assert.assertTrue("ok", expect == result);
    }

    @Test
    public void test_03() {
        int[] nums = {1};
        int expect = 1;
        int result = new Solution_136().singleNumber(nums);
        Assert.assertTrue("ok", expect == result);
    }
}
