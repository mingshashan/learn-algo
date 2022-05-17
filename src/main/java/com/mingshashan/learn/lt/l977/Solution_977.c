#include <stdio.h>
#include <stdlib.h>


/**
 * Note: The returned array must be malloced, assume caller calls free().
 * 1 <= nums.length <= 10^4
 * -10^4 <= nums[i] <= 10^4(10000)
 * 
 */
// int findFirstIndexNonnegative(int* nums, int numsSize) {
//     int left = 0, right = numsSize - 1;
//     int mid = numsSize / 2;
//     while (mid >= 0 && mid < numsSize) {
        
//     }
    
// }

// int findFirstIndexNonnegative(int* nums, int numsSize) {

// }
// int* sortedSquares(int* nums, int numsSize, int* returnSize){
    
//     int *result = (int*)malloc(sizeof(int) * numsSize);
//     *returnSize = numsSize;

//     // find the first negative, and first nonnegative, then merge two sorted array
//     // -7, -3, -1, 0, 1, 2, 3, 11
//     //  p1 ->(-1,-3,-7), p2(0, 1, 2, 3, 11)
//     int firstNonnegativeIndex = numsSize - 1;
//     for (int i = 0; i < numsSize; i++) {
//         if (*(nums + i) >= 0) {
//             firstNonnegativeIndex = i;
//             break;
//         }
//     }

//     int i1 = firstNonnegativeIndex - 1;
//     int i2 = firstNonnegativeIndex;
//     int i = 0;
//     int v1, v2;
//     while (i1 >= 0 && i2 < numsSize) {
//         // negative > nonnegative
//         v1 = *(nums + i1);
//         v2 = *(nums + i2);
//         if (-(v1) >= v2) {
//             *(result + i) = v2 * v2;
//             i2++;
//         } else {
//             *(result + i) = v1 * v1;
//             i1--;
//         }
//         i++;
//     }

//     while (i1 >=0) {
//         v1 = *(nums + i1);
//         *(result + i++) = v1 * v1;
//         i1--;
//     }
    
//     while (i2 < numsSize) {
//         v2 = *(nums + i2);
//         *(result + i++) = v2 * v2;
//         i2++;
//     }

//     return result;
// }


int* sortedSquares(int* nums, int numsSize, int* returnSize){
    
    int *result = (int*)malloc(sizeof(int) * numsSize);
    *returnSize = numsSize;

    int i1 = 0;
    int i2 = numsSize - 1;
    int i = numsSize - 1;
    int v1, v2;
    while (i1 <= i2) {
        v1 = (*(nums + i1)) * (*(nums + i1));
        v2 = (*(nums + i2)) * (*(nums + i2));
        if (v1 >= v2) {
            *(result + i--) = v1;
            i1++;
        } else {
            *(result + i--) = v2;
            i2--;
        }
    }

    return result;
}

// int main() {
//     int nums[] = {-4,-1,0,3,10};
//     int returnSize = 0;
//     int *p = sortedSquares(nums, 5, &returnSize);
//     printf("returnSize = %d\n", returnSize);
//     for (int i = 0; i < 5; i++) {
//         printf("%d\n", *(p + i));
//     }
//     return 0;
// }

int main() {
    int nums[] = {-7,-3,2,3,11};
    int returnSize = 0;
    int *p = sortedSquares(nums, 5, &returnSize);
    printf("returnSize = %d\n", returnSize);
    for (int i = 0; i < 5; i++) {
        printf("%d\n", *(p + i));
    }
    return 0;
}