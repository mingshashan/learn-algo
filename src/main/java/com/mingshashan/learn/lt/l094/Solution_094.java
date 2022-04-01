package com.mingshashan.learn.lt.l094;

class Solution_094 {
    public int maxDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int maxLeft = maxDepth(root.left);
        int maxRight = maxDepth(root.right);

        return Math.max(maxLeft, maxRight) + 1;
    }
}