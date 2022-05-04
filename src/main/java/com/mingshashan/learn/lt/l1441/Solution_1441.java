package com.mingshashan.learn.lt.l1441;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given an array target and an integer n.
 * <p>
 * In each iteration, you will read a number from list = [1, 2, 3, ..., n].
 * <p>
 * Build the target array using the following operations:
 * <p>
 * "Push": Reads a new element from the beginning list, and pushes it in the array.
 * "Pop": Deletes the last element of the array.
 * If the target array is already built, stop reading more elements.
 * Return a list of the operations needed to build target. The test cases are generated so that the answer is unique.
 */
public class Solution_1441 {
    public List<String> buildArray(int[] target, int n) {
        String push = "Push";
        String pop = "Pop";
        List<String> result = new ArrayList<>();

        // k -> n, i -> target
        int k = 1, i = 0;
        while (k <= n) {
            // target已经遍历完了
            if (i == target.length) {
                break;
            }
            if (k != target[i]) {
                result.add(push);
                result.add(pop);
            } else {
                result.add(push);
                i++;
            }
            k++;
        }

        return result;
    }
}