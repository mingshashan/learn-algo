package com.mingshashan.learn.lt;

import com.mingshashan.learn.lt.l283.Solution_283;
import org.junit.Assert;
import org.junit.Test;

/**
 * Solution_283_Test
 *
 * @author mingshashan
 */
public class Solution_283_Test {

    @Test
    public void test_01() {
        int[] nums = {0, 1, 0, 3, 12};
        int[] expect = {1, 3, 12, 0, 0};
        new Solution_283().moveZeroes(nums);

        Assert.assertArrayEquals("ok", expect, nums);
    }

    @Test
    public void test_02() {
        int[] nums = {0};
        int[] expect = {0};
        new Solution_283().moveZeroes(nums);

        Assert.assertArrayEquals("ok", expect, nums);
    }

    @Test
    public void test_03() {
        int[] nums = {0, 0, 0, 0, 0, 0, 1, 0, 1};
        int[] expect = {1, 1, 0, 0, 0, 0, 0, 0, 0};
        new Solution_283().moveZeroes(nums);

        Assert.assertArrayEquals("ok", expect, nums);
    }
}
