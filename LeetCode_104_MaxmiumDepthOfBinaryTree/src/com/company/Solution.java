package com.company;

public class Solution {
    public static void main(String[] args) {
    }

    /**
     * This function returns current maximum depth from this node
     *
     * @param root
     * @return current maximum depth from this node
     */
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return dfs(root, 1);
    }


    private int dfs(TreeNode node, int depth) {
        if (node == null)
            return depth;
        if (node.left != null && node.right != null)
            return Math.max(dfs(node.left, depth + 1), dfs(node.right, depth + 1));

        if (node.left != null && node.right == null)
            return dfs(node.left, depth + 1);

        if (node.right != null && node.left == null)
            return dfs(node.right, depth + 1);
        else return depth;

    }
}
