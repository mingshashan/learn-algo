package com.mingshashan.learn.lt.l112;

/**
 * Given the root of a binary tree and an integer targetSum,
 * return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.
 * <p>
 * A leaf is a node with no children.
 */
public class Solution_112 {

    boolean result = false;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (null == root) {
            return false;
        }
        traverse(root, targetSum);
        return result;
    }

    private void traverse(TreeNode root, int targetSum) {
        if (null == root) {
            return;
        }

        int sum = targetSum - root.val;
        if (0 == sum && root.left == null && root.right == null) {
            result = true;
            return;
        }

        traverse(root.left, sum);
        traverse(root.right, sum);
    }
}
