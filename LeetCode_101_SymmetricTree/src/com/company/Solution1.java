package com.company;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目: LeetCode 101 Symmetric Tree
 * 思路: 双指针跟踪对比 + 递归（DFS）
 *
 *
 */

public class Solution1 {
    public static void main(String[] args) {

    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;

        if (root.left != null && root.right != null) {
            return isSymmetricOfTwoNodes(root.left, root.right);
        }
        if (root.left == null && root.right == null)
            return true;

        return false;
    }

    private boolean isSymmetricOfTwoNodes(TreeNode left, TreeNode right) {
        if (left == null && right != null)
            return false;
        if (right == null && left != null)
            return false;
        if (left != null && right != null) {
            if (left.val != right.val)
                return false;
            return (isSymmetricOfTwoNodes(left.left, right.right) && isSymmetricOfTwoNodes(left.right, right.left));
        }
        return true; //when reach this line (left == null && right == null)
    }


}
