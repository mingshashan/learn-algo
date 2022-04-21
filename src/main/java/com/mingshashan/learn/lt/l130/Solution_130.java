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
public class Solution_130 {

    private char x = 'X';
    private char o = 'O';
    private char temp = '#';

    // 行数
    int m;
    // 列数
    int n;

    public void solve(char[][] board) {
        if (null == board || 0 == board.length) {
            return;
        }
        m = board.length;
        n = board[0].length;

        // 循环遍历棋盘的四边
        // 第一行与最后一行
        for (int i = 0; i < n; i++) {
            // 第一行
            dfs(board, 0, i);
            // 最后一行
            dfs(board, m - 1, i);
        }

        // 第一列与最后一列（掐头去尾）
        for (int i = 1; i < m - 1; i++) {
            dfs(board, i, 0);
            dfs(board, i, n - 1);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // O -> X # -> O
                if (board[i][j] == o) {
                    board[i][j] = x;
                }
                if (board[i][j] == temp) {
                    board[i][j] = o;
                }
            }
        }
    }

    // 在二维数组中，一个元素[i,j]的周边坐标分别为
    // [i, j-1], [i, j+1], [i-1, j], [i+1, j]
    void dfs(char[][] board, int i, int j) {
        // 安全检查[i,j]需要在二维数组中
        if (i < 0 || j < 0) {
            return;
        }

        if (i >= m || j >= n) {
            return;
        }

        // 已经遍历过，则不需要再遍历
        if (board[i][j] == temp || board[i][j] == x) {
            return;
        }

        // 'O' 换成 '#'
        if (board[i][j] == o) {
            board[i][j] = temp;
        }

        // 四周遍历
        // [i, j-1], [i, j+1], [i-1, j], [i+1, j]
        dfs(board, i, j - 1);
        dfs(board, i, j + 1);
        dfs(board, i - 1, j);
        dfs(board, i + 1, j);
    }
}