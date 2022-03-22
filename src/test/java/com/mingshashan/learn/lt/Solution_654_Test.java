package com.mingshashan.learn.lt;

import com.mingshashan.learn.lt.l654.Solution_654;
import com.mingshashan.learn.lt.l654.TreeNode;
import org.junit.Test;

public class Solution_654_Test {

    @Test
    public void test_01() {
        int[] nums = {3, 2, 1, 6, 0, 5};
        Solution_654 solution = new Solution_654();
        TreeNode node = solution.constructMaximumBinaryTree(nums);
        System.out.println(node);
    }
}
