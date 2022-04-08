package com.mingshashan.learn.lt.l110;

public class Solution_110 {
    public boolean isBalanced(TreeNode root) {
        return maxDepth(root) != -1;
    }

    private int maxDepth(TreeNode node) {
        if (null == node) {
            return 0;
        }
        int left = maxDepth(node.left);
        if (-1 == left) {
            return -1;
        }
        int right = maxDepth(node.right);
        if (-1 == right) {
            return -1;
        }
        if (Math.abs(left - right) > 1) {
            return -1;
        }

        return Math.max(left, right) + 1;
    }
}