package com.mingshashan.learn.lt.l144;

import java.util.ArrayList;
import java.util.List;

public class Solution_144 {

    private List<Integer> res = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        if (null == root) {
            return res;
        }
        preorder(root);
        return res;
    }

    private void preorder(TreeNode root) {
        if (null == root) {
            return;
        }
        res.add(root.val);
        preorder(root.left);
        preorder(root.right);
    }
}