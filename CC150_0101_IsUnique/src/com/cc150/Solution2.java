package com.cc150;


/**
 * Use bit-wise operation
 */

public class Solution2 {
    public static void main(String[] args) {
        String testStr1 = "Leetcode";
        String testStr2 = "letuscoding";

        Solution2 sol = new Solution2();
        System.out.println(sol.isUnique(testStr1));
        System.out.println(sol.isUnique(testStr2));
    }

    public boolean isUnique(String astr) {
        // We assume all characters occurred in astr are ASCII characters
        int[] letters = new int[128];
        for (int i : letters) {
            i = 0;
        }
        for (char c : astr.toCharArray()) {
            if (letters[c] == 1)
                return false;
            letters[c] += 1;
        }
        return true;
    }


}
