package com.mingshashan.learn.lt;

import com.mingshashan.learn.lt.l653.Solution_653;
import com.mingshashan.learn.lt.l653.TreeNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * Solution_653_test
 *
 * @author mingshashan
 */
public class Solution_653_Test {

    @Test
    public void test_01() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(6);
        root.right.right = new TreeNode(7);

        boolean res = new Solution_653().findTarget(root, 9);
        Assert.assertTrue("ok", res);
    }

    @Test
    public void test_02() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(6);
        root.right.right = new TreeNode(7);

        boolean res = new Solution_653().findTarget(root, 28);
        Assert.assertTrue("ok", !res);
    }
}
