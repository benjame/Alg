package com.company;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    List<Integer> t = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();


    public static void main(String[] args) {
//        System.out.println((1 << 1));
    }

    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;

        //in here, (1 << n) equals to 2^n
        for (int mask = 0; mask < (1 << n); mask++) {
            t.clear();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    t.add(nums[i]);
                }
            }
            ans.add(new ArrayList<Integer>(t));

        }
        return ans;
    }
}
