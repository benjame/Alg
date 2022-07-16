package com.company;

/**
 * DFS
 */
public class Solution {
    public static void main(String[] args) {
    }

    public int sumOfLeftLeaves(TreeNode root) {

        if (root == null)
            return 0;
        //travseral of all node

        return dfs(root);
    }

    private boolean isLeaf(TreeNode node) {
        if (node.left == null && node.right == null)
            return true;

        return false;
    }


    private int dfs(TreeNode node) {
        int ans = 0;

        if (node.left != null)
            return ans += isLeaf(node.left) ? node.left.val : dfs(node.left);

        if (node.right != null && !isLeaf(node.right))
            return ans += dfs(node.right);

        return ans;
    }

}



