package com.mingshashan.learn.lt;

import com.mingshashan.learn.lt.l200.Solution_200_V1;
import org.junit.Assert;
import org.junit.Test;

public class Solution_200_V1_Test {
    @Test
    public void test_01() {
        char[][] grid = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        int result = new Solution_200_V1().numIslands(grid);
        int except = 1;
        Assert.assertEquals("ok", except, result);
    }

    @Test
    public void test_02() {
        char[][] grid = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        int result = new Solution_200_V1().numIslands(grid);
        int except = 3;
        Assert.assertEquals("ok", except, result);
    }
}
