package com.mingshashan.learn.lt.l606;

public class Solution_606_V2 {
    public StringBuilder str;

    public String tree2str(TreeNode root) {
        str = new StringBuilder("");
        if (root != null)
            helper(root);
        String str1 = str.toString();
        str1 = str1.substring(0, str1.length() - 1);
        return str1;
    }

    public void helper(TreeNode root) {
        if (root.left == null && root.right == null) {
            str.append(root.val);
        } else {
            str.append(root.val);
        }
        if (root.left != null) {
            str.append("(");
            helper(root.left);
        }
        if (root.right != null) {
            if (root.left == null) {
                str.append("()");
            }
            str.append("(");
            helper(root.right);
        }
        str.append(")");
    }
}