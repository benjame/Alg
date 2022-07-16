package com.company;


/* This is a complex solution because of
    Lacking of think thoroughly which means
    we can have a much simpler solution for it*/

/* The Codes had been commented
    was written by myself
    in first try. */


public class Solution1 {

    /*public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        if (root.left == null && root.right == null)
            return true;

        if (root.right.val == Integer.MAX_VALUE && root.val == Integer.MIN_VALUE)
            return true;

        if (root.left != null && root.right == null) {
            if (root.left.val >= root.val)
                return false;
            else
                return isChildTreeBST(root.left, root, Integer.MIN_VALUE, root.val);
        }

        if (root.right != null && root.left == null) {
            if (root.right.val <= root.val)
                return false;
            else
                return isChildTreeBST(root.right, root, root.val, Integer.MAX_VALUE);
        } else {
            if (root.left.val >= root.val)
                return false;
            if (root.right.val <= root.val)
                return false;
            else
                return (isChildTreeBST(root.left, root, Integer.MIN_VALUE, root.val) && isChildTreeBST(root.right, root, root.val, Integer.MAX_VALUE));
        }
    }

    private boolean isChildTreeBST(TreeNode node, TreeNode parent, int minValue, int maxValue) {
        if (node == null)
            return true;

        if (node.left == null && node.right == null && parent == null)
            return true;
        if (node.left == null && node.right == null) {
            if (node.val >= maxValue || node.val <= minValue)
                return false;
        }

        if (node.left != null && node.right != null) {
            if (parent == null) {
                if (node.left.val >= node.val)
                    return false;
                if (node.right.val <= node.val)
                    return false;
                if (node.val >= maxValue || node.val <= minValue)
                    return false;
                else
                    return (isChildTreeBST(node.left, node, Integer.MIN_VALUE, node.val) && isChildTreeBST(node.right, node, node.val, Integer.MAX_VALUE));

            } else {
                //we have to check our node is left or right leaf of our parent
                if (node == parent.left) {
                    if (node.right.val >= parent.val)
                        return false;
                    if (node.left.val >= node.val)
                        return false;
                    if (node.right.val <= node.val)
                        return false;
                    if (node.val > maxValue || node.val <= minValue)
                        return false;
                    else
                        return (isChildTreeBST(node.left, node, minValue, node.val) && isChildTreeBST(node.right, node, node.val, parent.val));
                } else {
                    if (node.left.val <= parent.val)
                        return false;
                    if (node.left.val >= node.val)
                        return false;
                    if (node.right.val <= node.val)
                        return false;
                    if (node.val >= maxValue || node.val <= minValue)
                        return false;
                    else
                        return (isChildTreeBST(node.left, node, parent.val, node.val) && isChildTreeBST(node.right, node, node.val, maxValue));
                }
            }
        }

        if (node.left != null && node.right == null) {
            if (parent != null) {
                if (node == parent.left) {
                    if (node.left.val >= node.val)
                        return false;
                    if (node.val >= maxValue || node.val <= minValue)
                        return false;
                    else
                        return isChildTreeBST(node.left, node, minValue, node.val);
                } else {
                    if (node.left.val <= parent.val)
                        return false;
                    if (node.left.val >= node.val)
                        return false;
                    if (node.val >= maxValue || node.val <= minValue)
                        return false;
                    else
                        return isChildTreeBST(node.left, node, parent.val, node.val);
                }
            }
            *//* Else parent == null *//*
            else {
                if (node.left.val >= node.val)
                    return false;
                if (node.val >= maxValue || node.val <= minValue)
                    return false;
                else
                    return isChildTreeBST(node.left, node, minValue, node.val);
            }
        }


        if (node.left == null && node.right != null) {
            if (parent != null) {
                if (node == parent.left) {
                    if (node.right.val >= parent.val)
                        return false;
                    if (node.right.val <= node.val)
                        return false;
                    if (node.val >= maxValue || node.val <= minValue)
                        return false;
                    else
                        return isChildTreeBST(node.right, node, node.val, parent.val);

                } else {
                    if (node.right.val <= node.val)
                        return false;
                    if (node.val >= maxValue || node.val <= minValue)
                        return false;
                    else
                        return isChildTreeBST(node.right, node, node.val, maxValue);
                }
            } else {
                if (node.right.val <= node.val)
                    return false;
                if (node.val >= maxValue || node.val <= minValue)
                    return false;
                else
                    return isChildTreeBST(node.right, node, node.val, maxValue);
            }
        }
        return true;
    }
*/

}
