package com.mingshashan.learn.lt.l704;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void testBinarySearch1() throws Exception {

        int[] nums = new int[]{1, 2, 3, 3, 4, 5, 6, 7, 8, 9, 10};
        int location = new Solution().search(nums, 7);
        Assert.assertTrue("ok", location == 7);
    }

    @Test
    public void testBinarySearch2() throws Exception {
        int[] nums = new int[]{-1, 0, 3, 5, 9, 12};
        int location = new Solution().search(nums, 9);
        Assert.assertTrue("ok", location == 4);
    }


    @Test
    public void testBinarySearch3() throws Exception {
        int[] nums = new int[]{-1, 0, 3, 5, 9, 12};
        int location = new Solution().search(nums, 2);
        Assert.assertTrue("ok", location == -1);
    }
}
