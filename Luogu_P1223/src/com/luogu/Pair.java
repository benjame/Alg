package com.luogu;

public class Pair implements Comparable {
    int indx;
    int waitTime;

    Pair() {
        indx = 0;
        waitTime = 0;
    }

    Pair(int x, int y) {
        indx = x;
        waitTime = y;
    }


    @Override
    public int compareTo(Object o) {
        Pair other = (Pair) o;
        return Integer.compare(this.waitTime, other.waitTime);
    }
}