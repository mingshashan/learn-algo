package com.mingshashan.learn.lt.l1373;

/**
 * Maximum Sum BST in Binary Tree
 * <p>
 * Given a binary tree root, return the maximum sum of all keys of any sub-tree which is also a Binary Search Tree (BST).
 * <p>
 * Assume a BST is defined as follows:
 * <p>
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * <p>
 * 后续遍历，traverse返回一个大小为4的数组
 * [0] 为以node为根的二叉树是不是BST树，1为是，0为否
 * [1] 为以node为根的所有节点中的最小值
 * [2] 为以node为根的所有节点中的最大值
 * [3] 为以node为根的所有节点之和
 */
class Solution_1373 {
    int maxSum = 0;

    public int maxSumBST(TreeNode root) {
        traverse(root);
        return maxSum;
    }

    // 后序遍历
    private int[] traverse(TreeNode root) {
        if (null == root) {
            return new int[]{1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }
        // 递归遍历左右子树
        int[] leftRes = traverse(root.left);
        int[] rightRes = traverse(root.right);

        int[] res = new int[4];

        // 左、右两个子树都是BST树（即[0]都为1）
        // 根节点大于左子树中的最大值、小于右子树中的最小值
        if (1 == leftRes[0] && 1 == rightRes[0] && root.val > leftRes[2] && root.val < rightRes[1]) {
            res[0] = 1;
            res[1] = Math.min(leftRes[1], root.val);
            res[2] = Math.max(rightRes[2], root.val);
            res[3] = leftRes[3] + rightRes[3] + root.val;
            maxSum = Math.max(maxSum, res[3]);
        } else {
            res[0] = 0;
        }
        return res;
    }
}