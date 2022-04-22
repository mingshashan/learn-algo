package com.mingshashan.learn.lt.l1584;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * You are given an array points representing integer coordinates of some points on a 2D-plane, where points[i] = [xi, yi].
 * <p>
 * The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan distance between them: |xi - xj| + |yi - yj|, where |val| denotes the absolute value of val.
 * <p>
 * Return the minimum cost to make all points connected. All points are connected if there is exactly one simple path between any two points.
 * <p>
 * Input: points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
 * Output: 20
 * Explanation
 * We can connect the points as shown above to get the minimum cost of 20.
 * Notice that there is a unique path between every pair of points.
 * <p>
 * Input: points = [[3,12],[-2,5],[-4,1]]
 * Output: 18
 * <p>
 * 每个点就是无向加权图中的节点，边的权重就是曼哈顿距离，连接所有点的最小费用就是最小生成树的权重和。
 * 所以解法思路就是先生成所有的边以及权重，然后对这些边执行 Kruskal 算法即可：
 * <p>
 * 这道题做了一个小的变通：每个坐标点是一个二元组，那么按理说应该用五元组表示一条带权重的边，
 * 但这样的话不便执行 Union-Find 算法；所以我们用 points 数组中的索引代表每个坐标点，
 * 这样就可以直接复用之前的 Kruskal 算法逻辑了。
 *
 * @see <a>https://mp.weixin.qq.com/s/dJ9gqR3RVoeGnATlpMG39w</a>
 */
public class Solution_1584 {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        // 生成边和权重
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int xi = points[i][0];
                int yi = points[i][1];
                int xj = points[j][0];
                int yj = points[j][1];

                // 以points的索引，即第几个点来表示node， 这样i<-->j即可表示一条边，否则要用5个元素（x, y的坐标与距离）
                edges.add(new int[]{i, j, Math.abs(xi - xj) + Math.abs(yi - yj)});
            }
        }

        Collections.sort(edges, (o1, o2) -> o1[2] - o2[2]);
        UF uf = new UF(n);
        int mst = 0;
        for (int[] edge : edges) {
            int p = edge[0];
            int q = edge[1];
            int weight = edge[2];
            if (uf.connected(p, q)) {
                continue;
            }
            mst += weight;
            uf.union(p, q);
        }

        return uf.count() == 1 ? mst : -1;
    }

    class UF {
        // 记录连通分量
        private int count;
        // 父节点数组，x 节点的父节点为parent[x]
        private int[] parent;

        public UF(int n) {
            this.count = n;
            this.parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public boolean connected(int p, int q) {
            int rootP = findRoot(p);
            int rootQ = findRoot(q);
            return rootP == rootQ;
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

        private int findRoot(int x) {
            while (x != parent[x]) {
                x = parent[parent[x]];
            }
            return x;
        }

        public int count() {
            return count;
        }
    }
}
