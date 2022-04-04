package com.mingshashan.learn.lt.l653;

import java.util.HashSet;
import java.util.Set;

public class Solution_653_V2 {
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return traverse(root, k, set);
    }

    private boolean traverse(TreeNode root, int k, Set<Integer> set) {
        if (null == root) {
            return false;
        }

        if (set.contains(k - root.val)) {
            return true;
        } else {
            set.add(root.val);
        }

        return traverse(root.left, k, set) || traverse(root.right, k, set);
    }

}