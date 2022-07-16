package com.cc150;

/*
执行结果：
通过
执行用时：36 ms, 在所有 Java 提交中击败了7.08% 的用户
内存消耗：39.7 MB, 在所有 Java 提交中击败了5.03% 的用户
*/

/**
 * 1. 频繁使用substring函数 开销过大
 * 2. 每次循环创建一个String字符串,空间占用问题
 *
 */
public class Solution1 {
    public static void main(String[] args) {
        String s1 = "waterbottle", s2 = "erbottlewat";
        String s3 = "aa", s4 = "aba";
        String s5 = "aabbcc", s6 = "aabbcc";

        Solution1 sol1 = new Solution1();
        Solution2 sol2 = new Solution2();

        System.out.println(sol1.isFlipedString(s1, s2));
        System.out.println(sol1.isFlipedString(s3, s4));
        System.out.println(sol1.isFlipedString(s5, s6));

        System.out.println();

        System.out.println(sol2.isFlipedString(s1, s2));
        System.out.println(sol2.isFlipedString(s3, s4));
        System.out.println(sol2.isFlipedString(s5, s6));
    }

    public boolean isFlipedString(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        if (s1.length() == 0)
            return true;

        /* Determine which character is the dividing point.
           We assume String s1 is the original string, s2 is
           the modification of s1. */

        for (int i = 0; i < s1.length(); i++) {
            String strTest = (s1.substring(i) + s1.substring(0, i));
            if (strTest.equals(s2))
                return true;
        }
        return false;
    }
}
