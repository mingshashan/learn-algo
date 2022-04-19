package com.mingshashan.learn.lt.l323;

/**
 * 给你输入一个包含 n 个节点的图，用一个整数 n 和一个数组 edges 表示，
 * 其中 edges[i] = [ai, bi] 表示图中节点 ai 和 bi 之间有一条边。请你计算这幅图的连通分量个数。
 *
 * @author mingshashan
 */
public class Solution_323_V2 {

    int countComponents(int n, int[][] edges) {
        int res = n;
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            int p = edge[0];
            int q = edge[1];
            int rootP = find(parent, p);
            int rootQ = find(parent, q);

            if (rootP != rootQ) {
                rootP = parent[rootQ];
                res--;
            }

        }
        return res;
    }

    int find(int[] parent, int x) {
        while (x != parent[x]) {
            x = parent[x];
        }

        return x;
    }


}
