package com.mingshashan.learn.lt;

import com.mingshashan.learn.lt.l013.Solution_013_V2;
import org.junit.Assert;
import org.junit.Test;

public class Solution_013_V2_Test {

    // Explanation: III = 3.
    @Test
    public void test_01() {
        String str = "III";
        int result = new Solution_013_V2().romanToInt(str);
        int except = 3;

        Assert.assertEquals("ok", result, except);
    }

    // Explanation: L = 50, V= 5, III = 3.
    @Test
    public void test_02() {
        String str = "LVIII";
        int result = new Solution_013_V2().romanToInt(str);
        int except = 58;

        Assert.assertEquals("ok", result, except);
    }

    // Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
    @Test
    public void test_03() {
        String str = "MCMXCIV";
        int result = new Solution_013_V2().romanToInt(str);
        int except = 1994;

        Assert.assertEquals("ok", result, except);
    }
}
