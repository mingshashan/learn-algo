package com.mingshashan.learn.lt;

import com.mingshashan.learn.lt.l239.Solution_239;
import org.junit.Assert;
import org.junit.Test;

/**
 * Solution_239_Test
 *
 * @author mingshashan
 */
public class Solution_239_Test {

    @Test
    public void test_01() {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        int[] result = new Solution_239().maxSlidingWindow(nums, k);
        int[] expect = {3, 3, 5, 5, 6, 7};
        Assert.assertArrayEquals("ok", result, expect);
    }

    @Test
    public void test_02() {
        int[] nums = {1};
        int k = 1;

        int[] result = new Solution_239().maxSlidingWindow(nums, k);
        int[] expect = {1};
        Assert.assertArrayEquals("ok", result, expect);
    }
}
