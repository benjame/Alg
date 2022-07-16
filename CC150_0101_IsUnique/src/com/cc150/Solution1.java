package com.cc150;

import java.util.HashSet;

/**
 * Use Hash
 */
public class Solution1 {
    public static void main(String[] args) {
        String testStr1 = "Leetcode";
        String testStr2 = "letuscoding";

        Solution1 sol = new Solution1();
        System.out.println(sol.isUnique(testStr1));
        System.out.println(sol.isUnique(testStr2));
    }

    public boolean isUnique(String astr) {
        HashSet<Character> hs = new HashSet<Character>();
        for (int i = 0; i < astr.length(); i++) {
            if (hs.contains(astr.charAt(i)))
                return false;
            hs.add(astr.charAt(i));
        }
        return true;
    }

    
}
