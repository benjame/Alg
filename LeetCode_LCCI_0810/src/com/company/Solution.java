package com.company;

public class Solution {


    private static int[][] image = {
            {1, 1, 1},
            {1, 1, 0},
            {1, 0, 0},
            {0, 2, 1},
            {1, 2, 3}
    };

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.floodFill(image, 0, 0, 1);

        for (int[] row : image) {
            for (int num : row) {
                System.out.print(num);
            }
            System.out.println();
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        //store the initial color
        int initColor = image[sr][sc];

        paint(image, sr, sc, initColor, newColor);
        return image;

    }

    private void paint(int[][] image, int r, int c, int initColor, int newColor) {
        if (r < 0 || c < 0 || r >= image.length || c >= image[0].length) {
            return;
        }

        if (image[r][c] == initColor && image[r][c] != newColor) {

            image[r][c] = newColor;

            //left
            paint(image, r, c - 1, initColor, newColor);
            //right
            paint(image, r, c + 1, initColor, newColor);
            //Up
            paint(image, r + 1, c, initColor, newColor);
            //Down
            paint(image, r - 1, c, initColor, newColor);
        }
    }
}