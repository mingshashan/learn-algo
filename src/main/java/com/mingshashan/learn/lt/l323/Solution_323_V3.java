package com.mingshashan.learn.lt.l323;

import java.util.LinkedList;
import java.util.List;

/**
 * 给你输入一个包含 n 个节点的图，用一个整数 n 和一个数组 edges 表示，
 * 其中 edges[i] = [ai, bi] 表示图中节点 ai 和 bi 之间有一条边。请你计算这幅图的连通分量个数。
 *
 * @author mingshashan
 */
public class Solution_323_V3 {

    boolean[] visited;
    boolean[] onPath;

    // DFS
    int countComponents(int n, int[][] edges) {
        List<Integer>[] graph = buildGraph(n, edges);
        visited = new boolean[n];
        onPath = new boolean[n];
        int res = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                res++;
                traverseDFS(graph, i);
            }
        }
        return res;
    }

    private void traverseDFS(List<Integer>[] graph, int i) {
        if (visited[i] || onPath[i]) {
            return;
        }

        onPath[i] = true;
        visited[i] = true;
        for (int v : graph[i]) {
            traverseDFS(graph, v);
        }
        onPath[i] = false;
    }

    private List<Integer>[] buildGraph(int n, int[][] edges) {
        List<Integer>[] graph = new LinkedList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }

        // 双向图
        for (int[] edge : edges) {
            int p = edge[0];
            int q = edge[1];
            graph[p].add(q);
            graph[q].add(p);
        }
        return graph;
    }


}
