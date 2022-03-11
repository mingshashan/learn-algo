package com.mingshashan.learn.lt;

import com.mingshashan.learn.lt.l739.Solution_739;
import org.junit.Assert;
import org.junit.Test;

/**
 * Solution_739_Test
 *
 * @author mingshashan
 */
public class Solution_739_Test {

    @Test
    public void test_01() {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = new Solution_739().dailyTemperatures(temperatures);
        int[] expect = {1, 1, 4, 2, 1, 1, 0, 0};
        Assert.assertArrayEquals("ok", result, expect);
    }


    @Test
    public void test_02() {
        int[] temperatures = {30, 40, 50, 60};
        int[] result = new Solution_739().dailyTemperatures(temperatures);
        int[] expect = {1, 1, 1, 0};
        Assert.assertArrayEquals("ok", result, expect);
    }


    @Test
    public void test_03() {
        int[] temperatures = {30, 60, 90};
        int[] result = new Solution_739().dailyTemperatures(temperatures);
        int[] expect = {1, 1, 0};
        Assert.assertArrayEquals("ok", result, expect);
    }
}
