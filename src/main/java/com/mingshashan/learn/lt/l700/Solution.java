package com.mingshashan.learn.lt.l700;

class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if (null == root) {
            return null;
        }
        if (val == root.val) {
            return root;
        }

        TreeNode left = searchBST(root.left, val);
        TreeNode right = searchBST(root.right, val);

        return left == null ? right : left;
    }
}