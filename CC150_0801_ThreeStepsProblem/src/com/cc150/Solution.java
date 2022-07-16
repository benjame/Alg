package com.cc150;

/**
 * 题目: 08_01 Three Steps Problem
 * 思路: 动态规划初步 （自顶向下的递归）
 * 思考登上最后一节阶梯时，3 种情况
 * 上 3 节、上 2 节、上 1 节
 *
 */

public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.waysToStep(3));
        System.out.println(sol.waysToStep(5));
        System.out.println(sol.waysToStep(7));
        System.out.println(sol.waysToStep(9));
        System.out.println(sol.waysToStep(11));
        System.out.println(sol.waysToStep(61));

    }

    public int waysToStep(int n) {
        long[] mem = new long[n + 1];
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        if (n == 3)
            return 4;

        return waysToStepMem(n, mem);

//        return waysToStep(n - 3) + waysToStep(n - 2) + waysToStep(n - 1);
    }

    private int waysToStepMem(int i, long[] mem) {
        mem[1] = 1;
        mem[2] = 2;
        mem[3] = 4;

        for (int j = 4; j <= i; j++) {
            /* 递推关系式 */
            mem[j] = (mem[j - 1] + mem[j - 2] + mem[j - 3]) % 1000000007;
        }
        return (int) mem[i];
    }

}

