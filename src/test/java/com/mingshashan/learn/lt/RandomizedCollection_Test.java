package com.mingshashan.learn.lt;

import com.mingshashan.learn.lt.l381.RandomizedCollection;
import org.junit.Assert;
import org.junit.Test;

public class RandomizedCollection_Test {

    /**
     * ["RandomizedCollection","insert","insert","remove","insert","remove","getRandom"]
     * [[],[0],[1],[0],[2],[1],[]]
     * <p>
     * [null,true,true,true,true,true,2]
     */
    @Test
    public void test_01() {
        RandomizedCollection randomizedCollection = new RandomizedCollection();
        Assert.assertTrue("ok", randomizedCollection.insert(0));
        Assert.assertTrue("ok", randomizedCollection.insert(1));
        Assert.assertTrue("ok", randomizedCollection.remove(0));
        Assert.assertTrue("ok", randomizedCollection.insert(2));
        Assert.assertTrue("ok", randomizedCollection.remove(1));
        Assert.assertTrue("ok", randomizedCollection.getRandom() == 2);
    }

    /**
     * ["RandomizedCollection","insert","insert","insert","insert","insert","remove","remove","remove","remove"]
     * [[],[4],[3],[4],[2],[4],[4],[3],[4],[4]]
     */
    @Test
    public void test_02() {
        RandomizedCollection randomizedCollection = new RandomizedCollection();
        Assert.assertTrue("ok", randomizedCollection.insert(4));
        Assert.assertTrue("ok", randomizedCollection.insert(3));
        Assert.assertTrue("ok", !randomizedCollection.insert(4));
        Assert.assertTrue("ok", randomizedCollection.insert(2));
        Assert.assertTrue("ok", !randomizedCollection.insert(4));

        Assert.assertTrue("ok", randomizedCollection.remove(4));
        Assert.assertTrue("ok", randomizedCollection.remove(3));
        Assert.assertTrue("ok", randomizedCollection.remove(4));
        Assert.assertTrue("ok", randomizedCollection.remove(4));


        Assert.assertTrue("ok", randomizedCollection.getRandom() == 2);
    }

    /**
     * ["RandomizedCollection","insert","insert","insert","insert","insert","remove","remove","remove","insert","remove","getRandom","getRandom","getRandom","getRandom","getRandom","getRandom","getRandom","getRandom","getRandom","getRandom"]
     * [[],
     * insert [1],[1],[2],[2],[2],
     * remove [1],[1],[2],
     * insert [1],
     * remove [2],[],[],[],[],[],[],[],[],[],[]]
     */
    @Test
    public void test_03() {
        RandomizedCollection randomizedCollection = new RandomizedCollection();
        Assert.assertTrue("ok", randomizedCollection.insert(4));
        Assert.assertTrue("ok", randomizedCollection.insert(3));
        Assert.assertTrue("ok", !randomizedCollection.insert(4));
        Assert.assertTrue("ok", randomizedCollection.insert(2));
        Assert.assertTrue("ok", !randomizedCollection.insert(4));

        Assert.assertTrue("ok", randomizedCollection.remove(4));
        Assert.assertTrue("ok", randomizedCollection.remove(3));
        Assert.assertTrue("ok", randomizedCollection.remove(4));
        Assert.assertTrue("ok", randomizedCollection.remove(4));


        Assert.assertTrue("ok", randomizedCollection.getRandom() == 2);
    }
}
