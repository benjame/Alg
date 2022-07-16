import java.util.ArrayList;
import java.util.Iterator;
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
   
    ArrayList<List<Integer>> zigzagTravList = new ArrayList<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        int level = 0;
        if(root == null) return zigzagTravList;
        ArrayList<TreeNode> curLevelNodes = new ArrayList<>();
        curLevelNodes.add(root);
        return zigzagLevelOrderSol(curLevelNodes, level);
    }

    private List<List<Integer>> zigzagLevelOrderSol(ArrayList<TreeNode> curLevelNodes, int level) {
        if(curLevelNodes.isEmpty()) 
            return zigzagTravList;

        ArrayList<Integer> curLevelElements = new ArrayList<>();
        ArrayList<TreeNode> nextLevelNodes = new ArrayList<>();
        for(TreeNode node : curLevelNodes) {
            if(node != null) {
                curLevelElements.add(node.val);
                if(node.left != null) {
                    nextLevelNodes.add(node.left);
                }
                if(node.right != null) {
                    nextLevelNodes.add(node.right);
                }
            }        
        }
        if(level % 2 == 0) {
            zigzagTravList.add(curLevelElements);
        } else {
            zigzagTravList.add(inverseList(curLevelElements));
        }
        return zigzagLevelOrderSol(nextLevelNodes, level+1);
    }
    
    private ArrayList<Integer> inverseList(ArrayList<Integer> list) {
        ArrayList<Integer> retList = new ArrayList<Integer>();
        for(int i = list.size() - 1; i >= 0; i--) {
            retList.add(list.get(i));
        }
        return retList;
    }
}


class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        nodeQueue.offer(root);
        boolean isOrderLeft = true;

        while (!nodeQueue.isEmpty()) {
            Deque<Integer> levelList = new LinkedList<Integer>();
            int size = nodeQueue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode curNode = nodeQueue.poll();
                if (isOrderLeft) {
                    levelList.offerLast(curNode.val);
                } else {
                    levelList.offerFirst(curNode.val);
                }
                if (curNode.left != null) {
                    nodeQueue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    nodeQueue.offer(curNode.right);
                }
            }
            ans.add(new LinkedList<Integer>(levelList));
            isOrderLeft = !isOrderLeft;
        }
        return ans;
    }
}