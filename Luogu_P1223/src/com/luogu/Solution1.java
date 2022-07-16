package com.luogu;

import java.util.Arrays;
import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        if (n <= 0) {
            return;
        }

        Pair[] waitTimes = new Pair[n];

        for (int i = 0; i < n; i++) {
            int waitTime = scan.nextInt();
            Pair p = new Pair(i + 1, waitTime);
            waitTimes[i] = p;
        }
        Solution1 sol = new Solution1();
        sol.Solve(waitTimes);
    }

    private void Solve(Pair[] waitTimes) {
        double avgTime = 0;
        double totalTime = 0;

        Arrays.sort(waitTimes, Pair::compareTo);
        for (int i = 0; i < waitTimes.length; i++) {
            totalTime += ((waitTimes.length - i - 1) * waitTimes[i].waitTime);
            System.out.print(waitTimes[i].indx);
            System.out.print(" ");
        }
        avgTime = (totalTime / waitTimes.length);
        System.out.printf("\n%.2f", avgTime);
    }
}
