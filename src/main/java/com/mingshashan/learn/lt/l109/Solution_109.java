package com.mingshashan.learn.lt.l109;

/**
 * Given an integer array nums where the elements are sorted in ascending order,
 * convert it to a height-balanced binary search tree.
 * <p>
 * A height-balanced binary tree is a binary tree in which the depth
 * of the two subtrees of every node never differs by more than one.
 */
public class Solution_109 {

    public TreeNode sortedListToBST(ListNode head) {
        return toBST(head, null);
    }

    private TreeNode toBST(ListNode head, ListNode tail) {
        if (head == null || head == tail) {
            return null;
        }

        ListNode mid = findMid(head, tail);
        TreeNode root = new TreeNode(mid.val);
        root.left = toBST(head, mid);
        root.right = toBST(mid.next, tail);
        return root;
    }

    private ListNode findMid(ListNode head, ListNode tail) {
        ListNode fast = head, slow = head;
        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}