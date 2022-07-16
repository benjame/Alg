package com.cc150;

/**
 * 题目: 
 * 思路: 巨慢 指数级时间复杂度
 *
 *
 */

public class Solution2 {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5, 10, 20, 50, 100};

        int amount = 555;
        Solution2 sol2 = new Solution2();
        System.out.println(sol2.coinChange(coins, amount));
    }


    public int coinChange(int[] coins, int amount) {
        return coinChange(0, coins, amount);
    }

    private int coinChange(int idxCoin, int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (idxCoin < coins.length && amount > 0) {
            int maxVal = amount / coins[idxCoin];
            int minCost = Integer.MAX_VALUE;
            for (int x = 0; x <= maxVal; x++) {
                if (amount >= x * coins[idxCoin]) {
                    int res = coinChange(idxCoin + 1, coins, amount - x * coins[idxCoin]);
                    if (res != -1) {
                        minCost = Math.min(minCost, res + x);
                    }
                }
            }
            return (minCost == Integer.MAX_VALUE)? -1: minCost;
        }
        return -1;
    }
}

// Time Limit Exceeded


