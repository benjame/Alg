package com.luogu;

import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        if (n <= 0) {
            return;
        }
        Solution1 sol = new Solution1();
        sol.Solve(n, scan);
    }

    public void Solve(int n, Scanner scan) {
        int Num = (int) Math.pow(2, n);
//        System.out.println(Num);
        Pair[] matchSequence = new Pair[Num];
        for (int i = 0; i < Num; i++) {
            matchSequence[i] = new Pair(i + 1, scan.nextInt());
        }
        Pair[] lastMatchSequence = matchSequence;
        for (int i = n - 1; i > 0; i--) {
            int curNum = (int) Math.pow(2, i);
            Pair[] curMatchSequence = new Pair[curNum];
            for (int j = 0; j < curNum; j++) {
                curMatchSequence[j] = new Pair(lastMatchSequence[2 * j].ability > lastMatchSequence[2 * j + 1].ability ?
                        lastMatchSequence[2 * j].index : lastMatchSequence[2 * j + 1].index,
                        Math.max(lastMatchSequence[2 * j].ability,
                                lastMatchSequence[2 * j + 1].ability));
            }
            lastMatchSequence = curMatchSequence;
        }
        if (lastMatchSequence.length == 2)
            System.out.print(lastMatchSequence[0].ability < lastMatchSequence[1].ability ?
                    lastMatchSequence[0].index : lastMatchSequence[1].index);
    }

    private class Pair {
        int index;
        int ability;

        Pair(int x, int y) {
            index = x;
            ability = y;
        }
    }
}
