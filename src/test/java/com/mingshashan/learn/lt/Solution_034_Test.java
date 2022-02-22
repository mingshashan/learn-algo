package com.mingshashan.learn.lt;

import com.mingshashan.learn.lt.l034.Solution_034;
import org.junit.Assert;
import org.junit.Test;

public class Solution_034_Test {

    @Test
    public void searchRange1() throws Exception {

        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int[] location = new Solution_034().searchRange(nums, 8);
        Assert.assertArrayEquals("ok", location, new int[]{3, 4});
    }

    @Test
    public void searchRange2() throws Exception {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int[] location = new Solution_034().searchRange(nums, 6);
        Assert.assertArrayEquals("ok", location, new int[]{-1, -1});
    }


    @Test
    public void searchRange3() throws Exception {
        int[] nums = new int[]{};
        int[] location = new Solution_034().searchRange(nums, 2);
        Assert.assertArrayEquals("ok", location, new int[]{-1, -1});
    }
}
