package com.mingshashan.learn.lt.l1584;


import java.util.*;

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
public class Solution_1584_Prim {


    public int minCostConnectPoints(int[][] points) {
        List<int[]>[] graph = buildGraph(points);
        Prim prim = new Prim(graph);
        if (!prim.allConnected()) {
            return -1;
        }
        return prim.weightSum();
    }

    private List<int[]>[] buildGraph(int[][] points) {
        int n = points.length;
        List<int[]>[] graph = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int xi = points[i][0];
                int yi = points[i][1];
                int xj = points[j][0];
                int yj = points[j][1];
                int weight = Math.abs(xi - xj) + Math.abs(yi - yj);
                graph[i].add(new int[]{i, j, weight});
                graph[j].add(new int[]{j, i, weight});
            }
        }
        return graph;
    }

    class Prim {

        private PriorityQueue<int[]> pq;

        private int weightSum = 0;

        private boolean inMST[];

        private List<int[]>[] graph;

        public Prim(List<int[]>[] graph) {
            this.graph = graph;
            pq = new PriorityQueue<>((Comparator.comparingInt(o -> o[2])));
            int n = graph.length;
            inMST = new boolean[n];

            // 从0开始（从任意节点开始都可以）
            inMST[0] = true;
            cut(0);

            while (!pq.isEmpty()) {
                int[] edge = pq.poll();
                int to = edge[1];
                int weight = edge[2];

                if (inMST[to]) {
                    continue;
                }

                weightSum += weight;
                inMST[to] = true;
                cut(to);
            }

        }

        private void cut(int s) {
            for (int[] edge : graph[s]) {
                int to = edge[1];
                if (inMST[to]) {
                    continue;
                }
                pq.offer(edge);
            }
        }

        public boolean allConnected() {
            for (int i = 0; i < inMST.length; i++) {
                if (!inMST[i]) {
                    return false;
                }
            }
            return true;
        }

        public int weightSum() {
            return this.weightSum;
        }
    }
}
