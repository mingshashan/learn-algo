package com.mingshashan.learn.lt.l785;

/**
 * There is an undirected graph with n nodes, where each node is numbered between 0 and n - 1.
 * You are given a 2D array graph, where graph[u] is an array of nodes that node u is adjacent to.
 * More formally, for each v in graph[u], there is an undirected edge between node u and node v.
 * The graph has the following properties:
 * <p>
 * There are no self-edges (graph[u] does not contain u).
 * There are no parallel edges (graph[u] does not contain duplicate values).
 * If v is in graph[u], then u is in graph[v] (the graph is undirected).
 * The graph may not be connected, meaning there may be two nodes u and v such
 * that there is no path between them.
 * <p>
 * A graph is bipartite if the nodes can be partitioned into two independent
 * sets A and B such that every edge in the graph connects a node in set A and a node in set B.
 * <p>
 * Return true if and only if it is bipartite.
 * <p>
 * <p>
 * Input: graph = [[1,2,3],[0,2],[0,1,3],[0,2]]
 * Output: false
 * Explanation: There is no way to partition the nodes into two independent
 * sets such that every edge connects a node in one and a node in the other.
 * <p>
 * <p>
 * Input: graph = [[1,3],[0,2],[1,3],[0,2]]
 * Output: true
 * Explanation: We can partition the nodes into two sets: {0, 2} and {1, 3}.
 */
class Solution {

    boolean[] visited;
    boolean[] color;
    boolean isOk = true;

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        visited = new boolean[n];
        color = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                traverse(graph, i);
            }
        }

        return isOk;
    }

    public void traverse(int[][] graph, int v) {
        if (!isOk) {
            return;
        }

        visited[v] = true;
        // 遍历v的相邻节点
        for (int i : graph[v]) {
            if (!visited[i]) {
                color[i] = !color[v];
                traverse(graph, i);
            } else {
                if (color[i] == color[v]) {
                    isOk = false;
                }
            }
        }

    }
}