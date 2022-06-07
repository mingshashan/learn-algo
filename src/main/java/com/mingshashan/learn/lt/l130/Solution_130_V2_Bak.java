package com.mingshashan.learn.lt.l130;

/**
 * 130. Surrounded Regions
 * Given an m x n matrix board containing x and o,
 * capture all regions that are 4-directionally surrounded by x.
 * <p>
 * A region is captured by flipping all os into xs in that surrounded region.
 * <p>
 * union-find算法
 * <p>
 * 但这个问题也可以用 Union-Find 算法解决，虽然实现复杂一些，甚至效率也略低，但这是使用 Union-Find 算法的通用思想，值得一学。
 * <p>
 * 你可以把那些不需要被替换的 O 看成一个拥有独门绝技的门派，它们有一个共同「祖师爷」叫 dummy，这些 O 和 dummy 互相连通，而那些需要被替换的 O 与 dummy 不连通。
 */
public class Solution_130_V2_Bak {

    char CHAR_X = 'X';
    char CHAR_O = 'O';

    /**
     * @param board
     */
    public void solve(char[][] board) {
        if (null == board || 0 == board.length) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        int dummy = m * n;
        UF uf = new UF(m * n + 1);

        // 将首行、末行、首列、末列的'o'与dummy连接
        for (int i = 0; i < n; i++) {
            // 首行
            if (board[0][i] == CHAR_O) {
                uf.union(i, dummy);
            }
            // 末行
            if (board[m - 1][i] == CHAR_O) {
                uf.union((m - 1) * n + i, dummy);
            }
        }
        for (int i = 1; i < m - 1; i++) {
            // 首列
            if (board[i][0] == CHAR_O) {
                uf.union(i * n, dummy);
            }
            // 末列
            if (board[i][n - 1] == CHAR_O) {
                uf.union(i * n + n - 1, dummy);
            }
        }

        // 对其余的遍历
        // 方向数组：
        int[][] direction = new int[][]{{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (board[i][j] == CHAR_O) {
                    for (int k = 0; k < 4; k++) {
                        int x = i + direction[k][0];
                        int y = j + direction[k][1];
                        if (board[x][y] == CHAR_O) {
                            uf.union(x * n + y, i * n + j);
                        }
                    }
                }
            }
        }

        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (!uf.connected(i * n + j, dummy)) {
                    board[i][j] = CHAR_X;
                }
            }
        }

    }

    class UF {
        int count;
        int[] parent;

        public UF(int n) {
            this.count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        boolean connected(int p, int q) {
            int parentP = findParent(p);
            int parentQ = findParent(q);

            return parentP == parentQ;
        }

        void union(int p, int q) {
            int parentP = findParent(p);
            int parentQ = findParent(q);

            if (parentP == parentQ) {
                return;
            }

            parent[parentP] = parentQ;
        }

        int findParent(int x) {
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }
    }
}