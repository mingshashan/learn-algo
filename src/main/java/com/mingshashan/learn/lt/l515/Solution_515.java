package com.mingshashan.learn.lt.l515;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given the root of a binary tree, return an array of the largest value in each row of the tree (0-indexed).
 * Input: root = [1,3,2,5,3,null,9]
 * Output: [1,3,9]
 * <p>
 * Input: root = [1,2,3]
 * Output: [1,3]
 */
public class Solution_515 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        largestLevelValues(root, res);
        return res;
    }

    private void largestLevelValues(TreeNode root, List<Integer> res) {
        if (null == root) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            int levelMax = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.val > levelMax) {
                    levelMax = node.val;
                }
                if (null != node.left) {
                    queue.offer(node.left);
                }
                if (null != node.right) {
                    queue.offer(node.right);
                }
            }
            res.add(levelMax);
        }

    }
}