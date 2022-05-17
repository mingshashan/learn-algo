package com.mingshashan.learn.lt;

import com.mingshashan.learn.lt.l977.Solution_977;
import org.junit.Assert;
import org.junit.Test;

public class Solution_977_Test {
    @Test
    public void test_01() {
        int[] nums = {-4, -1, 0, 3, 10};
        int[] result = new Solution_977().sortedSquares(nums);
        int[] except = {0, 1, 9, 16, 100};
        Assert.assertArrayEquals("ok", except, result);
    }

    @Test
    public void test_02() {
        int[] nums = {-7, -3, 2, 3, 11};
        int[] result = new Solution_977().sortedSquares(nums);
        int[] except = {4, 9, 9, 49, 121};
        Assert.assertArrayEquals("ok", except, result);
    }

    @Test
    public void test_03() {
        int[] nums = {-5, -3, -2, -1};
        int[] result = new Solution_977().sortedSquares(nums);
        int[] except = {1, 4, 9, 25};
        Assert.assertArrayEquals("ok", except, result);
    }

    @Test
    public void test_04() {
        int[] nums = {1, 2, 3, 5};
        int[] result = new Solution_977().sortedSquares(nums);
        int[] except = {1, 4, 9, 25};
        Assert.assertArrayEquals("ok", except, result);
    }
}
