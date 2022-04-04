package com.mingshashan.learn.lt.l653;

import java.util.HashMap;
import java.util.Map;

public class Solution_653 {

    boolean res = false;

    public boolean findTarget(TreeNode root, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        traverse(root, k, map);
        return res;
    }

    private void traverse(TreeNode root, int k, Map<Integer, Integer> map) {
        if (null == root) {
            return;
        }

        traverse(root.left, k, map);
        traverse(root.right, k, map);
        if (map.containsKey(k - root.val)) {
            res = true;
        }
        map.put(root.val, 1);
    }


}