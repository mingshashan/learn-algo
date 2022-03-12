package com.mingshashan.learn.lt.l556;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution_556 {
    public int nextGreaterElement(int n) {
        List<Integer> digits = new ArrayList<>();
        while(n > 0) {                      // n = 123476531
            digits.add(n % 10);
            n /= 10;
        }
        int size = digits.size();
        reverse(digits, 0, size - 1);       // digits = [1,2,3,4,7,6,5,3,1]
        int peak = size - 1;                // peak = 4 (digit = 7)
        while(peak > 0) {
            if(digits.get(peak) <= digits.get(peak - 1)) {
                peak --;
            } else {
                break;
            }
        }
        if(peak == 0) {                     // no greater number exists
            return -1;
        }
        int lIdx = peak - 1;                // Index to swap, ie lIdx = 3 (digit = 4)
        int rIdx = size - 1;                // 2nd Index to swap, ie rIdx = 6, (digit = 5)
        while(rIdx >= peak) {
            if(digits.get(rIdx) <= digits.get(lIdx)) {
                rIdx --;
            } else {
                break;
            }
        }
        swap(digits, rIdx, lIdx);                   // digits = [1,2,3,5,7,6,4,3,1]
        reverse(digits, peak, size - 1);            // digits = [1,2,3,5,1,3,4,6,7]

        long sum = 0;
        for(int digit : digits) {
            sum = sum * 10 + digit;
        }
        if(sum > Integer.MAX_VALUE) {
            return - 1;
        }
        return (int)sum;
    }

    // Function to swap
    void swap(List<Integer> nums, int i, int j) {
        int temp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, temp);
    }

    // Function to reverse in a range
    void reverse(List<Integer> nums, int start, int end) {
        while(start < end) {
            swap(nums, start, end);
            start ++;
            end --;
        }
    }
}