package com.mingshashan.learn.lt.l889;

import java.util.HashMap;

class Solution_889_V2 {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        HashMap<Integer, Integer> postIndexMap = new HashMap<>();
        for (int i = 0; i < postorder.length; i++) {
            postIndexMap.put(postorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1, postIndexMap);
    }

    private TreeNode build(int[] preorder, int preStart, int preEnd, int[] postorder, int postStart, int postEnd, HashMap<Integer, Integer> postIndexMap) {
        if (preStart > preEnd || postStart > postEnd) {
            return null;
        }
        if (preStart == preEnd) {
            return new TreeNode(preorder[preStart]);
        }

        // root value
        int rootValue = preorder[preStart];
        // left node Value
        int leftRootValue = preorder[preStart + 1];

        // find left node in postorder
        int index = postIndexMap.get(leftRootValue);

        // 需要减去root占用的1
        int leftSize = index - postStart + 1;
        TreeNode root = new TreeNode(rootValue);
        root.left = build(preorder, preStart + 1, preStart + leftSize, postorder, postStart, index, postIndexMap);
        root.right = build(preorder, preStart + leftSize + 1, preEnd, postorder, index + 1, postEnd - 1, postIndexMap);

        return root;
    }
}