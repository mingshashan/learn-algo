package com.mingshashan.learn.lt.common;

import java.util.List;

public class ListUtil {

    public static ListNode arrayToList(int[] array) {
        if (null == array || 0 == array.length) {
            return null;
        }
        ListNode dump = new ListNode();
        ListNode head = dump;
        for (int i : array) {
            head.next = new ListNode(i);
            head = head.next;
        }
        return dump.next;
    }
}
