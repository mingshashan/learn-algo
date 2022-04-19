package com.mingshashan.learn.lt.l450;

/**
 * Given a root node reference of a BST and a key,
 * delete the node with the given key in the BST.
 * Return the root node reference (possibly updated) of the BST.
 * <p>
 * Basically, the deletion can be divided into two stages:
 * <p>
 * Search for a node to remove.
 * If the node is found, delete the node.
 */
public class Solution_450 {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (null == root) {
            return root;
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            if (null == root.left) {
                TreeNode temp = root.right;
                return temp;
            } else if (null == root.right) {
                TreeNode temp = root.left;
                return temp;
            } else {
                TreeNode node = getSucc(root);
                root.val = node.val;
                root.right = deleteNode(root.right, node.val);
            }
        }

        return root;
    }

    private TreeNode getSucc(TreeNode root) {
        TreeNode curr = root.right;
        while (curr != null && curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }
}