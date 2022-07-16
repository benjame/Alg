package com.cc150;

public class Solution1 {
    public static void main(String[] args) {
        String testStr = "Mr John Smith    ";

        Solution1 sol = new Solution1();
        System.out.println(sol.replaceSpaces(testStr, 13));
    }

    public String replaceSpaces(String S, int length) {
        int actualLen = 0;
        StringBuffer strOps = new StringBuffer();
        for (char c : S.toCharArray()) {
            if (c == ' ' && actualLen < length) {
                strOps.append("%20");
                actualLen++;
            }
            if (c != ' ' && actualLen < length) {
                strOps.append(c);
                actualLen++;
            }
        }

        return strOps.toString();

    }
}
