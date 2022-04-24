package com.mingshashan.learn.lt.l1135;

import com.mingshashan.learn.lt.common.Prim;

import java.util.LinkedList;
import java.util.List;

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
public class Solution_1135_Prim {
    int minimumCost(int n, int[][] connections) {
        List<int[]>[] graph = buildGraph(n, connections);
        Prim prim = new Prim(graph);
        if (!prim.allConnected()) {
            return -1;
        }
        return prim.weightSum();
    }

    private List<int[]>[] buildGraph(int n, int[][] connections) {
        List<int[]>[] graph = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }
        // 因为题中是从1->N，这里为了方便，都-1
        for (int[] connection : connections) {
            int u = connection[0] - 1;
            int v = connection[1] - 1;
            int weight = connection[2];
            graph[u].add(new int[]{u, v, weight});
            graph[v].add(new int[]{v, u, weight});
        }
        return graph;
    }


}
