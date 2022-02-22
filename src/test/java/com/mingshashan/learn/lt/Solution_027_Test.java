package com.mingshashan.learn.lt;

import com.mingshashan.learn.lt.l027.Solution_027;
import org.junit.Assert;
import org.junit.Test;

/**
 * Solution_027_Test
 *
 * @author mingshashan
 */
public class Solution_027_Test {

    @Test
    public void test_01() {
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        int result = new Solution_027().removeElement(nums, val);
        int expect = 2;
        Assert.assertTrue("ok", result == expect);
    }

    @Test
    public void test_02() {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        int result = new Solution_027().removeElement(nums, val);
        int expect = 5;
        Assert.assertTrue("ok", result == expect);
    }
}
