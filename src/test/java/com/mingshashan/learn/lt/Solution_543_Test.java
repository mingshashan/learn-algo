package com.mingshashan.learn.lt;

import com.mingshashan.learn.lt.l543.Solution_543;
import com.mingshashan.learn.lt.l543.TreeNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author mingshashan
 */
public class Solution_543_Test {

    @Test
    public void test_01() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        int result = new Solution_543().diameterOfBinaryTree(root);
        int expect = 3;

        Assert.assertTrue("ok", result == expect);
    }


    @Test
    public void test_02() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        int result = new Solution_543().diameterOfBinaryTree(root);
        int expect = 1;

        Assert.assertTrue("ok", result == expect);
    }


    @Test
    public void test_03() {
        TreeNode root = new TreeNode(1);

        int result = new Solution_543().diameterOfBinaryTree(root);
        int expect = 0;

        Assert.assertTrue("ok", result == expect);
    }


    @Test
    public void test_04() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        int result = new Solution_543().diameterOfBinaryTree(root);
        int expect = 4;

        Assert.assertTrue("ok", result == expect);
    }

    @Test
    public void test_05() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(8);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(9);

        int result = new Solution_543().diameterOfBinaryTree(root);
        int expect = 6;

        Assert.assertTrue("ok", result == expect);
    }
}
