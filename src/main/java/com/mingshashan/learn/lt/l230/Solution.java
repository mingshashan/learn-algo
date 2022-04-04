package com.mingshashan.learn.lt.l230;

class Solution {

    int res = 0;
    int rank = 0;

    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return res;
    }
    void traverse(TreeNode root, int k) {
        if (null == root) {
            return;
        }

        traverse(root.left, k);
        // 中序遍历处理
        rank++;
        if (k == rank) {
            res = root.val;
            return;
        }

        traverse(root.right, k);
    }
}