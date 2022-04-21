package com.mingshashan.learn.lt.l990;

class Solution {
    public boolean equationsPossible(String[] equations) {
        UF uf = new UF(26);
        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                char x = equation.charAt(0);
                char y = equation.charAt(3);

                uf.union(x - 'a', y - 'a');
            }
        }

        for (String equation : equations) {
            if (equation.charAt(1) == '!') {
                char x = equation.charAt(0);
                char y = equation.charAt(3);
                if (uf.connected(x - 'a', y - 'a')) {
                    return false;
                }
            }
        }
        return true;
    }


    class UF {

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
        public UF(int n) {
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
            parent[rootQ] = rootP;
            // 连通分量-1
            count--;
        }

        private int findRoot(int x) {
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];
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
}