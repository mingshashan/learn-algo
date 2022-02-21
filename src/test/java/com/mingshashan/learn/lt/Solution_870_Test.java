package com.mingshashan.learn.lt;

import com.mingshashan.learn.lt.l870.Solution_870;
import org.junit.Assert;
import org.junit.Test;

public class Solution_870_Test {

    @Test
    public void test_01() {
        int[] nums1 = {2, 7, 11, 15};
        int[] nums2 = {1, 10, 4, 11};
        int[] result = new Solution_870().advantageCount(nums1, nums2);
        int[] expect = {2, 11, 7, 15};
        Assert.assertArrayEquals("ok", expect, result);
    }

    @Test
    public void test_02() {
        int[] nums1 = {12, 24, 8, 32};
        int[] nums2 = {13, 25, 32, 11};
        int[] result = new Solution_870().advantageCount(nums1, nums2);
        int[] expect = {24, 32, 8, 12};
        Assert.assertArrayEquals("ok", expect, result);
    }


}
