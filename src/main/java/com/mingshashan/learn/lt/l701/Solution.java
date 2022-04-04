package com.mingshashan.learn.lt.l701;

class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (null == root) {
            return new TreeNode(val);
        }

        if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        }

        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        }

        return root;
    }
}