#include <stdio.h>

int main() {
    /* 一个带有 5 行 2 列的数组 */
    int a[5][3] = {{0, 1, 2}, {1, 2, 3}, {2, 3, 4}, {3, 4, 5}, {4, 5, 6}};
    int i, j;
    for (i = 0; i < 5; i++) {
        for (j = 0; j < 3; j++) {
            printf("a[%d][%d] = %d\n", i, j, a[i][j]);
        }
        printf("---------------------------\n");
    }

    /* 一个带有 5 行 2 列的数组 */
    int *p = a;
    printf("Hello World!\n");

    return 0;
}