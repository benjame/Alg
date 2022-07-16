package com.luogu;

import java.util.Arrays;
import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String midVisit = scan.nextLine();
        String preVisit = scan.nextLine();


//        System.out.println(midVisit);
//        System.out.println(postVisit);
        Solution1 sol = new Solution1();
        sol.buildTree(midVisit.toCharArray(), preVisit.toCharArray());
    }

    /* 我们要做的就是根据 postV 中元素的位置(对应)
     * */
    public void buildTree(char[] midV, char[] preV) {
        if (preV == null || midV == null)
            return;
        if (midV.length > 0 && preV.length > 0) {
            char curRootCh;
            int indexOfCurRoot;

            /* 首先根据 pre遍历确定当前的根节点
             * 再递归的获得其左右子树的根节点 */
            curRootCh = preV[0];

            indexOfCurRoot = findIndex(midV, curRootCh);
            preV = Arrays.copyOfRange(preV, 1, preV.length);

            char[] rightMid = null;
            char[] rightPre = null;
            char[] leftMid = null;
            char[] leftPre = null;

            leftMid = Arrays.copyOfRange(midV, 0, indexOfCurRoot);
            leftPre = Arrays.copyOfRange(preV, 0, indexOfCurRoot);

            if (indexOfCurRoot + 1 < midV.length)
                rightMid = Arrays.copyOfRange(midV, indexOfCurRoot + 1, midV.length);
            if (indexOfCurRoot < preV.length)
                rightPre = Arrays.copyOfRange(preV, indexOfCurRoot, preV.length);


            buildTree(leftMid, leftPre);
            buildTree(rightMid, rightPre);
            System.out.print(curRootCh);
        }
        return;
    }

    private static int findIndex(char[] chArr, char ch) {
        for (int i = 0; i < chArr.length; i++) {
            if (chArr[i] == ch)
                return i;
        }
        return -1;
    }
}