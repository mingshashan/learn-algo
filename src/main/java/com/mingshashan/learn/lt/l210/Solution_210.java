package com.mingshashan.learn.lt.l210;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 210. Course Schedule II
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
 * You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates
 * that you must take course bi first if you want to take course ai.
 * <p>
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return the ordering of courses you should take to finish all courses.
 * If there are many valid answers, return any of them. If it is impossible to finish all courses,
 * return an empty array.
 */
public class Solution_210 {

    boolean[] onPath;
    boolean[] visited;
    boolean hasCycle;
    List<Integer> postOrder = new ArrayList<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        onPath = new boolean[numCourses];
        visited = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            traverse(graph, i);
        }

        if (hasCycle) {
            return new int[]{};
        }

        Collections.reverse(postOrder);
        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            res[i] = postOrder.get(i);
        }
        return res;
    }

    void traverse(List<Integer>[] graph, int i) {
        if (onPath[i]) {
            hasCycle = true;
        }
        if (visited[i] || hasCycle) {
            return;
        }

        visited[i] = true;
        onPath[i] = true;
        for (int v : graph[i]) {
            traverse(graph, v);
        }
        postOrder.add(i);
        onPath[i] = false;
    }

    /**
     * 建构图数据结构
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new LinkedList[numCourses];
        if (numCourses <= 0) {
            return graph;
        }

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }

        // [0, 1],即需要先修0,才能修1，此处from是1，to是0，即 0->1
        for (int[] peer : prerequisites) {
            int from = peer[1];
            int to = peer[0];
            graph[from].add(to);
        }
        return graph;
    }
}
