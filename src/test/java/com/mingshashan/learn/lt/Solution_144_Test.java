package com.mingshashan.learn.lt;

import com.mingshashan.learn.lt.l144.Solution_144;
import com.mingshashan.learn.lt.l144.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution_144_Test {

    @Test
    public void test_01() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<Integer> result = new Solution_144().preorderTraversal(root);
        List<Integer> expect = new ArrayList<>();
        expect.add(1);
        expect.add(2);
        expect.add(3);

        Assert.assertTrue("ok", result.size() == expect.size());
    }

    @Test
    public void test_02() {
        TreeNode root = null;

        List<Integer> result = new Solution_144().preorderTraversal(root);

        Assert.assertTrue("ok", null == result);
    }

    @Test
    public void test_03() {
        TreeNode root = new TreeNode(1);

        List<Integer> result = new Solution_144().preorderTraversal(root);
        List<Integer> expect = new ArrayList<>();
        expect.add(1);

        Assert.assertTrue("ok", result.size() == expect.size());
    }
}
