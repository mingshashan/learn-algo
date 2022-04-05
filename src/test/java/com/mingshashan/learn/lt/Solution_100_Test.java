package com.mingshashan.learn.lt;

import com.mingshashan.learn.lt.l100.Solution_100;
import com.mingshashan.learn.lt.l100.TreeNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * Solution_100_Test
 *
 * @author mingshashan
 */
public class Solution_100_Test {

    @Test
    public void test_01() {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);

        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);

        boolean result = new Solution_100().isSameTree(p, q);
        Assert.assertTrue("ok", result);
    }

    @Test
    public void test_02() {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);

        TreeNode q = new TreeNode(1);
        q.right = new TreeNode(2);

        boolean result = new Solution_100().isSameTree(p, q);
        Assert.assertTrue("ok", !result);
    }

    @Test
    public void test_03() {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(1);

        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(1);
        q.right = new TreeNode(2);

        boolean result = new Solution_100().isSameTree(p, q);
        Assert.assertTrue("ok", !result);
    }


    @Test
    public void test_04() {
        TreeNode p = new TreeNode(0);
        p.left = new TreeNode(-5);

        TreeNode q = new TreeNode(0);
        q.left = new TreeNode(-8);

        boolean result = new Solution_100().isSameTree(p, q);
        Assert.assertTrue("ok", !result);
    }

}
