package com.mingshashan.learn.lt.common;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Prim {
    // 核心数据结构，存储"横切边"的优先级队列
    private PriorityQueue<int[]> pq;
    // 类似visited数组的作用，记录哪些结点已经成为最小生成树的一部分
    private boolean[] inMST;
    // 记录最小生成树（mst）的权重和
    private int weightSum = 0;
    // 邻接表表示的图结构
    // graph[i]记录节点s所有相邻的边
    // 三元级int[]{from, to, weight}表示一条边
    private List<int[]>[] graph;

    public Prim(List<int[]>[] graph) {
        this.graph = graph;
        this.pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        int n = graph.length;
        this.inMST = new boolean[n];
        // 随便从一个点开始切分就可以，从节点0开始
        inMST[0] = true;
        cut(0);
        // 不断进行切分，向最小生成树中添加边
        while (!pq.isEmpty()) {
            int[] edge = pq.poll();
            int to = edge[1];
            int weight = edge[2];
            if (inMST[to]) {
                // 节点to已经在最小生成树中，跳过，否则会产生环
                continue;
            }
            // 将这条边加入最小生成树
            weightSum += weight;
            inMST[to] = true;
            // 节点to加入后，进行新一轮切分，会产生更多模切边
            cut(to);
        }

    }

    private void cut(int s) {
        for (int[] edge : graph[s]) {
            int to = edge[1];
            if (inMST[to]) {
                // 相邻结点to已经在最小生成树中，跳过，否则会产生环
                continue;
            }
            // 加入模切队列
            pq.offer(edge);
        }
    }

    // 最小生成树的权重和
    public int weightSum() {
        return this.weightSum;
    }

    // 判断最小生成树是否包含图中所有的结点
    public boolean allConnected() {
        for (int i = 0; i < inMST.length; i++) {
            if (!inMST[i]) {
                return false;
            }
        }
        return true;
    }
}
