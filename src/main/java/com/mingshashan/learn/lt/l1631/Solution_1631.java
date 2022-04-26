package com.mingshashan.learn.lt.l1631;

import java.util.*;

/**
 * You are a hiker preparing for an upcoming hike. You are given heights,
 * a 2D array of size rows x columns, where heights[row][col] represents the height of cell (row, col).
 * You are situated in the top-left cell, (0, 0), and you hope to travel to the bottom-right cell,
 * (rows-1, columns-1) (i.e., 0-indexed). You can move up, down, left, or right,
 * and you wish to find a route that requires the minimum effort.
 * <p>
 * A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.
 * <p>
 * Return the minimum effort required to travel from the top-left cell to the bottom-right cell.
 * <p>
 * dijkstra
 */
public class Solution_1631 {

    // 方向数组，上下左右的坐标偏移量
    int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int minimumEffortPath(int[][] heights) {
        return dijkstra(heights);
    }

    // 二维矩阵抽象成图，我们先实现一下图的 adj 方法，之后的主要逻辑会清晰一些：
    // 返回坐标 (x, y) 的上下左右相邻坐标
    List<int[]> adj(int[][] matrix, int x, int y) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<int[]> neighbors = new LinkedList<>();
        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx >= m || nx < 0 || ny >= n || ny < 0) {
                continue;
            }
            neighbors.add(new int[]{nx, ny});
        }
        return neighbors;
    }

    // Dijkstra 算法，计算 (0, 0) 到 (m - 1, n - 1) 的最小体力消耗
    // 输入起点 start 和终点 end，计算起点到终点的最短距离
    int dijkstra(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        // 定义从[0][0]到[i][j]的最小体力消耗是effortTo[i][j]
        int[][] effortTo = new int[m][n];
        // dp table初始化为Integer.MAX_VALUE
        for (int i = 0; i < m; i++) {
            Arrays.fill(effortTo[i], Integer.MAX_VALUE);
        }
        // base case，起点到起点的最小消耗是0
        effortTo[0][0] = 0;

        // 优先级队列，effortFromStart 较小的排在前面
        PriorityQueue<State> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.effortFromStart));

        pq.offer(new State(0, 0, 0));

        while (!pq.isEmpty()) {
            State state = pq.poll();
            int curX = state.x;
            int curY = state.y;
            int curEffortFromStart = state.effortFromStart;
            // 到达终点提前结束
            if (curX == m - 1 && curY == n - 1) {
                return curEffortFromStart;
            }
            if (curEffortFromStart > effortTo[curX][curY]) {
                continue;
            }
            // 将 (curX, curY) 的相邻坐标装入队列
            for (int[] neighbor : adj(heights, curX, curY)) {
                int nextX = neighbor[0];
                int nextY = neighbor[1];
                // 计算从 (curX, curY) 达到 (nextX, nextY) 的消耗
                int effortToNextNode = Math.max(effortTo[curX][curY], Math.abs(heights[curX][curY] - heights[nextX][nextY]));

                if (effortTo[nextX][nextY] > effortToNextNode) {
                    effortTo[nextX][nextY] = effortToNextNode;
                    pq.offer(new State(nextX, nextY, effortToNextNode));
                }
            }
        }

        return -1;
    }

    class State {
        int x, y;
        int effortFromStart;

        public State(int x, int y, int effortFromStart) {
            this.x = x;
            this.y = y;
            this.effortFromStart = effortFromStart;
        }
    }
}
