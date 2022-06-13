package com.mingshashan.learn.lt;

import com.mingshashan.learn.lt.l813.Solution_813;
import org.junit.Assert;
import org.junit.Test;

public class Solution_813_Test {

    @Test
    public void test_01() {
        int[] nums = {9, 1, 2, 3, 9};
        int k = 3;

        double result = new Solution_813().largestSumOfAverages(nums, k);
        double except = 20.00000;
        Assert.assertEquals("ok", except, result, 0.000001);
    }

    @Test
    public void test_02() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 4;

        double result = new Solution_813().largestSumOfAverages(nums, k);
        double except = 20.50000;
        Assert.assertEquals("ok", except, result, 0.000001);
    }
}
