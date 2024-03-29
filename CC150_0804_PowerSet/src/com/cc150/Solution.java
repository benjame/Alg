package com.cc150;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Solution sol = new Solution();
        List<List<Integer>> res = sol.subsets(nums);
        System.out.print(res);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>(1 << nums.length);
        //先添加一个空的集合
        res.add(new ArrayList<>());
        for (int num : nums) {
            //每遍历一个元素就在之前子集中的每个集合追加这个元素，让他变成新的子集
            for (int i = 0, j = res.size(); i < j; i++) {
                //遍历之前的子集，重新封装成一个新的子集
                List<Integer> list = new ArrayList<>(res.get(i));
                //然后在新的子集后面追加这个元素
                list.add(num);
                //把这个新的子集添加到集合中
                res.add(list);
            }
        }
        return res;
    }
}
