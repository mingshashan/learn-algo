package com.mingshashan.learn.lt.l207;

import java.util.LinkedList;
import java.util.List;

public class Solution_207 {

    boolean onPath[];
    boolean visited[];
    boolean hasCycle = false;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        onPath = new boolean[numCourses];
        visited = new boolean[numCourses];
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);

        for (int i = 0; i < numCourses; i++) {
            traverse(graph, i);
        }

        return !hasCycle;
    }

    private void traverse(List<Integer>[] graph, int i) {
        if (onPath[i]) {
            hasCycle = true;
        }

        if (visited[i] || hasCycle) {
            return;
        }
        onPath[i] = true;
        visited[i] = true;
        for (int v : graph[i]) {
            traverse(graph, v);
        }
        onPath[i] = false;
    }

    private List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new LinkedList[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int[] neighborhood : prerequisites) {
            int from = neighborhood[1];
            int to = neighborhood[0];
            graph[from].add(to);
        }

        return graph;
    }
}
