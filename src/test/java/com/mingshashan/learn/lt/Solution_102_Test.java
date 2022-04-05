package com.mingshashan.learn.lt;

import com.mingshashan.learn.lt.l102.Solution_102;
import com.mingshashan.learn.lt.l102.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Solution_102_Test
 *
 * @author mingshashan
 */
public class Solution_102_Test {

    @Test
    public void test_01() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> res = new Solution_102().levelOrder(root);

        Assert.assertTrue("ok", 3 == res.size());
    }


    @Test
    public void test_02() {
        TreeNode root = new TreeNode(1);

        List<List<Integer>> res = new Solution_102().levelOrder(root);

        Assert.assertTrue("ok", 1 == res.size());
    }


    @Test
    public void test_03() {
        TreeNode root = null;

        List<List<Integer>> res = new Solution_102().levelOrder(root);

        Assert.assertTrue("ok", 0 == res.size());
    }
}
