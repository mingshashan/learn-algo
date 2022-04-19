package com.mingshashan.learn.lt.l323;

import com.mingshashan.learn.lt.common.UF_V3;

/**
 * 给你输入一个包含 n 个节点的图，用一个整数 n 和一个数组 edges 表示，
 * 其中 edges[i] = [ai, bi] 表示图中节点 ai 和 bi 之间有一条边。请你计算这幅图的连通分量个数。
 *
 * @author mingshashan
 */
public class Solution_323 {

    int countComponents(int n, int[][] edges) {
        UF_V3 uf = new UF_V3(n);

        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }

        return uf.count();

    }

}
