#include <stdio.h>

int main()
{
    int arr[5] = {1, 2, 3, 4, 5};
    int arrLength = 5;

    int *p = arr;
    int **pp = *p;

    printf("arr = ");
    for (int i = 0; i < arrLength; i++) {
        printf("\t %d", arr[i]);
    }
    printf("\n");

    printf("*p = ");
    for (int i = 0; i < arrLength; i++) {
        printf("\t%d", *(p + i));
    }
    printf("\n");

    printf("**pp = ");
    for (int i = 0; i < arrLength; i++) {
        printf("\t%d", *(*pp + i));
    }
    printf("\n");
    return 0;
}