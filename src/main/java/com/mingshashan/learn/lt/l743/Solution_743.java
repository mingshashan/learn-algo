package com.mingshashan.learn.lt.l743;

import java.util.*;

/**
 * You are given a network of n nodes, labeled from 1 to n.
 * You are also given times, a list of travel times as directed edges
 * times[i] = (ui, vi, wi), where ui is the source node,
 * vi is the target node, and wi is the time it takes for a signal to travel from source to target.
 * <p>
 * We will send a signal from a given node k. Return the time
 * it takes for all the n nodes to receive the signal.
 * If it is impossible for all the n nodes to receive the signal, return -1.
 * <p>
 * Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
 * Output: 2
 * <p>
 * Input: times = [[1,2,1]], n = 2, k = 1
 * Output: 1
 * <p>
 * Input: times = [[1,2,1]], n = 2, k = 2
 * Output: -1
 */
public class Solution_743 {
    // times记录边和权重，n为节点个数，k为起点
    // 计算k发出的信号至少需要多久才能传遍整幅图
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] graph = buildGraph(times, n);

        // dijkstra算法计算k到其他节点的最短路径
        int[] distTo = dijkstra(k, graph);

        // 找到最长的那条最短路径
        int res = 0;
        for (int i = 1; i < distTo.length; i++) {
            if (distTo[i] == Integer.MAX_VALUE) {
                return -1;
            }
            res = Math.max(res, distTo[i]);
        }

        return res;
    }

    private List<int[]>[] buildGraph(int[][] times, int n) {
        // 节点编号是从 1 开始的，所以要一个大小为 n + 1 的邻接表
        List<int[]>[] graph = new LinkedList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] edge : times) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            graph[from].add(new int[]{to, weight});
        }
        return graph;
    }

    class State {
        // 节点id
        private int id;
        // 节点到start节点的距离
        private int distFromStart;

        public State(int id, int distFromStart) {
            this.id = id;
            this.distFromStart = distFromStart;
        }
    }

    // 输入一个起点 start，计算从 start 到其他节点的最短距离
    private int[] dijkstra(int start, List<int[]>[] graph) {
        // distTo[i]的值就是start到i的最短路径权重
        int[] distTo = new int[graph.length];
        Arrays.fill(distTo, Integer.MAX_VALUE);
        // base case , start -> start 的最短距离为0
        distTo[start] = 0;
        // 优先级队列，distFromStart最小的排前面
        PriorityQueue<State> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.distFromStart));
        // 从节点start开始BFS
        pq.offer(new State(start, 0));
        while (!pq.isEmpty()) {
            State node = pq.poll();
            int currentNodeId = node.id;
            int currentDistantFromStart = node.distFromStart;

            if (currentDistantFromStart > distTo[currentNodeId]) {
                continue;
            }

            // 将currentNode相邻的节点加入queue中
            for (int[] neighbor : graph[currentNodeId]) {
                int nextNodeId = neighbor[0];
                int distToNextNode = currentDistantFromStart + neighbor[1];
                // 更新dp table
                if (distToNextNode < distTo[nextNodeId]) {
                    distTo[nextNodeId] = distToNextNode;
                    pq.offer(new State(nextNodeId, distToNextNode));
                }
            }
        }

        return distTo;
    }
}