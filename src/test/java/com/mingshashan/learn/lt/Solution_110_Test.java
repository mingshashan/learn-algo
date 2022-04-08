package com.mingshashan.learn.lt;

import com.mingshashan.learn.lt.l110.Solution_110;
import com.mingshashan.learn.lt.l110.TreeNode;
import org.junit.Assert;
import org.junit.Test;

public class Solution_110_Test {

    @Test
    public void test_01() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        boolean result = new Solution_110().isBalanced(root);
        Assert.assertTrue("ok", result);
    }

    @Test
    public void test_02() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.left.left = new TreeNode(19);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        boolean result = new Solution_110().isBalanced(root);
        Assert.assertTrue("ok", result);
    }


    @Test
    public void test_03() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(4);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(2);
        boolean result = new Solution_110().isBalanced(root);
        Assert.assertTrue("ok", !result);
    }
}
