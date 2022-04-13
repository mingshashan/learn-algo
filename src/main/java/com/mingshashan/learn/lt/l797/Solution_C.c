
#define MAX_SIZE 6208


void traverse(int** result, 
                int** graph, int graphSize, int* graphColSize, 
                int *path, 
                int i,
                int* returnSize, int** returnColumnSizes){
    


}

/**
 * Return an array of arrays of size *returnSize.
 * The sizes of the arrays are returned as *returnColumnSizes array.
 * Note: Both returned array and *columnSizes array must be malloced, assume caller calls free().
 * 
 * 
 * 
 *  n == graph.length
 *  2 <= n <= 15
 *  0 <= graph[i][j] < n
 *  graph[i][j] != i (i.e., there will be no self-loops).
 *  All the elements of graph[i] are unique.
 *  The input graph is guaranteed to be a DAG.
 */
int** allPathsSourceTarget(int** graph, int graphSize, int* graphColSize, int* returnSize, int** returnColumnSizes){
    int* path;
    int ** result;

    traverse(result, graph, graphSize, graphColSize, path, returnSize, returnColumnSizes);

    return result;
}