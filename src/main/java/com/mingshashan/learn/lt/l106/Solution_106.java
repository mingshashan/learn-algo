package com.mingshashan.learn.lt.l106;

import java.util.HashMap;
import java.util.Map;

class Solution_106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (null == inorder || null == postorder) {
            return null;
        }

        Map<Integer, Integer> inOrderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inOrderIndexMap.put(inorder[i], i);
        }

        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, inOrderIndexMap);
    }

    private TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd, Map<Integer, Integer> inOrderIndexMap) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }

        int rootValue = postorder[postEnd];
        int index = inOrderIndexMap.get(rootValue);
        int leftSize = index - inStart;
        TreeNode root = new TreeNode(rootValue);
        root.left = build(inorder, inStart, index - 1, postorder, postStart, postStart + leftSize - 1, inOrderIndexMap);
        root.right = build(inorder, index + 1, inEnd, postorder, postStart + leftSize, postEnd - 1, inOrderIndexMap);
        return root;
    }
}