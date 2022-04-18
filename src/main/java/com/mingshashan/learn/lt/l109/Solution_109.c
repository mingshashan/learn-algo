#include <stdlib.h>

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */

 struct ListNode {
    int val;
    struct ListNode *next;
 };
 
struct TreeNode {
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
};

struct ListNode *findMid(struct ListNode *head, struct ListNode *tail) {
    struct ListNode *fast = head, *slow = head;
    while (fast != tail && fast->next != tail) {
        fast = fast->next->next;
        slow = slow->next;
    }
    
    return slow;
}

struct TreeNode* toBST(struct ListNode* head, struct ListNode* tail){
    if (head == NULL || head == tail) {
        return NULL;
    }

    struct ListNode *mid = findMid(head, tail);
    struct TreeNode *root = malloc(sizeof(struct TreeNode));
    root->left = toBST(head, mid);
    root->right = toBST(mid->next, tail);

    return root;
}

struct TreeNode* sortedListToBST(struct ListNode* head){
    return toBST(head, NULL);
}