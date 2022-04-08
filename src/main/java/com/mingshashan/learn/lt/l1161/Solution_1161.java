package com.mingshashan.learn.lt.l1161;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_1161 {

    public int maxLevelSum(TreeNode root) {
        return traverseLevel(root);
    }

    private int traverseLevel(TreeNode root) {
        if (null == root) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int maxLevelSum = Integer.MIN_VALUE;
        int res = 0;

        int level = 0;
        while (!queue.isEmpty()) {
            level++;
            int levelSum = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                levelSum += node.val;
                if (null != node.left) {
                    queue.offer(node.left);
                }
                if (null != node.right) {
                    queue.offer(node.right);
                }
            }
            if (levelSum > maxLevelSum) {
                maxLevelSum = levelSum;
                res = level;
            }
        }
        return res;
    }
}