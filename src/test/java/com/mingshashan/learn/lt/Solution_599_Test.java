package com.mingshashan.learn.lt;

import com.mingshashan.learn.lt.l599.Solution_599;
import org.junit.Assert;
import org.junit.Test;

public class Solution_599_Test {

    @Test
    public void test_01() {
        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};

        String[] result = new Solution_599().findRestaurant(list1, list2);
        String[] expect = {"Shogun"};

        Assert.assertArrayEquals("ok", expect, result);
    }

    @Test
    public void test_02() {
        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"KFC", "Shogun", "Burger King"};

        String[] result = new Solution_599().findRestaurant(list1, list2);
        String[] expect = {"Shogun"};

        Assert.assertArrayEquals("ok", expect, result);
    }

    @Test
    public void test_03() {
        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"KFC", "Burger King", "Tapioca Express", "Shogun"};
        String[] result = new Solution_599().findRestaurant(list1, list2);
        String[] expect = {"KFC", "Burger King", "Tapioca Express", "Shogun"};

        Assert.assertArrayEquals("ok", expect, result);
    }

}
