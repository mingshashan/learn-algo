package com.mingshashan.learn.lt;

import com.mingshashan.learn.lt.l287.Solution_287_V2;
import org.junit.Assert;
import org.junit.Test;

public class Solution_287_V2_Test {

    @Test
    public void test_01() {
        int[] nums = {1, 3, 4, 2, 2};
        int result = new Solution_287_V2().findDuplicate(nums);
        int except = 2;

        Assert.assertTrue("ok", result == except);
    }

    @Test
    public void test_02() {
        int[] nums = {3, 1, 3, 4, 2};
        int result = new Solution_287_V2().findDuplicate(nums);
        int except = 3;

        Assert.assertTrue("ok", result == except);
    }

    @Test
    public void test_03() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 10, 12, 13};
        int result = new Solution_287_V2().findDuplicate(nums);
        int except = 10;

        Assert.assertTrue("ok", result == except);
    }

    @Test
    public void test_04() {
        int[] nums = {1, 2, 3, 4, 5, 6, 2, 7, 8, 2};
        int result = new Solution_287_V2().findDuplicate(nums);
        int except = 2;

        Assert.assertTrue("ok", result == except);
    }

    @Test
    public void test_05() {
        int[] nums = {2, 2, 2, 2, 2, 2, 2};
        int result = new Solution_287_V2().findDuplicate(nums);
        int except = 2;

        Assert.assertTrue("ok", result == except);
    }
}
