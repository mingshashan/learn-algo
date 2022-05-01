package com.mingshashan.learn.lt;

import com.mingshashan.learn.lt.l014.Solution_014;
import org.junit.Assert;
import org.junit.Test;

public class Solution_014_Test {

    @Test
    public void test_01() {
        String[] strs = {"flower", "flow", "flight"};
        String result = new Solution_014().longestCommonPrefix(strs);
        String expect = "fl";
        Assert.assertEquals("ok", result, expect);
    }

    @Test
    public void test_02() {
        String[] strs = {"dog", "racecar", "car"};
        String result = new Solution_014().longestCommonPrefix(strs);
        String expect = "";
        Assert.assertEquals("ok", result, expect);
    }

}
