package com.mingshashan.learn.lt.l114;

/**
 * Given the root of a binary tree, flatten the tree into a "linked list":
 * <p>
 * The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
 * The "linked list" should be in the same order as a pre-order traversal of the binary tree.
 */
class Solution {
    public void flatten(TreeNode root) {
        if (null == root) {
            return;
        }

        // 左子树
        flatten(root.left);
        // 右子树
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;

        // 左子树为null
        root.left = null;
        root.right = left;
        // 找到原节点最后一个右子节点
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        // 将原右子树的节点放到现在的右子节点下
        p.right = right;
    }
}