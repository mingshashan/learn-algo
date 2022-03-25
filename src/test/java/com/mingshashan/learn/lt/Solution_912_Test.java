package com.mingshashan.learn.lt;

import com.mingshashan.learn.lt.l912.Solution_912;
import org.junit.Assert;
import org.junit.Test;

public class Solution_912_Test {

    @Test
    public void test_01() {
        int[] nums = {5, 2, 3, 1};
        int[] result = new Solution_912().sortArray(nums);
        int[] expect = {1, 2, 3, 5};

        Assert.assertArrayEquals("ok", expect, result);
    }

    @Test
    public void test_02() {
        int[] nums = {5, 1, 1, 2, 0, 0};
        int[] result = new Solution_912().sortArray(nums);
        int[] expect = {0, 0, 1, 1, 2, 5};

        Assert.assertArrayEquals("ok", expect, result);
    }
}
