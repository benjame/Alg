package com.company;


import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'},
        };

        Solution sol = new Solution();
//        System.out.println(board.length);
//        System.out.println(board[0].length);

        sol.solve(board);

//        boolean[][] mark = new boolean[board.length][board[0].length];

        for (char[] chars : board) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }

    public void solve(char[][] board) {
        if (board == null)
            return;
        if (board.length > 0 && board[0].length > 0) {
            boolean[][] mark = new boolean[board.length][board[0].length];

            //border check
            char o = 'O';
            for (int i = 0; i < board.length; i++) {
                if (board[i][0] == o)
                    markBorder(i, 0, board.length, board[0].length, board, mark);
                if (board[i][board[0].length - 1] == o)
                    markBorder(i, board[0].length - 1, board.length, board[0].length, board, mark);
            }
            for (int j = 0; j < board[0].length; j++) {
                if (board[0][j] == o)
                    markBorder(0, j, board.length, board[0].length, board, mark);
                if (board[board.length - 1][j] == o)
                    markBorder(board.length - 1, j, board.length, board[0].length, board, mark);
            }

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (!mark[i][j] && board[i][j] == o)
                        board[i][j] = 'X';
                }
            }
        }

        //only one dimension
        return;
    }


    private void markBorder(int ix, int iy, int XLength, int YLength, char[][] board, boolean[][] mark) {
        if (ix >= 0 && ix <= XLength - 1 && iy >= 0 && iy <= YLength - 1) {
            if (board[ix][iy] == 'O' && !mark[ix][iy]) {
                mark[ix][iy] = true;
                markBorder(ix + 1, iy, XLength, YLength, board, mark);
                markBorder(ix - 1, iy, XLength, YLength, board, mark);
                markBorder(ix, iy + 1, XLength, YLength, board, mark);
                markBorder(ix, iy - 1, XLength, YLength, board, mark);

            }
        }
    }
}