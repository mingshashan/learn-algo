package com.mingshashan.learn.lt.l105;

import java.util.HashMap;
import java.util.Map;

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
public class Solution_105 {
    public static void main(String[] args) {
        int[] preOrder = {3, 9, 20, 15, 7};
        int[] inOrder = {9, 3, 15, 20, 7};
        new Solution_105().buildTree(preOrder, inOrder);
    }

    public TreeNode buildTree(int[] preOrder, int[] inOrder) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            indexMap.put(inOrder[i], i);
        }
        return build(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1, indexMap);
    }

    private TreeNode build(int[] preOrder, int preStart, int preEnd,
                           int[] inOrder, int inStart, int inEnd, Map<Integer, Integer> indexMap) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        // 父节点
        int rootVal = preOrder[preStart];
        int index = indexMap.get(rootVal);

        int leftSize = index - inStart;
        TreeNode root = new TreeNode(rootVal);
        root.left = build(preOrder, preStart + 1, preStart + leftSize, inOrder, inStart, index - 1, indexMap);
        root.right = build(preOrder, preStart + leftSize + 1, preEnd, inOrder, index + 1, inEnd, indexMap);
        return root;
    }

}