package com.mingshashan.learn.lt.l1038;

class Solution {
    int sum = 0;
    public TreeNode bstToGst(TreeNode root) {
        traverse(root);
        return root;
    }

    private void traverse(TreeNode root) {
        if (null == root) {
            return;
        }
        traverse(root.right);
        // 中序遍历
        sum += root.val;
        root.val = sum;

        traverse(root.left);
    }
}