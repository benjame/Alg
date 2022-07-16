package com.cc150;

import java.util.Arrays;

/**
 * 题目: LeetCode 322 Coin Change
 * 思路: 动态规划 （自顶向下）
 * 其实很容易注意到这题 存在一个最优子结构
 *
 *
 */

public class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        return coinChange(coins, amount, new int[amount]);
    }

    /**
     *
     * @param coins
     * @param rem
     * @param count
     * @return 返回给定 coins[], rem 下的最少找钱数
     */
    private int coinChange(int[] coins, int rem, int[] count) {
        if (rem < 0) {
            return -1;
        }
        if (rem == 0) {
            return 0;
        }
        if (count[rem - 1] != 0) {
            return count[rem - 1];
        }

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange(coins, rem - coin, count);
            if (res >= 0 && res < min) {
                min = 1 + res;
            }
        }

        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem - 1];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5, 10, 20, 50, 100};
        int amount = 1024;

        Solution sol = new Solution();

        System.out.println(sol.coinChange(coins, amount));
    }
}