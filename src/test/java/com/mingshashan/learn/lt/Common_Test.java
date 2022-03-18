package com.mingshashan.learn.lt;

import org.junit.Test;

public class Common_Test {

    @Test
    public void test01() {
        int x = 0xFFF;
        System.out.printf("10: [%x] , 16: [%s]\n", x, Integer.toBinaryString(x));
        int y = ~0xFFF;
        System.out.printf("10: [%x] , 16: [%s]\n", y, Integer.toBinaryString(y));

        System.out.println(Integer.toBinaryString(1 << 26));
    }
}
