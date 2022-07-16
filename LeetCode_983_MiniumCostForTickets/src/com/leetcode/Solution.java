package com.leetcode;

import java.util.Arrays;

public class Solution {
    private static int[] minCosts = new int[365];

    public static void main(String[] args) {
        int[] days1 = {1, 4, 6, 7, 8, 20};
        int[] days2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31};
        int[] days3 = {1, 2, 3, 4, 10, 17, 18, 26, 35, 51, 77, 85, 99, 100, 111, 121};
        int costs[] = {2, 7, 15};


        Solution sol = new Solution();
        System.out.println(sol.mincostTickets(days1, costs));
        System.out.println(sol.mincostTickets(days2, costs));
        System.out.println(sol.mincostTickets(days3, costs));

    }


    public int mincostTickets(int[] days, int[] costs) {
        if (days.length == 0)
            return 0;
        if (days.length == 1)
            return costs[0];
        Arrays.fill(minCosts, Integer.MAX_VALUE);
        return minCostFromNow(days, costs, days[0]);
    }

    /**
     * @param days
     * @param costs
     * @param curDay 代表当前日期的游标
     * @return 返回从 curDay 开始（包含 curDay）(days[]去掉 curDay 之前的日期)最小覆盖开销
     */
    private int minCostFromNow(int[] days, int[] costs, int curDay) {
        if (curDay > days[days.length - 1]) {
            return 0;
        }
        if (minCosts[curDay - 1] != Integer.MAX_VALUE) {
            return minCosts[curDay - 1];
        }
        if (curDay == days[days.length - 1]) {
            minCosts[curDay - 1] = costs[0];
            return costs[0];
        }
        //递推关系式
        /* 需要判断 curDay 是不是 travel day*/
        /* curDay 不是 travel day, curDay 增加到 travel Day*/
        while (!contain(days, curDay) && curDay < days[days.length - 1]) {
            minCosts[curDay] = minCostFromNow(days, costs, curDay + 1);
            curDay++;
        }
        if (contain(days, curDay)) {
            minCosts[curDay - 1] = Math.min(Math.min(costs[0] + minCostFromNow(days, costs, curDay + 1),
                    costs[1] + minCostFromNow(days, costs, curDay + 7)),
                    costs[2] + minCostFromNow(days, costs, curDay + 30));
            return minCosts[curDay - 1];
        }
        return minCosts[curDay - 1];

    }

    private boolean contain(int[] days, int day) {
        for (int i : days) {
            if (i == day)
                return true;
        }
        return false;
    }


}
