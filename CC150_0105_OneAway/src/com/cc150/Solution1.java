package com.cc150;

public class Solution1 {

    /*
     * Idea: Solve this problem from 3 cases respectively
     * 1. String first.length == second.length
     * 2. String |first.length - second.length| == 1
     * 3. Otherwise
     */
    public static void main(String[] args) {
        String str1 = "leetcode";
        String str2 = "leekcodi";

        Solution1 sol = new Solution1();
        System.out.println(sol.oneEditAway(str1, str2));
    }

    /**
     * @param first
     * @param second
     * @return
     */
    public boolean oneEditAway(String first, String second) {
        int dist = Math.abs(first.length() - second.length());
        if (dist > 1)
            return false;

        if (dist == 1) {
            // get the shorter one
            String longer = (first.length() > second.length() ? first : second);
            String shorter = (first.length() < second.length() ? first : second);

            if (shorter.length() == 0) return true;


            /* KeyPoint we should pay attention */
            //find the first matched index
            for (int i = 0; i < shorter.length(); i++) {
                if (shorter.charAt(i) != longer.charAt(i)) {
                    return longer.substring(i + 1).equals(shorter.substring(i));
                }

            }
            return true;
        }

        if (dist == 0) {
            /*if it existed 2 or more different characters
             return false
             */
            int count = 0;
            for (int i = 0; i < first.length(); i++) {
                if (first.charAt(i) != second.charAt(i))
                    count++;
            }
            if (count >= 2)
                return false;
            return true;
        }
        return true;
    }

}
