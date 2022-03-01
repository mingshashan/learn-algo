package com.mingshashan.learn.lt.l2095;

/**
 * The number of nodes in the list is in the range [1, 105].
 * 1 <= Node.val <= 105
 */
public class Solution_2095 {
    public ListNode deleteMiddle(ListNode head) {
        if (null == head || null == head.next) {
            return null;
        }

        ListNode dumpy = new ListNode(-1);
        dumpy.next = head;
        ListNode beforeMiddleNode = findBeforeMiddleNode(dumpy);
        beforeMiddleNode.next = beforeMiddleNode.next.next;
        return dumpy.next;
    }

    // 因为不知道N的长度是多少，所以要用快慢指针往前走
    private ListNode findBeforeMiddleNode(ListNode head) {
        ListNode fast = head, slow = head;
        // 寄、偶情况要分别注意
        while (fast != null) {
            if (fast.next == null || fast.next.next == null) {
                break;
            }
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}