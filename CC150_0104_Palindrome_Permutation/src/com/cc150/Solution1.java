package com.cc150;

public class Solution1 {
    public static void main(String[] args) {
        String str = "abcbbcca";
        Solution1 sol = new Solution1();

        System.out.println(sol.canPermutePalindrome(str));

    }

    /**
     * Check if a String is a permutation of Palidrome Sequence
     *
     * @param s
     * @return
     */
    public boolean canPermutePalindrome(String s) {
        /**
         * Easy Case: if there are 2 or more letters that occurs (2n + 1) times.
         * Absolutely, this case is not Permutation of Palindrome
         *
         */
        int[] count = new int[128];
        int flag = 0;
        for (int i : count) {
            i = 0;
        }

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }

        for (int i : count) {
            if (i % 2 == 1) {
                flag++;
            }
        }

        if (flag >= 2)
            return false;
        return true;
    }
}
