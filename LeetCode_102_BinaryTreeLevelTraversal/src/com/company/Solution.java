package com.company;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * BFS
 */
public class Solution {
    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(TreeNode root) {


        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        List<List<Integer>> list2 = new LinkedList<List<Integer>>();

        if (root == null)
            return list2;

        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list1 = new LinkedList<Integer>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (!isLeaf(node)) {
                    if (node.left != null)
                        queue.offer(node.left);
                    if (node.right != null)
                        queue.offer(node.right);
                }
                list1.add(node.val);
            }
            list2.add(list1);
        }
        return list2;
    }

    boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null ? true : false;
    }
}