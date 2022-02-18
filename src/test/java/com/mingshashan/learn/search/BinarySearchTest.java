package com.mingshashan.learn.search;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * BinarySearch Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>2月 18, 2022</pre>
 */
public class BinarySearchTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: binarySearch(int[] nums, int target)
     */
    @Test
    public void testBinarySearch() throws Exception {

        int[] nums = new int[]{1, 2, 3, 3, 4, 5, 6, 7, 8, 9, 10};
        int location = new BinarySearch().binarySearch(nums, 7);
        Assert.assertTrue("ok", location == 7);
    }


} 
