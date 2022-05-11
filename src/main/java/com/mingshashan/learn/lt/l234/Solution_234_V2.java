package com.mingshashan.learn.lt.l234;

import com.mingshashan.learn.lt.common.ListNode;

/**
 * Given the head of a singly linked list, return true if it is a palindrome.
 * 234. Palindrome Linked List
 */
public class Solution_234_V2 {

    public boolean isPalindrome(ListNode head) {
        if (null == head) {
            return false;
        }

        if (null == head.next) {
            return true;
        }


        return true;
    }

    ListNode reserve(ListNode head) {
        ListNode dump = null;
        while (head != null) {
            ListNode node = head;
            node.next = dump;
            dump = node;
            head = head.next;
        }

        return dump;
    }
}