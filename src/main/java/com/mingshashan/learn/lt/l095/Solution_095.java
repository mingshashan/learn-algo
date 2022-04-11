package com.mingshashan.learn.lt.l095;

import java.util.LinkedList;
import java.util.List;

public class Solution_095 {
    public List<TreeNode> generateTrees(int n) {
        if (0 == n) {
            return new LinkedList<>();
        }
        return build(1, n);
    }

    private List<TreeNode> build(int low, int high) {
        List<TreeNode> res = new LinkedList<>();
        if (low > high) {
            res.add(null);
            return res;
        }

        for (int i = low; i <= high; i++) {
            List<TreeNode> leftTree = build(low, i - 1);
            List<TreeNode> rightTree = build(i + 1, high);
            for (TreeNode lef : leftTree) {
                for (TreeNode right : rightTree) {
                    TreeNode root = new TreeNode(i);
                    root.left = lef;
                    root.right = right;
                    res.add(root);
                }
            }
        }


        return res;
    }
}