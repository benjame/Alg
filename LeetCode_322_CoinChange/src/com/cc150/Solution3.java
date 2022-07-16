package com.cc150;

import java.util.Arrays;

/**
 * 题目:
 * 思路: 基于动态规划 背包问题求解 不是本题的最优解
 * 基于贪心策略和回溯 可以有更快的速度, 这题剪枝效率非常好
 * Counter case: [1, 7, 10] ,amount = 14
 * 按照贪心策略: 会首先找到 10 + 1 + 1 + 1 + 1 而不是 7 + 7
 */

public class Solution3 {
    private static int ans = Integer.MAX_VALUE;

    public int coinChange(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        Arrays.sort(coins);

        coinChange(coins, amount, coins.length - 1, 0);
        if (ans == Integer.MAX_VALUE) return -1;
        else {
            int oldAns = ans;
            ans = Integer.MAX_VALUE;
            return oldAns;
        }

//        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private void coinChange(int[] coins, int amount, int cIndex, int count) {
        if (amount == 0) {
            ans = Math.min(ans, count);
            return;
        }
        if (cIndex == -1)
            return;
        /* 说实话 为什么效率高? 全在 k + count < ans 这句
         * 当前已经找零数量 count 加上 目前准备用的数量 k 如果要大于目前知道的最优解ans
         * 叉叉叉 不用找了，剪枝！对应到代码就是退出循环
         * */
        for (int k = amount / coins[cIndex]; k >= 0 && k + count < ans; --k) {
            coinChange(coins, amount - k * coins[cIndex], cIndex - 1, count + k);
        }
    }

    public static void main(String[] args) {
        int[] coins = {2};
        int amount = 3;

        Solution3 sol3 = new Solution3();
        System.out.println(sol3.coinChange(coins, amount));
    }
}
