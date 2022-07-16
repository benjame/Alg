package com.luogu;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 题目: 洛谷 P4913 二叉树的深度
 * 思路:
 */

public class Solution1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        Queue<childs> leaves = new LinkedList<>();

        Solution1 sol = new Solution1();
        System.out.print(sol.solve(N, leaves, scan));
    }

    public int solve(int N, Queue<childs> leaves, Scanner scan) {
        for (int i = 0; i < N; i++) {
            int left = scan.nextInt();
            int right = scan.nextInt();

            leaves.add(new childs(left, right));
        }
        //构建二叉树
        TreeNode root = new TreeNode(1);
        TreeNode curP = root;
        Queue<TreeNode> curLevelLeaves = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            childs chd = leaves.poll();
            int valLeft = chd.left;
            int valRight = chd.right;

            curP.leftRef = new TreeNode(valLeft);
            curP.rightRef = new TreeNode(valRight);
            curLevelLeaves.add(curP.leftRef);
            curLevelLeaves.add(curP.rightRef);
            curP = curLevelLeaves.poll();
        }
        return depGet(root, 0);

    }

    public int depGet(TreeNode node, int depth) {
        TreeNode p = node;
        if (p == null)
            return depth;
        else if (p.leftRef != null && p.rightRef != null) {
            return Math.max(depGet(p.leftRef, depth + 1), depGet(p.rightRef, depth + 1));
        } else if (p.leftRef == null && p.rightRef != null) {
            return depGet(p.rightRef, depth + 1);
        } else
            return depth + 1;


    }


    private class childs {
        int left;
        int right;

        childs(int x, int y) {
            left = x;
            right = y;
        }
    }

    private class TreeNode {
        int val;
        TreeNode leftRef = null;
        TreeNode rightRef = null;

        TreeNode(int x) {
            val = x;
        }
    }

}
