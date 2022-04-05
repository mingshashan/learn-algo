package com.mingshashan.learn.lt;

import com.mingshashan.learn.lt.l101.Solution_101;
import com.mingshashan.learn.lt.l101.TreeNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * Solution_101_Test
 *
 * @author mingshashan
 */
public class Solution_101_Test {

    @Test
    public void test_01() {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right = new TreeNode(2);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        boolean result = new Solution_101().isSymmetric(root);
        Assert.assertTrue("ok", result);
    }

    @Test
    public void test_02() {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(3);

        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);

        boolean result = new Solution_101().isSymmetric(root);
        Assert.assertTrue("ok", !result);
    }

    @Test
    public void test_03() {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(5);
        root.left.left.right = new TreeNode(6);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(8);

        root.right = new TreeNode(2);
        root.right.left = new TreeNode(4);
        root.right.left.left = new TreeNode(8);
        root.right.left.right = new TreeNode(7);
        root.right.right = new TreeNode(3);
        root.right.right.left = new TreeNode(6);
        root.right.right.right = new TreeNode(5);

        boolean result = new Solution_101().isSymmetric(root);
        Assert.assertTrue("ok", result);
    }

    @Test
    public void test_04() {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(5);
        root.left.left.left.left = new TreeNode(9);
        root.left.left.right = new TreeNode(6);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(8);

        root.right = new TreeNode(2);
        root.right.left = new TreeNode(4);
        root.right.left.left = new TreeNode(8);
        root.right.left.right = new TreeNode(7);
        root.right.right = new TreeNode(3);
        root.right.right.left = new TreeNode(6);
        root.right.right.right = new TreeNode(5);
        root.right.right.right.right = new TreeNode(9);

        boolean result = new Solution_101().isSymmetric(root);
        Assert.assertTrue("ok", result);
    }
}
