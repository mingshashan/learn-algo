package com.mingshashan.learn.lt.l323;

public class Solution_323_V1 {
    int countComponents(int n, int[][] edges) {
        UF uf = new UF(n);
        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }

        return uf.count();
    }
}

class UF {
    // 记录连通分量
    int count;
    // x 节点的parent为parent[x]
    int[] parent;

    public UF(int n) {
        this.count = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public void union(int p, int q) {
        int parentP = findParent(p);
        int parentQ = findParent(q);
        if (parentP == parentQ) {
            return;
        }

        parent[parentP] = parentQ;
        count--;
    }

    int count() {
        return this.count;
    }

    int findParent(int x) {
        while (x != parent[x]) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    boolean connected(int p, int q) {
        int parentP = findParent(p);
        int parentQ = findParent(q);

        return parentP == parentQ;
    }
}
