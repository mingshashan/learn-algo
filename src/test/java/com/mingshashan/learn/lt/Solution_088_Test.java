package com.mingshashan.learn.lt;

import com.mingshashan.learn.lt.l088.Solution_088;
import org.junit.Assert;
import org.junit.Test;

public class Solution_088_Test {
    @Test
    public void test_01() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;

        new Solution_088().merge(nums1, m, nums2, n);
        int[] except = {1, 2, 2, 3, 5, 6};

        Assert.assertArrayEquals("ok", except, nums1);
    }

    @Test
    public void test_02() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;

        new Solution_088().merge(nums1, m, nums2, n);
        int[] except = {1, 2, 2, 3, 5, 6};

        Assert.assertArrayEquals("ok", except, nums1);
    }

    @Test
    public void test_03() {
        int[] nums1 = {0};
        int m = 0;
        int[] nums2 = {1};
        int n = 1;

        new Solution_088().merge(nums1, m, nums2, n);
        int[] except = {1};

        Assert.assertArrayEquals("ok", except, nums1);
    }
}
