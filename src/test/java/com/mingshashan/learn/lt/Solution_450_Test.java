package com.mingshashan.learn.lt;

import com.mingshashan.learn.lt.l450.Solution_450;
import com.mingshashan.learn.lt.l450.TreeNode;
import org.junit.Test;

/**
 * @author mingshashan
 */
public class Solution_450_Test {

    @Test
    public void test_01() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(6);
        root.right.right = new TreeNode(7);

        TreeNode result = new Solution_450().deleteNode(root, 3);
        System.out.println(result);
    }

    @Test
    public void test_02() {

    }

    @Test
    public void test_03() {

    }
}
