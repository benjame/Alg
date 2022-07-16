package com.company;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        // write your code here
        int[][] edges = {
                {1, 2},
                {2, 3},
                {3, 4},
                {4, 1},
                {1, 5}
        };
        Solution sol = new Solution();

        int[] nums = {100, 4, 200, 1, 3, 2, 5, 8, 6, 7};
        System.out.print(sol.longestConsecutive(nums));

    }


    public int longestConsecutive(int[] nums) {
        int longestStreak = 0;
        Set<Integer> numsArr = new HashSet<Integer>();

        for (int num : nums) {
            numsArr.add(num);
        }

        for (int num : nums) {
            if (!numsArr.contains(num - 1)) {
                int currentStreak = 1;
                int currentNum = num;

                while (numsArr.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

}
