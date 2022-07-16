/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        int length = preorder.length;
        if(length == 0) return null;
        TreeNode root= new TreeNode(preorder[0]);
        TreeNode iNode;
        TreeNode parentNode = root;
        for(int index = 1; index < length; index++) {
            iNode = new TreeNode(preorder[index]);
            insertNode(parentNode, iNode);
        }
        return root;
    }

    //写一个节点插入函数
    private void insertNode(TreeNode root, TreeNode iNode) {
        if(iNode.val < root.val) {
            if (root.left == null) {
                root.left = iNode;
            }
            else insertNode(root.left, iNode);
        }
        else if(iNode.val > root.val) { 
            //插入节点值大于根节点值
            if(root.right == null) {
                //右节点为空
                root.right = iNode;
            }
            else {
                //右节点不为空
                insertNode(root.right, iNode);
            }
        }
    }
}