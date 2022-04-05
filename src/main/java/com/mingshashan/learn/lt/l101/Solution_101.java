package com.mingshashan.learn.lt.l101;

public class Solution_101 {

    public boolean isSymmetric(TreeNode root) {
        if (null == root) {
            return true;
        }

        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (null == left && null == right) {
            return true;
        }
        if (null != left && null != right && left.val == right.val) {
            if (isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left)) {
                return true;
            }
        }

        return false;
    }

}