package com.mingshashan.learn.lt.l606;

/**
 * Given the root of a binary tree, construct a string consisting of parenthesis
 * and integers from a binary tree with the preorder traversal way, and return it.
 * <p>
 * Omit all the empty parenthesis pairs that do not affect
 * the one-to-one mapping relationship between the string
 * and the original binary tree.
 * <p>
 * 先序遍历
 */
public class Solution_606 {

    StringBuilder sb;

    public String tree2str(TreeNode root) {
        sb = new StringBuilder("");
        if (root == null) {
            return null;
        }
        traverse(root);
        String res = sb.substring(0, sb.length() - 1);
        return res;
    }

    private void traverse(TreeNode root) {
        if (root.left == null && root.right == null) {
            sb.append(root.val);
        } else {
            sb.append(root.val);
        }

        if (root.left != null) {
            sb.append("(");
            traverse(root.left);
        }
        if (root.right != null) {
            if (root.left == null) {
                sb.append("()");
            }
            sb.append("(");
            traverse(root.right);
        }

        sb.append(")");
    }
}