import java.util.ArrayList;
import java.util.List;
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<TreeNode> upperLevel = new ArrayList<TreeNode>();
        ArrayList<List<Integer>> upperLevelVals = new ArrayList<List<Integer>>();
        if(root == null) return upperLevelVals;

        upperLevel.add(root);

        ArrayList<Integer> curList = new ArrayList<Integer>();
        curList.add(root.val);
        upperLevelVals.add(curList);
        return levelOrderTraversal(upperLevel, upperLevelVals);
    }

    private ArrayList<List<Integer>> levelOrderTraversal(ArrayList<TreeNode> upperLevel, ArrayList<List<Integer>> upperLevelVals) {
        //如果上层为空，直接返回null
        if(upperLevel.isEmpty()) {
            return upperLevelVals;
        }
        //否则根据上层依次遍历下层节点
        ArrayList<Integer> nextLevel = new ArrayList<Integer>();
        ArrayList<TreeNode> curLevel = new ArrayList<>();
        for(TreeNode node : upperLevel) {
            if(node.left != null) {
                nextLevel.add(node.left.val);
                curLevel.add(node.left);
            }
            if(node.right != null) {
                nextLevel.add(node.right.val);
                curLevel.add(node.right);
            }
        }
        if (!nextLevel.isEmpty()) {
            upperLevelVals.add(nextLevel);
        }
        return levelOrderTraversal(curLevel, upperLevelVals);
    }
}


class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null) {
            return ret;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            int currentLevelSize = queue.size();
            for (int i = 1; i <= currentLevelSize; ++i) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ret.add(level);
        }
        
        return ret;
    }
}
