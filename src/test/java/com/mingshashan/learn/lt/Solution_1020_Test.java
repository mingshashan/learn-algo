package com.mingshashan.learn.lt;

import com.mingshashan.learn.lt.l1020.Solution_1020;
import org.junit.Assert;
import org.junit.Test;

public class Solution_1020_Test {

    @Test
    public void test_01() {
        int[][] grid = {{0, 0, 0, 0}, {1, 0, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}};
        int result = new Solution_1020().numEnclaves(grid);
        int except = 3;
        Assert.assertEquals("ok", except, result);
    }

    @Test
    public void test_02() {
        int[][] grid = {{0, 1, 1, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}};
        int result = new Solution_1020().numEnclaves(grid);
        int except = 0;
        Assert.assertEquals("ok", except, result);
    }

}
