package com.mingshashan.learn.lt;

import com.mingshashan.learn.lt.l207.Solution_207;
import org.junit.Assert;
import org.junit.Test;

public class Solution_207_Test {

    /**
     * 20
     * {{0,10},{3,18},{5,5},{6,11},{11,14},{13,1},{15,1},{17,4}}
     */
    @Test
    public void test_01() {
        int nums = 20;
        int[][] array = {{0, 10}, {3, 18}, {5, 5}, {6, 11}, {11, 14}, {13, 1}, {15, 1}, {17, 4}};
        boolean result = new Solution_207().canFinish(nums, array);
        Assert.assertTrue("ok", !result);
    }
}
