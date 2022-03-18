package com.mingshashan.learn.lt;

import com.mingshashan.learn.lt.l380.RandomizedSet;
import org.junit.Assert;
import org.junit.Test;

public class RandomizedSet_Test {


    // ["RandomizedSet","insert","insert","remove","insert","remove","getRandom"]
    // [[],[0],[1],[0],[2],[1],[]]
    @Test
    public void test_01() {
        RandomizedSet randomizedSet = new RandomizedSet();
        Assert.assertTrue("ok", randomizedSet.insert(0));
        Assert.assertTrue("ok", randomizedSet.insert(1));
        Assert.assertTrue("ok", randomizedSet.remove(0));
        Assert.assertTrue("ok", randomizedSet.insert(2));
        Assert.assertTrue("ok", randomizedSet.remove(1));
        Assert.assertTrue("ok", randomizedSet.getRandom() == 2);
    }
}
