package com.mingshashan.learn.lt;

import com.mingshashan.learn.lt.l004.Solution_004_V2;
import org.junit.Assert;
import org.junit.Test;

public class Solution_004_V2_Test {

    @Test
    public void test_01() {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};

        double result = new Solution_004_V2().findMedianSortedArrays(nums1, nums2);
        double except = 2.00000;
        double delta = 0.0001;
        Assert.assertEquals("ok", result, except, delta);
    }

    @Test
    public void test_02() {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};

        double result = new Solution_004_V2().findMedianSortedArrays(nums1, nums2);
        double except = 2.50000;
        double delta = 0.0001;
        Assert.assertEquals("ok", result, except, delta);
    }

}
