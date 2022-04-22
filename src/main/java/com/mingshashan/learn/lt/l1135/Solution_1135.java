package com.mingshashan.learn.lt.l1135;

import java.util.Arrays;

/**
 * 最低成本联通所有城市
 * <p>
 * There are N cities numbered from 1 to N.
 * <p>
 * You are given connections, where each connections[i] = [city1, city2, cost]
 * represents the cost to connect city1 and city2 together.
 * (A connection is bidirectional: connecting city1 and city2 is the same as connecting city2 and city1.)
 * <p>
 * Return the minimum cost so that for every pair of cities,
 * there exists a path of connections (possibly of length 1) that connects those two cities together.
 * The cost is the sum of the connection costs used. If the task is impossible, return -1.
 * impossible, return -1.
 * <p>
 * Example 1:
 * Input: N = 3, connections = [[1,2,5],[1,3,6],[2,3,1]]
 * Output: 6
 * Explanation:
 * Choosing any 2 edges will connect all cities so we choose the minimum 2.
 * Example 2:
 * <p>
 * Input: N = 4, connections = [[1,2,3],[3,4,4]]
 * Output: -1
 * Explanation:
 * There is no way to connect all cities even if all edges are used.
 * <p>
 * 最小生成树，Kruskal算法（需要用到union-find并查集算法）
 */
public class Solution_1135 {
    int minimumCost(int n, int[][] connections) {
        // 城市编号从1开始，所以初始化n+1
        UF uf = new UF(n + 1);
        // 从小到大排序
        Arrays.sort(connections, (o1, o2) -> o1[2] - o2[2]);
        // 最小生成树的权重
        int mstWeight = 0;
        for (int[] connection : connections) {
            int p = connection[0];
            int q = connection[1];
            int weight = connection[2];
            // 如果connect为true则会产生环，需要丢弃
            if (uf.connected(p, q)) {
                continue;
            }

            mstWeight += weight;
            uf.union(p, q);
        }

        // 保证所有节点都被连通
        // 按理说 uf.count() == 1 说明所有节点被连通
        // 但因为节点 0 没有被使用，所以 0 会额外占用一个连通分量
        return uf.count() == 2 ? mstWeight : -1;
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
            count--;
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
