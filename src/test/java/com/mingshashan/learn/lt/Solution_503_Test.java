package com.mingshashan.learn.lt;

import com.mingshashan.learn.lt.l503.Solution_503;
import org.junit.Assert;
import org.junit.Test;

/**
 * Solution_503_Test
 *
 * @author mingshashan
 */
public class Solution_503_Test {

    @Test
    public void test_01() {
        int[] nums = {1, 2, 1};
        int[] result = new Solution_503().nextGreaterElements(nums);
        int[] expect = {2, -1, 2};

        Assert.assertArrayEquals("ok", result, expect);
    }


    @Test
    public void test_02() {
        int[] nums = {1, 2, 3, 4, 3};
        int[] result = new Solution_503().nextGreaterElements(nums);
        int[] expect = {2, 3, 4, -1, 4};

        Assert.assertArrayEquals("ok", result, expect);
    }
}
