package com.cc150;

public class Solution1 {
    public static void main(String[] args) {
        //test function countRepeatChar
        String str1 = "RRRRyouOOOKGuy";

        Solution1 sol1 = new Solution1();
        Solution2 sol2 = new Solution2();
        System.out.println(countRepeatChar(str1));
        System.out.println(countRepeatChar(str1.substring(7)));

        System.out.println(sol1.compressString(str1));
        System.out.println(sol2.compressString(str1));

    }

    public String compressString(String S) {
        if (S.length() == 0 || S.length() == 1)
            return S;
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < S.length(); i++) {
            int rCount = countRepeatChar(S.substring(i));
            str.append(S.charAt(i));
            str.append(rCount);
            i += (rCount - 1);
        }
        if (str.length() >= S.length())
            return S;
        else
            return str.toString();
    }

    private static int countRepeatChar(String str) {
        if (str.length() == 0 || str.length() == 1)
            return str.length();

        //From here, str.length() at least greater than 1
        int count = 0;
        char chPre = str.charAt(0);
        for (int i = 0; i < str.length(); i++) {
            if (chPre == str.charAt(i)) {
                count++;
                chPre = str.charAt(i);
            } else
                return count;
        }
        return count;
    }
}
