package com.mingshashan.learn.lt;

import com.mingshashan.learn.lt.l496.Solution_496;
import org.junit.Assert;
import org.junit.Test;

/**
 * Solution_496_Test
 *
 * @author mingshashan
 */
public class Solution_496_Test {

    @Test
    public void test_01() {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};

        int[] result = new Solution_496().nextGreaterElement(nums1, nums2);
        int[] expect = {-1, 3, -1};

        Assert.assertArrayEquals("ok", result, expect);
    }


    @Test
    public void test_02() {
        int[] nums1 = {2, 4};
        int[] nums2 = {1, 2, 3, 4};

        int[] result = new Solution_496().nextGreaterElement(nums1, nums2);
        int[] expect = {3, -1};

        Assert.assertArrayEquals("ok", result, expect);
    }

    @Test
    public void test_03() {
        int[] nums1 = {1, 3, 5, 2, 4};
        int[] nums2 = {6, 5, 4, 3, 2, 1, 7};

        int[] result = new Solution_496().nextGreaterElement(nums1, nums2);
        int[] expect = {7, 7, 7, 7, 7};

        Assert.assertArrayEquals("ok", result, expect);
    }
}
