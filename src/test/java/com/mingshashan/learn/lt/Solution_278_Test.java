package com.mingshashan.learn.lt;

import com.mingshashan.learn.lt.l278.Solution_278;
import org.junit.Assert;
import org.junit.Test;

public class Solution_278_Test {

    @Test
    public void test_01() {
        int[] nums = {1, 3, 4, 2, 2};
        int result = new Solution_278().findDuplicate(nums);
        int except = 2;

        Assert.assertTrue("ok", result == except);
    }

    @Test
    public void test_02() {
        int[] nums = {3, 1, 3, 4, 2};
        int result = new Solution_278().findDuplicate(nums);
        int except = 3;

        Assert.assertTrue("ok", result == except);
    }

    @Test
    public void test_03() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 10, 12, 13};
        int result = new Solution_278().findDuplicate(nums);
        int except = 10;

        Assert.assertTrue("ok", result == except);
    }
}
