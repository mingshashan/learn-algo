package com.mingshashan.learn.lt;

import com.mingshashan.learn.lt.l058.Solution_058;
import org.junit.Assert;
import org.junit.Test;

public class Solution_058_Test {

    @Test
    public void test_01() {
        String s = "Hello World";
        int result = new Solution_058().lengthOfLastWord(s);
        int except = 5;
        Assert.assertEquals("ok", except, result);
    }


    @Test
    public void test_02() {
        String s = "   fly me   to   the moon  ";
        int result = new Solution_058().lengthOfLastWord(s);
        int except = 4;
        Assert.assertEquals("ok", except, result);
    }


    @Test
    public void test_03() {
        String s = "luffy is still joyboy";
        int result = new Solution_058().lengthOfLastWord(s);
        int except = 6;
        Assert.assertEquals("ok", except, result);
    }

    @Test
    public void test_04() {
        String s = "abc  ";
        int result = new Solution_058().lengthOfLastWord(s);
        int except = 3;
        Assert.assertEquals("ok", except, result);
    }

    @Test
    public void test_05() {
        String s = "  ";
        int result = new Solution_058().lengthOfLastWord(s);
        int except = 0;
        Assert.assertEquals("ok", except, result);
    }
}
