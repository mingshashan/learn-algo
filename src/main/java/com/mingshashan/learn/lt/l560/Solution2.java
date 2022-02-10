package com.mingshashan.learn.lt.l560;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer k,
 * return the total number of continuous subarrays whose sum equals to k.
 */
class Solution2 {

    public int subarraySum(int[] nums, int k) {
        int res = 0;
        // <key: 前缀和, value: 出现的次数>
        Map<Integer, Integer> preSum = new HashMap<>();
        // 第一个0，肯定满足
        preSum.put(0, 1);
        int sum0_i = 0;
        for (int i = 0; i < nums.length; i++) {
            // 每个遍历里面的前缀和
            sum0_i += nums[i];

            // 前缀和 - k,就相当于算一下，前面有几个前缀和 = sum0_j
            // 这样sum0_i - sum0_j = k，即nums[i...j]满足条件
            int sum0_j = sum0_i - k;
            if (preSum.containsKey(sum0_j)) {
                // 可能前面有多个相同的前缀和，所以需要加上map里的value
                res += preSum.get(sum0_j);
            }

            // 如果map里面已经有一个相等的前缀和，则在value中记录该前缀和出现的次数
            preSum.put(sum0_i, preSum.getOrDefault(sum0_i, 0) + 1);
        }


        return res;
    }
}