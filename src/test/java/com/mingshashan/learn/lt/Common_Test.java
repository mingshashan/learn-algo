package com.mingshashan.learn.lt;

import com.mingshashan.learn.lt.common.ListNode;
import com.mingshashan.learn.lt.common.ListUtil;
import org.junit.Test;

import java.util.List;

public class Common_Test {

    @Test
    public void test01() {
        int x = 0xFFF;
        System.out.printf("10: [%x] , 16: [%s]\n", x, Integer.toBinaryString(x));
        int y = ~0xFFF;
        System.out.printf("10: [%x] , 16: [%s]\n", y, Integer.toBinaryString(y));

        System.out.println(Integer.toBinaryString(1 << 26));
    }

    ListNode reserve(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    @Test
    public void test_02() {
        ListNode head = ListUtil.arrayToList(new int[]{1, 2, 3});
        ListNode result = reserve(head);
        System.out.println(result.val);
    }

    @Test
    public void test_03() {
        int[][] array = {{0, 1, 2, 3}, {10, 11, 12, 13}, {20, 21, 22, 23}, {30, 31, 32, 33}, {40, 41, 42, 43}, {50, 51, 52, 53}};

        int m = array.length;
        int n = array[0].length;
        System.out.printf("array[%d][%d]:\n", m, n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%d\t", array[i][j]);
            }
            System.out.printf("\n");
        }
    }
}
