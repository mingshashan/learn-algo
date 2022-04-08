package com.mingshashan.learn.lt.l563;

public class Solution_563 {

    int result = 0;
    public int findTilt(TreeNode root) {
        if (null == root) {
            return 0;
        }
        traverseSum(root);
        return result;
    }

    /**
     * 后序遍历
     *
     * @param root
     * @return
     */
    private int traverseSum(TreeNode root) {
        if (null == root) {
            return 0;
        }

        // 左子树
        int left = traverseSum(root.left);
        // 右子树
        int right = traverseSum(root.right);
        // node
        int sum = left + right + root.val;

        result += Math.abs(left - right);
        return sum;
    }
}