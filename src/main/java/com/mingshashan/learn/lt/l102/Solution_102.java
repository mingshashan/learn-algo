package com.mingshashan.learn.lt.l102;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given the root of a binary tree,
 * return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 * <p>
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[9,20],[15,7]]
 * <p>
 * Input: root = [1]
 * Output: [[1]]
 * <p>
 * Input: root = []
 * Output: []
 */
public class Solution_102 {
    public List<List<Integer>> levelOrder(TreeNode root) {

        return traverse(root);
    }

    private List<List<Integer>> traverse(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if (null == root) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> levelList = new ArrayList<>();
            int i = 0;
            int size = queue.size();
            while (i < size) {
                TreeNode node = queue.iterator().next();
                i++;
                levelList.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                queue.poll();
            }
            res.add(levelList);
        }

        return res;
    }
}