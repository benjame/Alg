import java.util.ArrayList;

import java.lang.Math;
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
    public boolean isSymmetric(TreeNode root) {
        ArrayList<TreeNode> thisLevelNodes = new ArrayList<>();
        thisLevelNodes.add(root);
        return isNextLevelSymmetric(thisLevelNodes, 1);
    }

    private boolean isNextLevelSymmetric(ArrayList<TreeNode> thisLevelNodes, int levelSize) {
        //
        boolean flg = false;
        ArrayList<TreeNode> nextLevelNodes = new ArrayList<>();
        if(!thisLevelNodes.isEmpty()) {
            for(int i = 0; i < levelSize / 2; i++) {
                if(thisLevelNodes.get(i) != null && thisLevelNodes.get(levelSize - i - 1) != null) {
                    if (thisLevelNodes.get(i).val != thisLevelNodes.get(levelSize - i - 1).val)
                        return false;
                }
                if(thisLevelNodes.get(i) == null && thisLevelNodes.get(levelSize - i - 1) != null) {
                    return false;
                }
                if(thisLevelNodes.get(i) != null && thisLevelNodes.get(levelSize - i - 1) == null) {
                    return false;
                }
            }
            for (TreeNode treeNode : thisLevelNodes) {
                if (treeNode != null) {
                    if(treeNode.left != null || treeNode.right != null) {
                        flg = true;
                    }
                    nextLevelNodes.add(treeNode.left);
                    nextLevelNodes.add(treeNode.right);
                }
            }
            if(flg == false) 
                return true;
            levelSize = nextLevelNodes.size();
            return isNextLevelSymmetric(nextLevelNodes, levelSize);
        }
        return true;
    }
}


class Solution {
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }
}
