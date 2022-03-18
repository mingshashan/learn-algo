package com.mingshashan.learn.lt.l710;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * You are given an integer n and an array of unique integers blacklist. Design an algorithm to pick a random integer in the range [0, n - 1] that is not in blacklist. Any integer that is in the mentioned range and not in blacklist should be equally likely to be returned.
 * <p>
 * Optimize your algorithm such that it minimizes the number of calls to the built-in random function of your language.
 * <p>
 * Implement the Solution class:
 * <p>
 * Solution(int n, int[] blacklist) Initializes the object with the integer n and the blacklisted integers blacklist.
 * int pick() Returns a random integer in the range [0, n - 1] and not in blacklist.
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution_710 = new Solution(5, new int[]{4, 0, 3});
        System.out.println(solution_710.pick());
        System.out.println(solution_710.pick());
        System.out.println(solution_710.pick());
        System.out.println(solution_710.pick());
        System.out.println(solution_710.pick());
        System.out.println(solution_710.pick());
        System.out.println(solution_710.pick());
        System.out.println(solution_710.pick());
        System.out.println(solution_710.pick());
        System.out.println(solution_710.pick());
    }

    int sz;
    Map<Integer, Integer> map;

    public Solution(int n, int[] blacklist) {
        int x = 999;
        sz = n - blacklist.length;
        map = new HashMap<>();
        for (int b : blacklist) {
            map.put(b, x);
        }

        int last = n - 1;
        for (int b : blacklist) {
            if (b >= sz) {
                continue;
            }
            while (map.containsKey(last)) {
                last--;
            }

            map.put(b, last);
            last--;
        }

    }

    public int pick() {
        int random = new Random().nextInt();
        int index = (random >= 0 ? random : -random) % sz;
        if (map.containsKey(index)) {
            index = map.get(index);
        }
        return index;
    }
}
