package com.mingshashan.learn.lt.l105;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 * <p>
 * Given two integer arrays preorder and inorder where preorder is the preorder
 * traversal of a binary tree and inorder is the inorder traversal of the same tree,
 * construct and return the binary tree.
 */
class Solution_105 {
    public TreeNode buildTree(int[] preOrder, int[] inOrder) {
        return build(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1);
    }

    private TreeNode build(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        int index = 0;
        int rootValue = preOrder[preStart];
        for (int i = inStart; i <= inEnd; i++) {
            if (inOrder[i] == rootValue) {
                index = i;
                break;
            }
        }

        TreeNode root = new TreeNode(rootValue);
        int leftSize = index - inStart;
        root.left = build(preOrder, preStart + 1, preStart + leftSize, inOrder, inStart, index - 1);
        root.right = build(preOrder, preStart + leftSize + 1, preEnd, inOrder, index + 1, inEnd);

        return root;
    }
}