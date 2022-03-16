package com.mingshashan.learn.lt;

import com.mingshashan.learn.lt.l460.LFUCache;
import org.junit.Assert;
import org.junit.Test;

public class LFUCache_Test {

    // Input
    //["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", "get"]
    //[[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
    //Output
    //[null, null, null, 1, null, -1, 3, null, -1, 3, 4]
    @Test
    public void test_01() {
        LFUCache lfuCache = new LFUCache(2);
        int value;
        lfuCache.put(1, 1);
        lfuCache.put(2, 2);
        value = lfuCache.get(1);
        Assert.assertTrue("ok", 1 == value);
        lfuCache.put(3, 3);

        value = lfuCache.get(2);
        Assert.assertTrue("ok", -1 == value);

        value = lfuCache.get(3);
        Assert.assertTrue("ok", 3 == value);

        lfuCache.put(4, 4);

        value = lfuCache.get(1);
        Assert.assertTrue("ok", -1 == value);

        value = lfuCache.get(3);
        Assert.assertTrue("ok", 3 == value);

        value = lfuCache.get(4);
        Assert.assertTrue("ok", 4 == value);

    }

    @Test
    public void test_02() {
        LFUCache lfuCache = new LFUCache(0);
        int value;
        lfuCache.put(0, 0);
        value = lfuCache.get(1);
        Assert.assertTrue("ok", -1 == value);
    }
}
