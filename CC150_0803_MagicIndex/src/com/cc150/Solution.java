package com.cc150;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {0, 2, 4, 4};

        Solution sol = new Solution();
        System.out.println(sol.findMagicIndex(nums));
    }

    public int findMagicIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i == nums[i])
                return i;
        }
        return -1;
    }

}
