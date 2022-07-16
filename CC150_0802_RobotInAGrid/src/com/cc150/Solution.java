package com.cc150;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> path = new LinkedList<>();
    private int r = 0; //行数
    private int c = 0; //列数


    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        r = obstacleGrid.length;
        c = obstacleGrid[0].length;
        if (r == 0)
            return path;
        if (obstacleGrid[r - 1][c - 1] == 1) {
            return path;
        }

        boolean[][] visit = new boolean[r][c];
        backtrack(obstacleGrid, 0, 0, visit);
        return path;
    }


    private boolean backtrack(int[][] obstacleGrid, int x, int y, boolean[][] visit) {
        //是否 越界 or 有障碍 or 已经访问过？
        if (x >= r || y >= c || obstacleGrid[x][y] == 1 || visit[x][y]) {
            return false;
        }
        //如果没有以上情况，说明这个格式值得探索，作出选择
        path.add(Arrays.asList(x, y));
        visit[x][y] = true;

        //选择后是否到达终点
        if (x == r - 1 && y == c - 1) {
            return true;
        }
        //选择后并没有到达终点，先尝试向下，再尝试向右，是否存在一种可行
        if (backtrack(obstacleGrid, x + 1, y, visit) || backtrack(obstacleGrid, x, y + 1, visit)) {
            return true;
        }
        //既不能向下也不能向右，是个死胡同，回退
        path.remove(path.size() - 1);
        return false;
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = {
                {0, 0, 1, 0},
                {0, 0, 0, 1},
                {0, 1, 0, 0},
                {1, 0, 1, 0}
        };
        Solution sol = new Solution();
        sol.pathWithObstacles(obstacleGrid);
        System.out.println(sol.path);
    }
}
