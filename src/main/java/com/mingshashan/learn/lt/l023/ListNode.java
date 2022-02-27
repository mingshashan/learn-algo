package com.mingshashan.learn.lt.l023;

import java.util.ArrayList;
import java.util.List;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public List<Integer> toList() {
        List<Integer> valList = new ArrayList<>();
        ListNode node = this;
        while (node != null) {
            valList.add(node.val);
            node = node.next;
        }

        return valList;
    }
}
