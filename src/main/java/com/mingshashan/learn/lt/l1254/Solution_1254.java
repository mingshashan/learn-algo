package com.mingshashan.learn.lt.l1254;

public class Solution_1254 {

    public int closedIsland(int[][] grid) {
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;

        // 先把四个边dfs的1变成'0'
        for (int i = 0; i < n; i++) {
            dfs(grid, 0, i);
            dfs(grid, m - 1, i);
        }
        for (int i = 1; i < m - 1; i++) {
            dfs(grid, i, 0);
            dfs(grid, i, n - 1);
        }

        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (grid[i][j] == 0) {
                    res++;
                    dfs(grid, i, j);
                }
            }
        }

        return res;
    }

    void dfs(int[][] grid, int x, int y) {
        int m = grid.length;
        int n = grid[0].length;
        if (x < 0 || y < 0 || x >= m || y >= n) {
            return;
        }

        if (grid[x][y] == 1) {
            return;
        }

        grid[x][y] = 1;
        dfs(grid, x - 1, y);
        dfs(grid, x + 1, y);
        dfs(grid, x, y - 1);
        dfs(grid, x, y + 1);
    }
}