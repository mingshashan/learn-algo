package com.mingshashan.learn.lt.l590;

import java.util.LinkedList;
import java.util.List;

/**
 * Given the root of an n-ary tree, return the postorder traversal of its nodes' values.
 * <p>
 * Nary-Tree input serialization is represented in their level order traversal.
 * Each group of children is separated by the null value (See examples)
 * <p>
 * N叉树的后序遍历
 */
public class Solution_590 {
    List<Integer> result = new LinkedList<>();

    public List<Integer> postorder(Node root) {
        if (null == root) {
            return result;
        }
        postorderTraverse(root);
        return result;
    }

    private void postorderTraverse(Node root) {
        if (null == root) {
            return;
        }

        // children
        for (Node node : root.children) {
            postorderTraverse(node);
        }

        // root
        result.add(root.val);
    }
}