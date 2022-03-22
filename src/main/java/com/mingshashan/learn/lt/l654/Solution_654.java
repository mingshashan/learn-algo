package com.mingshashan.learn.lt.l654;

public class Solution_654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int index = left;
        int maxValue = Integer.MIN_VALUE;
        for (int i = left; i <= right; i++) {
            if (maxValue < nums[i]) {
                index = i;
                maxValue = nums[i];
            }
        }
        TreeNode node = new TreeNode(maxValue);
        node.left = buildTree(nums, left, index - 1);
        node.right = buildTree(nums, index + 1, right);
        return node;
    }
}