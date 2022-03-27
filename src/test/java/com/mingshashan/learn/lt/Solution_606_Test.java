package com.mingshashan.learn.lt;

import com.mingshashan.learn.lt.l606.Solution_606;
import com.mingshashan.learn.lt.l606.Solution_606_V2;
import com.mingshashan.learn.lt.l606.TreeNode;
import org.junit.Assert;
import org.junit.Test;

public class Solution_606_Test {

    @Test
    public void test_01() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);

        String result = new Solution_606().tree2str(root);
        String expect = "1(2(4))(3)";
        Assert.assertTrue("ok", expect.equals(result));
    }

    @Test
    public void test_V2_01() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);

        String result = new Solution_606_V2().tree2str(root);
        String expect = "1(2(4))(3)";
        Assert.assertTrue("ok", expect.equals(result));
    }
}
