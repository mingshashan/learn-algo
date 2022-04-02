package com.mingshashan.learn.lt.l543;

/**
 * Diameter of Binary Tree
 * <p>
 * Given the root of a binary tree, return the length of the diameter of the tree.
 * <p>
 * The diameter of a binary tree is the length of the longest path
 * between any two nodes in a tree. This path may or may not pass through the root.
 * <p>
 * The length of a path between two nodes is represented
 * by the number of edges between them.
 * <p>
 * 递归算出左右子树的直径
 * 需要搞清楚计算过程
 */
public class Solution_543 {

    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (null == root) {
            return 0;
        }

        height(root);
        return maxDiameter;
    }

    int height(TreeNode root) {
        if (null == root) {
            return 0;
        }

        int left = height(root.left);
        int right = height(root.right);

        // 以root为根的最大直径为
        int diameter = left + right;
        maxDiameter = Math.max(maxDiameter, diameter);
        return Math.max(left, right) + 1;
    }
}