package com.mingshashan.learn.lt;

import com.mingshashan.learn.lt.l1011.Solution_l1011;
import org.junit.Assert;
import org.junit.Test;

/**
 * Solution_l1011_Test
 *
 * @author mingshashan
 */
public class Solution_1011_Test {

    @Test
    public void solutionTest01() {
        int[] piles = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int h = 5;
        int result = new Solution_l1011().shipWithinDays(piles, h);
        int expect = 15;
        Assert.assertTrue("ok", result == expect);
    }

    @Test
    public void solutionTest02() {
        int[] piles = new int[]{3, 2, 2, 4, 1, 4};
        int h = 3;
        int result = new Solution_l1011().shipWithinDays(piles, h);
        int expect = 6;
        Assert.assertTrue("ok", result == expect);
    }

    @Test
    public void solutionTest03() {
        int[] piles = new int[]{1, 2, 3, 1, 1};
        int h = 4;
        int result = new Solution_l1011().shipWithinDays(piles, h);
        int expect = 3;
        Assert.assertTrue("ok", result == expect);
    }
}
