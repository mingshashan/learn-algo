package com.mingshashan.learn.lt.l107;

import com.mingshashan.learn.lt.common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution_107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (null == root) {
            return new LinkedList<>();
        }
        LinkedList<List<Integer>> result = new LinkedList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> level;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.addFirst(level);
        }
        return result;
    }
}