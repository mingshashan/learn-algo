package com.mingshashan.learn.lt.l104;

import java.util.LinkedList;
import java.util.List;

/**
 * 中序遍历
 */
class Solution_104 {

    List<Integer> result = new LinkedList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (null == root) {
            return result;
        }
        inorderTraverse(root);
        return result;
    }

    public void inorderTraverse(TreeNode root) {
        if (null == root) {
            return;
        }
        inorderTraverse(root.left);
        result.add(root.val);
        inorderTraverse(root.right);
    }

}