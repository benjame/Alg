package com.cc150;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        Solution2 sol2 = new Solution2();
        List<List<Integer>> res = sol2.subsets(nums);
        System.out.print(res);
    }

    public List<List<Integer>> subsets(int[] nums) {
        /* 根据观察可知 有(2^n)个子集 */
        List<List<Integer>> res = new ArrayList<>(1 << nums.length);
        res.add(new ArrayList<>());
        recursion(nums, 0, res);
        return res;
    }

    public static void recursion(int[] nums, int index, List<List<Integer>> res) {
        //如果数组中的元素都访问完了，直接return
        if (index >= nums.length)
            return;
        int size = res.size();
        for (int j = 0; j < size; j++) {
            List<Integer> list = new ArrayList<>(res.get(j));
            //然后在新的子集后面追加一个值
            list.add(nums[index]);
            res.add(list);
        }
        //递归下一个元素
        recursion(nums, index + 1, res);
    }
}
