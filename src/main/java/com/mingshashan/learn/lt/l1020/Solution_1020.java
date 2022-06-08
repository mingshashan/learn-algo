package com.mingshashan.learn.lt.l1020;

public class Solution_1020 {

    public int numEnclaves(int[][] grid) {
        if (null == grid || 0 == grid.length) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;

        // 首行、末行
        for (int i = 0; i < n; i++) {
            dfs(grid, 0, i);
            dfs(grid, m - 1, i);
        }
        // 首列、末列（除掉在首行、末行的列）
        for (int i = 1; i < m - 1; i++) {
            dfs(grid, i, 0);
            dfs(grid, i, n - 1);
        }

        int res = 0;
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (1 == grid[i][j]) {
                    res++;
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
        if (0 == grid[x][y]) {
            return;
        }
        grid[x][y] = 0;
        dfs(grid, x + 1, y);
        dfs(grid, x - 1, y);
        dfs(grid, x, y + 1);
        dfs(grid, x, y - 1);
    }
}