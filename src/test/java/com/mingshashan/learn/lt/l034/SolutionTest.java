package com.mingshashan.learn.lt.l034;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void searchRange1() throws Exception {

        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int[] location = new com.mingshashan.learn.lt.l034.Solution().searchRange(nums, 8);
        Assert.assertArrayEquals("ok", location, new int[]{3, 4});
    }

    @Test
    public void searchRange2() throws Exception {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int[] location = new com.mingshashan.learn.lt.l034.Solution().searchRange(nums, 6);
        Assert.assertArrayEquals("ok", location, new int[]{-1, -1});
    }


    @Test
    public void searchRange3() throws Exception {
        int[] nums = new int[]{};
        int[] location = new com.mingshashan.learn.lt.l034.Solution().searchRange(nums, 2);
        Assert.assertArrayEquals("ok", location, new int[]{-1, -1});
    }
}
