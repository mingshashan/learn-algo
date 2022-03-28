package com.mingshashan.learn.lt.l297;

import java.util.LinkedList;

/**
 * Serialization is the process of converting a data structure or object into a sequence of bits
 * so that it can be stored in a file or memory buffer, or transmitted across a network connection link
 * to be reconstructed later in the same or another computer environment.
 * <p>
 * Design an algorithm to serialize and deserialize a binary tree.
 * There is no restriction on how your serialization/deserialization algorithm should work.
 * You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 * <p>
 * Clarification: The input/output format is the same as how LeetCode serializes a binary tree.
 * You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
 * <p>
 * Input: root = [1,2,3,null,null,4,5]
 * Output: [1,2,3,null,null,4,5]
 * <p>
 * Input: root = []
 * Output: []
 */
public class Codec_PreOrder {

    private final static String SPLIT = ",";
    private final static String NULL = "#";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeTree(root, sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (null == data || 0 == data.length()) {
            return null;
        }
        LinkedList<String> nodes = new LinkedList<>();
        for (String node : data.split(SPLIT)) {
            nodes.add(node);
        }
        return deserializeTree(nodes);
    }

    public void serializeTree(TreeNode root, StringBuilder sb) {
        if (null == root) {
            sb.append(NULL).append(SPLIT);
            return;
        }

        sb.append(root.val).append(SPLIT);
        serializeTree(root.left, sb);
        serializeTree(root.right, sb);
    }

    public TreeNode deserializeTree(LinkedList<String> nodes) {
        if (nodes.isEmpty()) {
            return null;
        }

        String firstNode = nodes.removeFirst();
        if (firstNode.equals(NULL)) {
            return null;
        }

        TreeNode treeNode = new TreeNode(Integer.parseInt(firstNode));
        treeNode.left = deserializeTree(nodes);
        treeNode.right = deserializeTree(nodes);
        return treeNode;
    }
}