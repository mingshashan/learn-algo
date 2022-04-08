package com.mingshashan.learn.lt;

import com.mingshashan.learn.lt.l563.Solution_563;
import com.mingshashan.learn.lt.l563.TreeNode;
import org.junit.Assert;
import org.junit.Test;

public class Solution_563_Test {

    @Test
    public void test_01() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        int result = new Solution_563().findTilt(root);
        int expect = 1;
        Assert.assertTrue("ok", result == expect);
    }

    @Test
    public void test_02() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(9);
        root.right.right = new TreeNode(7);
        int result = new Solution_563().findTilt(root);
        int expect = 15;
        Assert.assertTrue("ok", result == expect);
    }

    @Test
    public void test_03() {
        TreeNode root = new TreeNode(21);
        root.left = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(3);
        root.left.right = new TreeNode(1);
        root.right = new TreeNode(14);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(2);
        int result = new Solution_563().findTilt(root);
        int expect = 9;
        Assert.assertTrue("ok", result == expect);
    }
}
