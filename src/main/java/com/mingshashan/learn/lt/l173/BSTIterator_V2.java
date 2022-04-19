package com.mingshashan.learn.lt.l173;

import java.util.Stack;

/**
 * Implement the BSTIterator class that represents an iterator over
 * the in-order traversal of a binary search tree (BST):
 * <p>
 * BSTIterator(TreeNode root) Initializes an object of the BSTIterator class.
 * The root of the BST is given as part of the constructor.
 * The pointer should be initialized to a non-existent number smaller than any element in the BST.
 * boolean hasNext() Returns true if there exists a number in the traversal to
 * the right of the pointer, otherwise returns false.
 * int next() Moves the pointer to the right, then returns the number at the pointer.
 * Notice that by initializing the pointer to a non-existent smallest number,
 * the first call to next() will return the smallest element in the BST.
 * <p>
 * You may assume that next() calls will always be valid. That is, there will be at least a next number in the in-order traversal when next() is called.
 * <p>
 * <p>
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 * <p>
 * 中序遍历（即按照升序庆历）
 */
public class BSTIterator_V2 {

    TreeNode root;
    Stack<TreeNode> stack;

    public BSTIterator_V2(TreeNode root) {
        if (null == root) {
            return;
        }
        this.root = root;
        this.stack = new Stack<>();
        inorder(root);
    }

    private void inorder(TreeNode root) {
        if (null == root) {
            return;
        }
        inorder(root.right);
        stack.push(root);
        inorder(root.left);
    }

    public int next() {
        return stack.pop().val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}