package com.mingshashan.learn.lt.common;

public class UF_V1 {

    /**
     * 记录连通分量
     */
    private int count;

    /**
     * 节点x的parent是parent[x]
     */
    private int[] parent;

    /**
     * 构造函数，n为图的节点数
     *
     * @param n
     */
    public UF_V1(int n) {
        // 一开始互不连通
        this.count = n;

        // 父节点指针初始指向自己
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }


    /**
     * 将 p 和 q 连接
     */
    public void union(int p, int q) {
        int rootP = findRoot(p);
        int rootQ = findRoot(q);

        if (rootP == rootQ) {
            return;
        }

        // 将两颗树合为一个
        parent[rootP] = rootQ;

        // 连通分量-1
        count--;
    }

    private int findRoot(int x) {
        while (x != parent[x]) {
            x = parent[x];
        }

        return x;
    }

    /**
     * 判断 p 和 q 是否连通
     */
    public boolean connected(int p, int q) {
        int rootP = findRoot(p);
        int rootQ = findRoot(q);

        return rootP == rootQ;
    }

    /**
     * 返回图中有多少个连通分量
     */
    public int count() {
        return count;
    }
}