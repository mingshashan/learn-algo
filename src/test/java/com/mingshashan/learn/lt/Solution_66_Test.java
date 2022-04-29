package com.mingshashan.learn.lt;

import com.mingshashan.learn.lt.l066.Solution_66;
import org.junit.Assert;
import org.junit.Test;

public class Solution_66_Test {

    @Test
    public void test_01() {
        int[] digits = {1, 2, 3};
        int[] result = new Solution_66().plusOne(digits);
        int[] except = {1, 2, 4};
        Assert.assertArrayEquals("ok", except, result);
    }

    @Test
    public void test_02() {
        int[] digits = {4, 3, 2, 1};
        int[] result = new Solution_66().plusOne(digits);
        int[] except = {4, 3, 2, 2};
        Assert.assertArrayEquals("ok", except, result);
    }

    @Test
    public void test_03() {
        int[] digits = {9};
        int[] result = new Solution_66().plusOne(digits);
        int[] except = {1, 0};
        Assert.assertArrayEquals("ok", except, result);
    }

    @Test
    public void test_04() {
        int[] digits = {9, 9, 9, 9};
        int[] result = new Solution_66().plusOne(digits);
        int[] except = {1, 0, 0, 0, 0};
        Assert.assertArrayEquals("ok", except, result);
    }

    @Test
    public void test_05() {
        int[] digits = {9, 9, 0, 0, 0};
        int[] result = new Solution_66().plusOne(digits);
        int[] except = {9, 9, 0, 0, 1};
        Assert.assertArrayEquals("ok", except, result);
    }

    @Test
    public void test_06() {
        int[] digits = {9, 9, 0, 0, 9};
        int[] result = new Solution_66().plusOne(digits);
        int[] except = {9, 9, 0, 1, 0};
        Assert.assertArrayEquals("ok", except, result);
    }


    @Test
    public void test_07() {
        int[] digits = {1};
        int[] result = new Solution_66().plusOne(digits);
        int[] except = {2};
        Assert.assertArrayEquals("ok", except, result);
    }
}
