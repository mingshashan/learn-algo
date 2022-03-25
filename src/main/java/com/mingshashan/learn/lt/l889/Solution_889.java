package com.mingshashan.learn.lt.l889;

import java.util.HashMap;
import java.util.logging.Handler;

class Solution_889 {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return build(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode build(int[] preorder, int preStart, int preEnd, int[] postorder, int postStart, int postEnd) {
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
        int index = 0;
        for (int i = postStart; i <= postEnd; i++) {
            if (leftRootValue == postorder[i]) {
                index = i;
                break;
            }
        }

        // 需要减去root占用的1
        int leftSize = index - postStart + 1;
        TreeNode root = new TreeNode(rootValue);
        root.left = build(preorder, preStart + 1, preStart + leftSize, postorder, postStart, index);
        root.right = build(preorder, preStart + leftSize + 1, preEnd, postorder, index + 1, postEnd - 1);

        return root;
    }
}