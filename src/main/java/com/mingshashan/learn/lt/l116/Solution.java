package com.mingshashan.learn.lt.l116;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

class Solution {

    public Node connect(Node root) {
        if (null == root) {
            return null;
        }

        connect2Node(root.left, root.right);
        return root;
    }

    private void connect2Node(Node left, Node right) {
        if (null == left || null == right) {
            return;
        }

        left.next = right;

        connect2Node(left.left, left.right);
        connect2Node(right.left, right.right);


        connect2Node(left.right, right.left);
    }

}