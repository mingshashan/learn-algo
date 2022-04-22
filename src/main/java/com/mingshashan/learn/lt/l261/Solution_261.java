package com.mingshashan.learn.lt.l261;

/**
 * 给你输入编号从 0 到 n - 1 的 n 个结点，和一个无向边列表 edges（每条边用节点二元组表示），
 * 请你判断输入的这些边组成的结构是否是一棵树。
 * <p>
 * n = 5
 * edges = [[0,1], [0,2], [0,3], [1,4]]
 * return true
 * <p>
 * n = 5
 * edges = [[0,1],[1,2],[2,3],[1,3],[1,4]]
 * return false
 */
public class Solution_261 {

    boolean validTree(int n, int[][] edges) {

        UF uf = new UF(n);
        for (int i = 0; i < edges.length; i++) {
            int[] peer = edges[i];
            if (!uf.connected(peer[0], peer[1])) {
                return false;
            }
            uf.union(peer[0], peer[1]);
        }

        return uf.count() == 1;
    }

    class UF {
        // 记录连通分量
        private int count;
        // 父节点数组，x节点的父节点为parent[x]
        private int[] parent;

        public UF(int n) {
            this.count = n;
            parent = new int[n];
            // 刚开始，parent[x] -> x
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public void union(int p, int q) {
            int rootP = findRoot(p);
            int rootQ = findRoot(q);
            if (rootP == rootQ) {
                return;
            }

            parent[rootP] = rootQ;
        }

        /**
         * p与q是否连接
         *
         * @param p
         * @param q
         * @return
         */
        public boolean connected(int p, int q) {
            int rootP = findRoot(p);
            int rootQ = findRoot(q);
            return rootP == rootQ;
        }

        public int count() {
            return this.count;
        }

        private int findRoot(int x) {
            while (x != parent[x]) {
                x = parent[parent[x]];
            }
            return x;
        }
    }
}
