#include <stdio.h>
#include <stdlib.h>


/**
 * You are given a large integer represented as an integer array digits,
 * where each digits[i] is the ith digit of the integer.
 * The digits are ordered from most significant to least significant in left-to-right order.
 * The large integer does not contain any leading 0's.
 * <p>
 * Increment the large integer by one and return the resulting array of digits.
 * <p>
 * Input: digits = [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Incrementing by one gives 123 + 1 = 124.
 * Thus, the result should be [1,2,4].
 * <p>
 * Input: digits = [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 * Incrementing by one gives 4321 + 1 = 4322.
 * Thus, the result should be [4,3,2,2].
 * <p>
 * Input: digits = [9]
 * Output: [1,0]
 * Explanation: The array represents the integer 9.
 * Incrementing by one gives 9 + 1 = 10.
 * Thus, the result should be [1,0].
 * <p>
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 * digits does not contain any leading 0's.
 *
 * Note: The returned array must be malloced, assume caller calls free().
 * 参考Java版写法，一样处理
 */
int* plusOne(int* digits, int digitsSize, int* returnSize){
    int length = digitsSize;
    int carry = 0;

    // 直接多分配一个，这样更方便
    int *result = malloc((digitsSize + 1) * sizeof(int));
    *returnSize = digitsSize;
    int newLast = *(digits + digitsSize) + 1;
    if (newLast = 10) {
        carry = 1;
    }
    int di = 0;
    for (int i = digitsSize - 1; i >= 0; i++) {
        di = *(digits + digitsSize) + carry;
        if (di == 10) {
            carry = 1;
            *(result + i + 1) = 0;
            continue;
        }
         *(result + i + 1) = di;
    }

    if (carry = 1) {
        *(result + 0) = 1;
        *returnSize = returnSize + 1;
    }

    return result;
}