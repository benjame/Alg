package com.leetcode;

public class Solution2 {
    public static void main(String[] args) {
        Solution2 sol = new Solution2();
        System.out.println(sol.climbStairs(45));
    }

    public int climbStairs(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}
