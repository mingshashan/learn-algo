package com.mingshashan.learn.lt.l145;

import java.util.LinkedList;
import java.util.List;

public class Solution_145 {

    private List<Integer> result = new LinkedList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        if (null == root) {
            return result;
        }
        postorderTraverse(root);
        return result;
    }

    private void postorderTraverse(TreeNode root) {
        if (null == root) {
            return;
        }
        postorderTraverse(root.left);
        postorderTraverse(root.right);
        result.add(root.val);
    }
}