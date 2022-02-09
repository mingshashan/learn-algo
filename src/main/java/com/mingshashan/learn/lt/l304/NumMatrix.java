package com.mingshashan.learn.lt.l304;

class NumMatrix {

    int[][] preSum;

    public NumMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        // +1主要是为了方便处理边界情况
        preSum = new int[row + 1][col + 1];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                preSum[i + 1][j + 1] = preSum[i][j + 1] + preSum[i + 1][j] + matrix[i][j]
                        - preSum[i][j];
            }
        }

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {

        int res = preSum[row2 + 1][col2 + 1] -
                preSum[row2 + 1][col1] -
                preSum[row1][col2 + 1] +
                preSum[row1][col1];

        return res;
    }
}