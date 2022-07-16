package com.company;

import java.util.Arrays;

/**
 * Definition for a binary tree node. 
 * public class TreeNode { 
 * int val; 
 * TreeNode left; 
 * TreeNode right; 
 * TreeNode(int x) { val = x; } 
 * }
 */

public class Solution {

    public static void main(String[] args) {
        // write your code here
        Solution so = new Solution();
        int[] nums = { 1, 2, 3, 4, 5 };
        TreeNode T = so.sortedArrayToBST(nums);

    }

    public TreeNode sortedArrayToBST(int[] nums) {
        // this is a sorted array, so we can easily get the middle (middle near) element
        if (nums.length == 0)
            return null;

        int mid = nums.length / 2;
        TreeNode T = new TreeNode(nums[mid]);

        if (0 <= mid && mid < nums.length) {
            int[] lnums = Arrays.copyOfRange(nums, 0, mid);
            int[] rnums = Arrays.copyOfRange(nums, mid + 1, nums.length);

            T.left = sortedArrayToBST(lnums);
            T.right = sortedArrayToBST(rnums);
        }
        return T;
    }

}
