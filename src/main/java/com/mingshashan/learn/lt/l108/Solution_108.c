#include <stdlib.h>

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */

struct TreeNode {
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
};

struct TreeNode *buildTree(int *nums, int left, int right) {
    if (left > right) {
        return NULL;
    }

    int mid = left + (right - left) / 2;
    struct TreeNode *root = malloc(sizeof(struct TreeNode));
    root->val = *(nums + mid);
    root->left = buildTree(nums, left, mid - 1);
    root->right = buildTree(nums, mid + 1, right);

    return root;
}

struct TreeNode *sortedArrayToBST(int *nums, int numsSize) {

    return buildTree(nums, 0, numsSize - 1);
}
