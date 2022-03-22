#include <stdio.h>
#include <stdlib.h> 

struct TreeNode {
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
};

struct TreeNode* buildTree(int *nums, int left, int right) {
    if (left > right) {
        return NULL;
    }

    int i;
    int index;
    int maxValue = 0x80000000;

    for (i = left; i < right; i++) {
        if (*(nums + i) > maxValue) {
            maxValue = *(nums + i);
            index = i;
        }
    }

    struct TreeNode* root = malloc(sizeof(struct TreeNode));
    root->val = maxValue;
    root->left = buildTree(nums, left, index - 1);
    root->right = buildTree(nums, index + 1, right);
    
    return root;
}

struct TreeNode* constructMaximumBinaryTree(int* nums, int numsSize){
    return  buildTree(nums, 0, numsSize - 1);
}

int main() {
    int nums[] = {3,2,1};
    int numsSize = 3;
    struct TreeNode *root = constructMaximumBinaryTree(nums, numsSize);

    printf("root.val = %d\n", root->val);
}
