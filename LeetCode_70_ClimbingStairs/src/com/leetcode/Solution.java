package com.leetcode;

public class Solution {
    private static int[] mem = new int[50];

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.climbStairs(45));
    }

    public int climbStairs(int n) {
        if (n <= 0)
            return 0;
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        if (n == 3)
            return 3;
        if (mem[n] != 0)
            return mem[n];

        int num = climbStairs(n - 1) + climbStairs(n - 2);
        mem[n] = num;
        return num;
    }
}
