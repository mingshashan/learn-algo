package com.mingshashan.learn.lt;

import com.mingshashan.learn.lt.l006.Solution_006;
import org.junit.Assert;
import org.junit.Test;

public class Solution_006_Test {

    @Test
    public void test_01() {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        String result = new Solution_006().convert(s, numRows);
        String except = "PAHNAPLSIIGYIR";
        Assert.assertEquals("ok", except, result);
    }

    @Test
    public void test_02() {
        String s = "PAYPALISHIRING";
        int numRows = 4;
        String result = new Solution_006().convert(s, numRows);
        String except = "PINALSIGYAHRPI";
        Assert.assertEquals("ok", except, result);
    }

    @Test
    public void test_03() {
        String s = "A";
        int numRows = 1;
        String result = new Solution_006().convert(s, numRows);
        String except = "A";
        Assert.assertEquals("ok", except, result);
    }
}
