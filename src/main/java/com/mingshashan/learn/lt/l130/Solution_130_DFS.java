package com.mingshashan.learn.lt.l130;

/**
 * 130. Surrounded Regions
 * Given an m x n matrix board containing 'X' and 'O',
 * capture all regions that are 4-directionally surrounded by 'X'.
 * <p>
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 * <p>
 * 先用 for 循环遍历棋盘的四边，用 DFS 算法把那些与边界相连的 O 换成一个特殊字符，比如 #；
 * 然后再遍历整个棋盘，把剩下的 O 换成 X，把 # 恢复成 O。
 * 这样就能完成题目的要求，时间复杂度 O(MN)。
 */
public class Solution_130_DFS {

    private char CHAR_O = 'O';
    private char CHAR_X = 'X';
    private char CHAR_T = 'T';

    private int m;
    private int n;

    public void solve(char[][] board) {
        if (null == board || 0 == board.length) {
            return;
        }

        m = board.length;
        n = board[0].length;
        for (int i = 0; i < n; i++) {
            dfs(board, 0, i);
            dfs(board, m - 1, i);
        }

        for (int j = 1; j < m - 1; j++) {
            dfs(board, j, 0);
            dfs(board, j, n - 1);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == CHAR_O) {
                    board[i][j] = CHAR_X;
                }
                if (board[i][j] == CHAR_T) {
                    board[i][j] = CHAR_O;
                }
            }
        }
    }

    void dfs(char[][] board, int x, int y) {
        if (x < 0 || y < 0) {
            return;
        }
        if (x >= m || y >= n) {
            return;
        }
        if (board[x][y] == CHAR_T || board[x][y] == CHAR_X) {
            return;
        }
        if (board[x][y] == CHAR_O) {
            board[x][y] = CHAR_T;
        }

        // 遍历四周
        int[][] direction = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
        for (int k = 0; k < 4; k++) {
            int i = x + direction[k][0];
            int j = y + direction[k][1];
            dfs(board, i, j);
        }
    }
}