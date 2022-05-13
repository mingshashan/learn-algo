#include <stdio.h>
#include <stdlib.h>

/**
 * Definition for a Node.
 * struct Node {
 *     int val;
 *     struct Node *left;
 *     struct Node *right;
 *     struct Node *next;
 * };
 */

struct Node {
    int val;
    struct Node *left;
    struct Node *right;
    struct Node *next;
};

struct Queue {
    struct Queue *head;
    struct Queue *tail;
    struct Queue *next;
    struct Node *data;
    int size;
};

int offer(struct Queue *queue, struct Node *node) {

    if (queue == NULL) {
        return 0;
    }

    queue->tail->next = (struct Queue*)malloc(sizeof(struct Queue));
    queue->tail->next->data = node;
    queue->tail->data = node;
    queue->size++;
    return 1;
}
  
struct Node* poll(struct Queue *queue) {

    struct Node* element = queue->head;
    struct Node* next = queue->head->next;

    queue->head = next;
    queue->size--;
    return element;
}

int isEmpty(struct Queue *queue) {
    return queue->size == 0 ? 0 : 1;
}

// The number of nodes in the tree is in the range [0, 6000].
// -100 <= Node.val <= 100
struct Node* connect(struct Node* root) {
    if (root == NULL) {
        return root;
    }
    int MAX_SIZE = 6000;
    int size;
    struct Queue *queue = (struct Queue *)malloc(MAX_SIZE * sizeof(struct Queue));
    queue->size = 0;
    offer(queue, root);
    while (!isEmpty(queue)) {
        size = queue->size;
        for (int i = 0; i < size; i++) {
            struct Node *temp = poll(queue);
            if (temp->left != NULL) {
                offer(queue, temp->left);
            }
            if (temp->right != NULL) {
                offer(queue, temp->right);
            }
            if (i < size - 1) {
                temp->next = queue->next;
            }
        }
        
    }
    
    return root;
}


int main() {
    struct Node *root = (struct Node *)malloc(sizeof(struct Node));
    root->val = 1;
    root->left = (struct Node *)malloc(sizeof(struct Node));
    root->left->val = 2;
    root->left->left = (struct Node *)malloc(sizeof(struct Node));
    root->left->left->val = 4;
    root->left->right = (struct Node *)malloc(sizeof(struct Node));
    root->left->right->val = 4;


    root->right = (struct Node *)malloc(sizeof(struct Node));
    root->right->val = 3;
    root->right->right = (struct Node *)malloc(sizeof(struct Node));
    root->right->right->val = 7;

    struct Node *haha = connect(&root);

}