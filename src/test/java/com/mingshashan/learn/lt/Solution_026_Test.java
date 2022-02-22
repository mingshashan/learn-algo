package com.mingshashan.learn.lt;

import com.mingshashan.learn.lt.l026.Solution_026;
import org.junit.Assert;
import org.junit.Test;

/**
 * Solution_026_Test
 *
 * @author mingshashan
 */
public class Solution_026_Test {

    @Test
    public void test_01() {
        int[] nums = {1, 1, 2};
        int result = new Solution_026().removeDuplicates(nums);
        int expect = 2;
        Assert.assertTrue("ok", result == expect);
    }

    @Test
    public void test_02() {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int result = new Solution_026().removeDuplicates(nums);
        int expect = 5;
        Assert.assertTrue("ok", result == expect);
    }
}
