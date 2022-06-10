package com.mingshashan.learn.lt.l463;

/**
 * 463. Island Perimeter
 * <p>
 * You are given row x col grid representing a map where grid[i][j] = 1 represents
 * land and grid[i][j] = 0 represents water.
 * <p>
 * Grid cells are connected horizontally/vertically (not diagonally).
 * The grid is completely surrounded by water, and there is exactly one island
 * (i.e., one or more connected land cells).
 * <p>
 * The island doesn't have "lakes", meaning the water inside isn't connected to
 * the water around the island. One cell is a square with side length 1.
 * The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.
 */
public class Solution_463 {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    perimeter += 4;

                    if (i > 0 && grid[i - 1][j] == 1)
                        perimeter -= 2;

                    if (j > 0 && grid[i][j - 1] == 1)
                        perimeter -= 2;
                }
            }
        }

        return perimeter;
    }
}