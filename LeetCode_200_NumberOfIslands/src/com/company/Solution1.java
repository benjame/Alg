package com.company;

/**
 * 题目: LeetCode 200 Number of Islands
 * 思路: 深度优先搜索
 * 这种 地图搜索，返回某种"岛屿""池塘"数量类的问题 都是DFS
 * 每一次DFS将所有的联通的"岛屿内的点"了一遍 所以记录DFS的次数就是需要的结果
 * 避免重复遍历，将遍历过的"岛屿"做标记
 *
 */

public class Solution1 {
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        Solution1 sol1 = new Solution1();
        System.out.println(sol1.numIslands(grid));
    }

    public int numIslands(char[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    travseral(i, j, grid);
                    res++;
                }

            }
        }
        return res;
    }

    private void travseral(int xi, int yi, char[][] grid) {

        if (0 <= xi && xi < grid.length && 0 <= yi && yi < grid[0].length && grid[xi][yi] == '1') {
            grid[xi][yi] = '0';
            //up, down, left, right
            travseral(xi - 1, yi, grid);
            travseral(xi + 1, yi, grid);
            travseral(xi, yi - 1, grid);
            travseral(xi, yi + 1, grid);
        }
    }
}