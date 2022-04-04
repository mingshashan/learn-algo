package com.mingshashan.learn.lt.l700;

class Solution_V2 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (null == root) {
            return null;
        }
        if (root.val > val) {
            return searchBST(root.left, val);
        }

        if (root.val < val) {
            return searchBST(root.right, val);
        }
        return root;
    }
}