package com.mingshashan.learn.lt.l234;

import com.mingshashan.learn.lt.common.ListNode;

/**
 * Given the head of a singly linked list, return true if it is a palindrome.
 * 234. Palindrome Linked List
 */
public class Solution_234 {

    public boolean isPalindrome(ListNode head) {
        if (null == head) {
            return false;
        }

        if (null == head.next) {
            return true;
        }

        // find mid
        ListNode quick = head, slow = head;
        while (quick != null && quick.next != null) {
            quick = quick.next.next;
            slow = slow.next;
        }

        // 1->2->3->3->2->1
        // 1    1->2->3 1->2->3->3->2   1->2->3->3->2->1->null   quick == null,break;
        // 1    1->2    1->2->3         1->2->3->3
        // so, the slow = 3(right), quick = 2(right)
        // 1->2->3->4->3->2->1
        // 1    1->2->3 1->2->3->4->3   1->2->3->4->3->2->1   quick.next == null, break
        // 1    1->2    1->2->3         1->2->3->4
        // slow = 4, quick = 1(right)
        ListNode mid = quick == null ? slow : slow.next;
        ListNode temp = null;
        while (mid != null) {
            ListNode node = new ListNode(mid.val);
            node.next = temp;
            temp = node;
            mid = mid.next;
        }

        while (temp != null) {
            if (head.val != temp.val) {
                return false;
            }
            temp = temp.next;
            head = head.next;
        }

        return true;
    }
}