package com.cc150;

import java.util.ArrayList;

public class Solution1 {
    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 2, 0},
                {3, 4, 5, 4},
                {1, 3, 1, 5},
                {2, 3, 0, 1}
        };

        Solution1 sol = new Solution1();
        sol.setZeroes(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length ; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }

    public void setZeroes(int[][] matrix) {
        int M = matrix.length;
        int N = matrix[0].length;

        ArrayList<IndexofPos> positions = new ArrayList<>();

        //record index of zeros
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == 0) {
                    positions.add(new IndexofPos(i, j));
                }
            }
        }
        for (IndexofPos iter : positions) {
            int row = iter.row;
            int col = iter.col;
            for (int i = 0; i < M; i++) {
                matrix[i][col] = 0;
            }

            for (int i = 0; i < N; i++) {
                matrix[row][i] = 0;
            }
        }

    }

    private class IndexofPos {
        int row;
        int col;

        public IndexofPos(int x, int y) {
            row = x;
            col = y;
        }

        public int getRow() { return row; }

        public int getCol() { return col; }
    }

}
