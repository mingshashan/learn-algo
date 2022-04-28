

/**
 * 1 <= capacity <= 3000
 * 0 <= key <= 104
 * 0 <= value <= 105
 * At most 2 * 105 calls will be made to get and put.
 *
 */

typedef struct {
    int key;
    int val;
    Node *prev;
    Node *next;
} Node;

typedef struct {
    Node *head;
    Node *tail;
    int size;
} double_link;

typedef struct {

} LRUCache;

struct double_link link;

void init_link(int capacity) {
    
}

// 初始分配容量为capacity的LRU cache
LRUCache *lRUCacheCreate(int capacity)
{
}

int lRUCacheGet(LRUCache *obj, int key)
{
}

void lRUCachePut(LRUCache *obj, int key, int value)
{
}

void lRUCacheFree(LRUCache *obj)
{
}

/**
 * Your LRUCache struct will be instantiated and called as such:
 * LRUCache* obj = lRUCacheCreate(capacity);
 * int param_1 = lRUCacheGet(obj, key);

 * lRUCachePut(obj, key, value);

 * lRUCacheFree(obj);
*/