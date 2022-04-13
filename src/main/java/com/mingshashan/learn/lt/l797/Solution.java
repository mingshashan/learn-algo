package com.mingshashan.learn.lt.l797;

import com.mingshashan.learn.structure.Link;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 797. All Paths From Source to Target
 * Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1,
 * find all possible paths from node 0 to node n - 1 and return them in any
 * order.
 * <p>
 * The graph is given as follows: graph[i] is a list of all nodes you can visit
 * from node i (i.e., there is a directed edge from node i to node graph[i][j]).
 * <p>
 * Input: graph = [[1,2],[3],[3],[]]
 * Output: [[0,1,3],[0,2,3]]
 * Explanation: There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
 * <p>
 * Input: graph = [[4,3,1],[3,2,4],[3],[4],[]]
 * Output: [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
 */
class Solution {

    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        if (null == graph || 0 == graph.length) {
            return res;
        }
        LinkedList<Integer> path = new LinkedList<>();
        traverse(graph, 0, path);
        return res;
    }

    private void traverse(int[][] graph, int i, LinkedList<Integer> path) {
        path.addLast(i);
        if (i == graph.length - 1) {
            res.add(new LinkedList<>(path));
            path.removeLast();
            return;
        }

        for (int v : graph[i]) {
            traverse(graph, v, path);
        }

        path.removeLast();
    }

}