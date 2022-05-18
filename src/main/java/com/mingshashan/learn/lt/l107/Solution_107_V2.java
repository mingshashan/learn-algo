package com.mingshashan.learn.lt.l107;

import com.mingshashan.learn.lt.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution_107_V2 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (null == root) {
            return new ArrayList<>();
        }
        List<List<Integer>> temp = new ArrayList<>();
        traverse(0, root, temp);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = temp.size() - 1; i >= 0; i--) {
            result.add(temp.get(i));
        }

        return result;
    }

    private void traverse(int level, TreeNode root, List<List<Integer>> result) {
        if (null == root) {
            return;
        }

        if (result.size() <= level) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        traverse(level + 1, root.left, result);
        traverse(level + 1, root.right, result);
    }
}