package com.mingshashan.learn.lt;

import com.mingshashan.learn.lt.l515.Solution_515;
import com.mingshashan.learn.lt.l515.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class Solution_515_Test {

    @Test
    public void test_01() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(9);

        List<Integer> result = new Solution_515().largestValues(root);
        List<Integer> expect = new LinkedList<>();
        expect.add(1);
        expect.add(3);
        expect.add(9);
        Assert.assertArrayEquals("ok", result.stream().toArray(), expect.stream().toArray());
    }

    @Test
    public void test_02() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);

        List<Integer> result = new Solution_515().largestValues(root);
        List<Integer> expect = new LinkedList<>();
        expect.add(1);
        expect.add(3);
        Assert.assertArrayEquals("ok", result.stream().toArray(), expect.stream().toArray());
    }
}
