package com.mingshashan.learn.lt.l886;

import java.util.LinkedList;
import java.util.List;

class Solution {

    boolean isOk = true;
    boolean[] visited;
    boolean[] color;

    public boolean possibleBipartition(int n, int[][] dislikes) {
        visited = new boolean[n + 1];
        color = new boolean[n + 1];

        List<Integer>[] graph = buildGraph(n, dislikes);

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                traverse(graph, i);
            }
        }

        return isOk;
    }

    private void traverse(List<Integer>[] graph, int v) {
        if (!isOk) {
            return;
        }

        visited[v] = true;
        for (int w : graph[v]) {
            if (!visited[w]) {
                color[w] = !color[v];
                traverse(graph, w);
            } else {
                if (color[w] == color[v]) {
                    isOk = false;
                }
            }
        }
    }


    List<Integer>[] buildGraph(int n, int[][] dislikes) {
        List<Integer>[] graph = new LinkedList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int[] peer : dislikes) {
            int x = peer[0];
            int y = peer[1];

            graph[x].add(y);
            graph[y].add(x);
        }

        return graph;
    }
}