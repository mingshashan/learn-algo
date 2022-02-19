package com.mingshashan.learn.lt.l875;

import org.junit.Assert;
import org.junit.Test;

/**
 * Solution_l875_Test
 *
 * @author xufj
 */
public class Solution_l875_Test {

    @Test
    public void solutionTest01() {
        int[] piles = new int[]{3, 6, 7, 11};
        int h = 8;
        int result = new Solution_l875().minEatingSpeed(piles, h);
        int expect = 4;
        Assert.assertTrue("ok", result == expect);
    }

    @Test
    public void solutionTest02() {
        int[] piles = new int[]{30, 11, 23, 4, 20};
        int h = 5;
        int result = new Solution_l875().minEatingSpeed(piles, h);
        int expect = 30;
        Assert.assertTrue("ok", result == expect);
    }

    @Test
    public void solutionTest03() {
        int[] piles = new int[]{30, 11, 23, 4, 20};
        int h = 6;
        int result = new Solution_l875().minEatingSpeed(piles, h);
        int expect = 23;
        Assert.assertTrue("ok", result == expect);
    }

    @Test
    public void solutionTest04() {
        int[] piles = new int[]{312884470};
        int h = 312884469;
        int result = new Solution_l875().minEatingSpeed(piles, h);
        int expect = 2;
        Assert.assertTrue("ok", result == expect);
    }


}
