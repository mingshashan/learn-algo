package com.mingshashan.learn.lt;

import com.mingshashan.learn.lt.l743.Solution_743;
import org.junit.Assert;
import org.junit.Test;

/**
 * You are given a network of n nodes, labeled from 1 to n.
 * You are also given times, a list of travel times as directed edges
 * times[i] = (ui, vi, wi), where ui is the source node,
 * vi is the target node, and wi is the time it takes for a signal to travel from source to target.
 * <p>
 * We will send a signal from a given node k. Return the time
 * it takes for all the n nodes to receive the signal.
 * If it is impossible for all the n nodes to receive the signal, return -1.
 * <p>
 * Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
 * Output: 2
 * <p>
 * Input: times = [[1,2,1]], n = 2, k = 1
 * Output: 1
 * <p>
 * Input: times = [[1,2,1]], n = 2, k = 2
 * Output: -1
 */
public class Solution_743_Test {

    @Test
    public void test_01() {
        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int n = 4, k = 2;
        int result = new Solution_743().networkDelayTime(times, n, k);
        int except = 2;

        Assert.assertTrue("ok", result == except);
    }

    @Test
    public void test_02() {
        int[][] times = {{1, 2, 1}};
        int n = 2, k = 1;
        int result = new Solution_743().networkDelayTime(times, n, k);
        int except = 1;

        Assert.assertTrue("ok", result == except);
    }

    @Test
    public void test_03() {
        int[][] times = {{1, 2, 1}};
        int n = 2, k = 2;
        int result = new Solution_743().networkDelayTime(times, n, k);
        int except = -1;

        Assert.assertTrue("ok", result == except);
    }
}