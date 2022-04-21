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
public class Solution_130_V2 {


    private char x = 'X';
    private char o = 'O';

    public void solve(char[][] board) {
        if (board.length == 0) return;

        int m = board.length;
        int n = board[0].length;
        // 给 dummy 留一个额外位置
        UF uf = new UF(m * n + 1);
        int dummy = m * n;
        // 将首列和末列的 O 与 dummy 连通
        for (int i = 0; i < m; i++) {
            if (board[i][0] == o) uf.union(i * n, dummy);
            if (board[i][n - 1] == o) uf.union(i * n + n - 1, dummy);
        }
        // 将首行和末行的 O 与 dummy 连通
        for (int j = 0; j < n; j++) {
            if (board[0][j] == o) uf.union(j, dummy);
            if (board[m - 1][j] == o) uf.union(n * (m - 1) + j, dummy);
        }
        // 方向数组 d 是上下左右搜索的常用手法
        int[][] d = new int[][]{{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
        for (int i = 1; i < m - 1; i++)
            for (int j = 1; j < n - 1; j++)
                if (board[i][j] == o)
                    // 将此 O 与上下左右的 O 连通
                    for (int k = 0; k < 4; k++) {
                        int x = i + d[k][0];
                        int y = j + d[k][1];
                        if (board[x][y] == o) uf.union(x * n + y, i * n + j);
                    }
        // 所有不和 dummy 连通的 O，都要被替换
        for (int i = 1; i < m - 1; i++)
            for (int j = 1; j < n - 1; j++)
                if (!uf.connected(dummy, i * n + j)) board[i][j] = x;
    }


    class UF {

        /**
         * 记录连通分量
         */
        private int count;

        /**
         * 节点x的parent是parent[x]
         */
        private int[] parent;

        /**
         * 构造函数，n为图的节点数
         *
         * @param n
         */
        public UF(int n) {
            // 一开始互不连通
            this.count = n;

            // 父节点指针初始指向自己
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }


        /**
         * 将 p 和 q 连接
         */
        public void union(int p, int q) {
            int rootP = findRoot(p);
            int rootQ = findRoot(q);

            if (rootP == rootQ) {
                return;
            }
            parent[rootQ] = rootP;
            // 连通分量-1
            count--;
        }

        private int findRoot(int x) {
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }

            return x;
        }

        /**
         * 判断 p 和 q 是否连通
         */
        public boolean connected(int p, int q) {
            int rootP = findRoot(p);
            int rootQ = findRoot(q);

            return rootP == rootQ;
        }

        /**
         * 返回图中有多少个连通分量
         */
        public int count() {
            return count;
        }
    }

}