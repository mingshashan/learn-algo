package com.mingshashan.learn.lt.l652;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Solution_652 {
    Map<String, Integer> memo = new HashMap<>();
    List<TreeNode> result = new LinkedList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return result;
    }

    private String traverse(TreeNode root) {
        if (null == root) {
            return "#";
        }

        String left = traverse(root.left);
        String right = traverse(root.right);

        String subTree = left + "," + right + "," + root.val;
        int freq = memo.getOrDefault(subTree, 0);
        if (freq == 1) {
            result.add(root);
        }

        memo.put(subTree, freq + 1);
        return subTree;
    }
}