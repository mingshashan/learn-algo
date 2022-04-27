package com.mingshashan.learn.lt.l1514;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * You are given an undirected weighted graph of n nodes (0-indexed), represented by an edge list
 * where edges[i] = [a, b]
 * is an undirected edge connecting the nodes a and b with a probability of success of traversing
 * that edge succProb[i].
 * <p>
 * Given two nodes start and end, find the path with the maximum probability of success
 * to go from start to end and return its success probability.
 * <p>
 * If there is no path from start to end, return 0. Your answer will be accepted
 * if it differs from the correct answer by at most 1e-5.
 */
class Solution {


    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<double[]>[] graph = buildGraph(n, edges, succProb);
        return dijkstra(start, end, graph);
    }

    List<double[]>[] buildGraph(int n, int[][] edges, double[] succProb) {
        List<double[]>[] graph = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            double prob = succProb[i];
            // 无向图是双向图，先把int转为double,后面再转回来
            graph[from].add(new double[]{to, prob});
            graph[to].add(new double[]{from, prob});
        }
        return graph;
    }

    class State {
        int id;
        double probFromStart;

        public State(int id, double probFromStart) {
            this.id = id;
            this.probFromStart = probFromStart;
        }
    }

    double dijkstra(int start, int end, List<double[]>[] graph) {
        // 定义probTo[i]就是节点start到i的最大概率
        double[] probTo = new double[graph.length];
        // dp table初始化为一个取不到的最小值
        Arrays.fill(probTo, -1);
        // base case, start -> start概率为1
        probTo[start] = 1;
        PriorityQueue<State> pq = new PriorityQueue<>((o1, o2) -> Double.compare(o2.probFromStart, o1.probFromStart));
        pq.offer(new State(start, 1));
        while (!pq.isEmpty()) {
            State curState = pq.poll();
            int id = curState.id;
            double curFromStart = curState.probFromStart;
            // 遇到终点提前返回
            if (id == end) {
                return curFromStart;
            }

            if (curFromStart < probTo[id]) {
                // 已经有概率更大的路径
                continue;
            }

            // 将当前节点的相邻节点装入队列
            for (double[] neighbor : graph[id]) {
                int nextNodeId = (int) neighbor[0];
                // 当前节点到下一节点的概率
                double probToNextNode = probTo[id] * neighbor[1];
                if (probToNextNode > probTo[nextNodeId]) {
                    probTo[nextNodeId] = probToNextNode;
                    pq.offer(new State(nextNodeId, probToNextNode));
                }
            }
        }

        // start无法到达end
        return 0.0;
    }
}