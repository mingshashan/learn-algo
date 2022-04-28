#include <stdlib.h>

/**
 * 1 <= capacity <= 3000
 * 0 <= key <= 104
 * 0 <= value <= 105
 * At most 2 * 105 calls will be made to get and put.
 *
 */

#define MAX_CAPACITY 3192

typedef struct {
    int val;
    bool valid;
    struct LRUCache *prex;
    struct LRUCache *next;
} LRUCache;

struct cdata {
    int capacity;
    int size;
    struct LRUCache *cache;
    struct LRUCache *heah;
    struct LRUCache *tail;
};

inline void *alloc_cache(size_t capacity) {
    struct cdata *cdata = calloc(1, sizeof(*cdata));
    cdata->cache = calloc(1, sizeof(struct LRUCache[MAX_CAPACITY]));
    cdata->capacity = capacity;
    
    return cdata;
}

inline void *dealloc_cache(void *obj) {
    free(((struct cdata *)obj)->cache);
    free(obj);
}

inline void refresh_cache(struct LRUCache *item, struct cdata *cdata, bool front) {
    struct LRUCache **prev = &item->prev;


}

// 初始分配容量为capacity的LRU cache
LRUCache *lRUCacheCreate(int capacity) {

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