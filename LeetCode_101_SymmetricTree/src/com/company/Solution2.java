package com.company;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目: 101 Symmetric Tree
 * 思路: 迭代的方法，需要引入队列Queue
 */

public class Solution2 {
    public static void main(String[] args) {

    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;

        if (root.left == null && root.right == null)
            return true;

        if (root.left != null && root.right != null)
            return isSymmetricOfTwoNodes(root.left, root.right);

        return false;
    }

    private boolean isSymmetricOfTwoNodes(TreeNode left, TreeNode right) {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(left);
        queue.offer(right);

        while (!queue.isEmpty()) {
//            int size = queue.size();

            TreeNode curLeft = queue.poll();
            TreeNode curRight = queue.poll();
            if (curLeft.val != curRight.val)
                return false;
            if (curLeft.left != null && curRight.right != null) {
                queue.offer(curLeft.left);
                queue.offer(curRight.right);
            }
            if (curLeft.right != null && curRight.left != null) {
                queue.offer(curLeft.right);
                queue.offer(curRight.left);
            }

            if (curLeft.left != null && curRight.right == null) return false;
            if (curLeft.left == null && curRight.right != null) return false;
            if (curLeft.right != null && curRight.left == null) return false;
            if (curLeft.right == null && curRight.left != null) return false;

        }
        return true;
    }
}