package com.mingshashan.learn.lt;

import com.mingshashan.learn.lt.l011.Solution_011;
import org.junit.Assert;
import org.junit.Test;

public class Solution_011_Test {

    @Test
    public void test_01() {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int result = new Solution_011().maxArea(height);
        int except = 49;
        Assert.assertEquals("ok", except, result);
    }

    @Test
    public void test_02() {
        int[] height = {1, 1};
        int result = new Solution_011().maxArea(height);
        int except = 1;
        Assert.assertEquals("ok", except, result);
    }
}
