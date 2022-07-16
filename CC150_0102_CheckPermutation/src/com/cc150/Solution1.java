package com.cc150;


/**
 * Bucket counting method
 *
 */
public class Solution1 {
    public static void main(String[] args) {

    }

    public boolean CheckPermutation(String s1, String s2) {

        if (s1.length() != s2.length())
            return false;
        int[] count = new int[128];
        for (int i : count) {
            i = 0;
        }

        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i)]++;  // 统计原串中每种字符的数量
            count[s2.charAt(i)]--;  // 重排串用掉了字符
        }

        // 如果互为字符重排，那么array数组中所有元素应该都为0
        for (int x : count) {
            if (x != 0) {
                return false;
            }
        }
        return true;

    }
}
