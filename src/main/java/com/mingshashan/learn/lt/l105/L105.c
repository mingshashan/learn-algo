#include <stdio.h>

struct TreeNode {
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
};

struct TreeNode* build(int* preorder, int preStart, int preEnd, int* inorder, int inStart, int inEnd){
    if (preStart > preEnd || inStart > inEnd) {
        return NULL;
    }
    int index = 0;
    int rootVal = *(preorder + preStart);
    int i;
    for (i = inStart; i <= inEnd; i++) {
        if (rootVal == *(inorder + inStart)) {
            index = i;
            break;
        }
    }
    struct TreeNode *root = {rootVal, 0, 0};
    int leftSize = index - inStart;
    if ((preStart + leftSize) >= (preStart + 1) && (inStart <= index - 1)) {
        root->left = build(preorder, preStart + 1, preStart + leftSize, inorder, inStart, index - 1);
    } else{
        root->left = NULL;
    }

    if ((preStart + leftSize + 1) <= preEnd) && (index + 1 <= inEnd)) {
        root->right = build(preorder, preStart + leftSize + 1, preEnd, inorder, index + 1, inEnd);
    } else {
        root->right = NULL;
    }

    return root;
}

struct TreeNode* buildTree(int* preorder, int preorderSize, int* inorder, int inorderSize){
    return build(preorder, 0, preorderSize - 1, inorder, 0, inorderSize - 1);
}