package com.company;

import java.util.Arrays;
import java.util.List;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Solution {

    public static void main(String[] args) {
        // write your code here
        Solution so = new Solution();
        int[] nums = {1, 2, 3, 4, 5};
        TreeNode T = so.sortedArrayToBST(nums);

        System.out.println(so.isBalanced(T));

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

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftTreeDepth = treeDepth(root.left); // 左子树高度
        int rightTreeDepth = treeDepth(root.right); // 右子树高度
        if (Math.abs(leftTreeDepth - rightTreeDepth) > 1) {
            return false; // 高度差大于1说明不平衡
        }
        // 若以当前节点为根的子树是平衡的，继续递归检查它左右子树的平衡性
        return isBalanced(root.left) && isBalanced(root.right);

    }

    public int treeDepth(TreeNode root) {
        // 递归出口，空树的高度为0
        if (root == null) {
            return 0;
        }
        // 当前二叉树的高度 = max(左子树高度,右子树高度) + 1
        return Math.max(treeDepth(root.left), treeDepth(root.right)) + 1;
    }

    public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        return null;
    }
}