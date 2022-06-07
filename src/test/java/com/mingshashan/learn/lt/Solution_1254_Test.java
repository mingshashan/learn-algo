package com.mingshashan.learn.lt;

import com.mingshashan.learn.lt.l1254.Solution_1254;
import org.junit.Assert;
import org.junit.Test;

public class Solution_1254_Test {

    @Test
    public void test_01() {
        int[][] grid = {{1, 1, 1, 1, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 1, 0, 1}, {1, 1, 1, 1, 1, 1, 1, 0}};
        int result = new Solution_1254().closedIsland(grid);
        int except = 2;
        Assert.assertEquals("ok", except, result);
    }

    @Test
    public void test_02() {
        int[][] grid = {{0, 0, 1, 0, 0}, {0, 1, 0, 1, 0}, {0, 1, 1, 1, 0}};
        int result = new Solution_1254().closedIsland(grid);
        int except = 1;
        Assert.assertEquals("ok", except, result);
    }
}
