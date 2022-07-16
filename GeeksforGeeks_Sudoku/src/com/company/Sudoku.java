package com.company;

/* A Backtracking program in
Java to solve Sudoku problem */
public class Sudoku {

    //Driver Code
    public static void main(String args[]) {
        int[][] board = new int[][]{
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };
        int N = board.length;

        if (solveSudoku(board, N)) {
            // print solution
            print(board, N);
        } else {
            System.out.println("No solution");
        }

    }

    public static boolean isSafe(int[][] board, int row,
                                 int col, int num) {
        // row has the unique (row-clash)
        /* There are same amount of row and column,
           so it is OK to use border.length() here. */
        for (int d = 0; d < board.length; d++) {
            // if the number we are trying to
            // place is already present in
            // that row, return false;
            if (board[row][d] == num) {
                return false;
            }
        }

        // column has the unique numbers (column-clash)
        for (int r = 0; r < board.length; r++) {
            // if the number we are trying to
            // place is already present in
            // that column, return false;

            if (board[r][col] == num) {
                return false;
            }
        }

        // corresponding square has
        // unique number (box-clash)
        int sqrtRes = (int) Math.sqrt(board.length);
        int boxRowStart = row - row % sqrtRes;
        int boxColStart = col - col % sqrtRes;

        for (int r = boxRowStart; r < boxRowStart + sqrtRes; r++) {
            for (int d = boxColStart; d < boxColStart + sqrtRes; d++) {
                if (board[r][d] == num) {
                    return false;
                }
            }
        }
        /* Reach here, we are determined that there is no clash exist. */
        // if there is no clash, it's safe
        return true;
    }

    public static boolean solveSudoku(int[][] board, int n) {
        int row = -1;
        int col = -1;
        boolean isEmpty = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    /* we still have some remaining
                     missing values in Sudoku. */
                    row = i;
                    col = j;
                    isEmpty = false;
                    break;
                }
            }
            if (!isEmpty) {
                break;
            }
        }

        // no empty space left
        if (isEmpty) {
            return true;
        }

        // else for each-row backtrack
        for (int num = 1; num <= n; num++) {
            if (isSafe(board, row, col, num)) {
                board[row][col] = num;
                if (solveSudoku(board, n)) {
                    // print(board, n);
                    /* Here "return true" indicates
                    that we have finished solving
                    sudoku problem. */
                    return true;
                } else {
                    // replace it
                    board[row][col] = 0;
                }
            }
        }
        return false;
    }

    public static void print(int[][] board, int N) {
        // we got the answer, just print it
        for (int r = 0; r < N; r++) {
            for (int d = 0; d < N; d++) {
                System.out.print(board[r][d]);
                System.out.print(" ");
            }
            System.out.print("\n");

            //These following codes doesn't matter to our result.
            /*if ((r + 1) % (int) Math.sqrt(N) == 0) {
                System.out.print("");
            }*/
        }
    }
}

// This code is contributed
// by MohanDas