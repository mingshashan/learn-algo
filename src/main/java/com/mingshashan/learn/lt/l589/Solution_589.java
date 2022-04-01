package com.mingshashan.learn.lt.l589;

import java.util.LinkedList;
import java.util.List;

/**
 * Given the root of an n-ary tree, return the preorder traversal of its nodes' values.
 * <p>
 * Nary-Tree input serialization is represented in their level order traversal.
 * Each group of children is separated by the null value (See examples)
 * <p>
 * N叉树的前序遍历
 */
public class Solution_589 {
    List<Integer> result = new LinkedList<>();

    public List<Integer> preorder(Node root) {
        if (null == root) {
            return result;
        }
        preorderTraverse(root);
        return result;
    }

    private void preorderTraverse(Node root) {
        if (null == root) {
            return;
        }
        // root
        result.add(root.val);
        // children
        for (Node node : root.children) {
            preorderTraverse(node);
        }
    }
}