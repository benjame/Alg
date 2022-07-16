package com.luogu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        int T = scan.nextInt();
        ArrayList<Double> valueRatio = new ArrayList<>(N);
        if (N <= 0) {
            System.out.printf("%.2f", 0.0);
        }

        HashMap<Double, Double> accountRatio = new HashMap<Double, Double>();
        double totalCount = 0.0;
        double totalValue = 0.0;

        for (int i = 0; i < N; i++) {
            double m = scan.nextDouble();
            double v = scan.nextDouble();
            totalCount += m;
            totalValue += v;
            double ratio = v / m;
            if (!valueRatio.contains(ratio)) {
                valueRatio.add(ratio);
                accountRatio.put(ratio, m);
            } else {
                accountRatio.replace(ratio, accountRatio.get(ratio) + m);
            }
        }

        if (T > totalCount) {
            System.out.printf("%.2f", totalValue);
        }

        valueRatio.sort(Double::compareTo);

//        for (Double aDouble : valueRatio) {
//            System.out.print(aDouble + " ");
//            System.out.println(valueRatio.size());
//        }

        int currentAccount = 0;
        double maxValueGet = 0;


        for (int i = valueRatio.size() - 1; i >= 0; --i) {
            if (currentAccount == T) {
                System.out.printf("%.2f", maxValueGet);
                break;
            }
            if (currentAccount < T && currentAccount + accountRatio.get(valueRatio.get(i)) <= T) {
                currentAccount += accountRatio.get(valueRatio.get(i));
                maxValueGet += (accountRatio.get(valueRatio.get(i)) * valueRatio.get(i));
            }
            if (currentAccount < T && currentAccount + accountRatio.get(valueRatio.get(i)) > T) {
                maxValueGet += ((T - currentAccount) * valueRatio.get(i));
                currentAccount = T;
            }
        }
    }
}