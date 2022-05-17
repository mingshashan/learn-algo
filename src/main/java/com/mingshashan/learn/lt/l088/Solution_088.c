#include <stdlib.h>

/**
 * solution 1
 * sort from right to left
 */
void merge(int* nums1, int nums1Size, int m, int* nums2, int nums2Size, int n){
    int i1, i2, i;
    i1 = m - 1;
    i2 = n - 1;
    i = m + n - 1;
    while (i1 >= 0 && i2 >= 0) {
        if (*(nums1 + i1) <= *(nums2 + i2)) {
            *(nums1 + i--) = *(nums2 + i2--);
        } else {
            *(nums1 + i--) = *(nums1 + i1--);
        }
    }

    while (i2 >= 0) {
        *(nums1 + i--) = *(nums2 + i2--);
    }
    
}


void merge(int* nums1, int nums1Size, int m, int* nums2, int nums2Size, int n){
    int i1, i2, i;
    i1 = 0;
    i2 = 0;
    i = 0;
    int temp[m + n];
    while (i1 < m && i2 < n) {
        if (*(nums1 + i1) > *(nums2 + i2)) {
            temp[i++] = *(nums2 + i2++);
        } else {
            temp[i++] = *(nums1 + i1++);
        }
    }

    while (i2 < n) {
        temp[i++] = *(nums2 + i2++);
    }

    while (i1 < m) {
        temp[i++] = *(nums1 + i1++);
    }
    for (int j = 0; j < m + n; j++) {
        *(nums1 + j) = temp[j];
    }
    
}
