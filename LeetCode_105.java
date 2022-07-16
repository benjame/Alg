import java.util.Arrays;

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
    private Map<Integer, Integer> indexMap;

    private TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left_index, int preorder_right_index, int inorder_left_index, int inorder_right_index) {
        if (preorder_left_index > preorder_right_index) {
            return null;
        }

        // 前序遍历中的第一个节点就是根节点
        int preorder_root_index = preorder_left_index;
        // 在中序遍历中定位根节点
        int inorder_root_index = indexMap.get(preorder[preorder_root_index]);
        
        // 先把根节点建立出来
        TreeNode root = new TreeNode(preorder[preorder_root_index]);
        // 得到左子树中的节点数目
        int size_left_subtree = inorder_root_index - inorder_left_index;
        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = myBuildTree(preorder, inorder, preorder_left_index + 1, preorder_left_index + size_left_subtree, inorder_left_index, inorder_root_index - 1);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = myBuildTree(preorder, inorder, preorder_left_index + size_left_subtree + 1, preorder_right_index, inorder_root_index + 1, inorder_right_index);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        // 构造哈希映射，帮助我们快速定位根节点
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            //val->index
            indexMap.put(inorder[i], i); 
        }
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }
}