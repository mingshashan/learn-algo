#include <stdlib.h>

/**
 * 1 <= capacity <= 3000
 * 0 <= key <= 104
 * 0 <= value <= 105
 * At most 2 * 105 calls will be made to get and put.
 *
 */

#define MAX_CAPACITY 3192

typedef struct LRUCache {
    int val;
    bool valid;
    struct LRUCache *prev;
    struct LRUCache *next;
} LRUCache;

struct cdata {
    int capacity;
    int size;
    struct LRUCache *cache;
    struct LRUCache *head;
    struct LRUCache *tail;
};

inline void *alloc_cache(size_t capacity) {
    struct cdata *cdata = calloc(1, sizeof *cdata);
    cdata->cache = calloc(1, sizeof(struct LRUCache [MAX_CAPACITY]));
    cdata->capacity = capacity;
    return cdata;
}

inline void dealloc_cache(void *obj){
    free(((struct cdata *)obj)->cache);
    free(obj);
}

inline void refresh_cache(struct LRUCache *item, struct cdata *cdata, bool front) {
    struct LRUCache **prev = &item->prev;
    struct LRUCache **next = &item->next;
    struct LRUCache **head = &cdata->head;
    struct LRUCache **tail = &cdata->tail;

    if (item->valid) { // Remove node 
        *prev ? (*prev)->next = *next : 0;
        *next ? (*next)->prev = *prev : 0;
    }
    item == *tail ? *tail = *prev : 0;// Fix tail
    item->valid = front;    
    if (front) { // Move front
        *prev = NULL;                       
        *next = cdata->head;
        *head ? (*head)->prev = item : 0;
        *head = item; // Fix head
        !*tail ? *tail = *head : 0; // First entry
    }

}

// 初始分配容量为capacity的LRU cache
LRUCache *lRUCacheCreate(int capacity) {
    return alloc_cache(capacity);
}
int lRUCacheGet(LRUCache* obj, int key){
    struct cdata *cdata = (void *)obj;
    struct LRUCache *item = &cdata->cache[key];    
    if (!cdata->size || !item->valid)
        return -1;
    if (item == cdata->head)
        return item->val; // Already at front 
    refresh_cache(item, cdata, true); // Move front
    return item->val;
}

void lRUCachePut(LRUCache* obj, int key, int value){
    struct cdata *cdata = (void *)obj;
    struct LRUCache *item = &cdata->cache[key];
    if (item == cdata->head)
        return item->val = value, (void)0; // Already at front
    if (!item->valid)
        if (cdata->size == cdata->capacity)
            refresh_cache(cdata->tail, cdata, false); // Evict
        else
            cdata->size++;
    refresh_cache(item, cdata, true); // Move/add front
    item->val = value;            
}

void lRUCacheFree(LRUCache *obj) {
    dealloc_cache(obj);
}

/**
 * Your LRUCache struct will be instantiated and called as such:
 * LRUCache* obj = lRUCacheCreate(capacity);
 * int param_1 = lRUCacheGet(obj, key);

 * lRUCachePut(obj, key, value);

 * lRUCacheFree(obj);
*/


