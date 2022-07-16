package com.cc150;

/*
执行结果：
通过
执行用时：0 ms, 在所有 Java 提交中击败了 100.00% 的用户
内存消耗：38.3 MB, 在所有 Java 提交中击败了 93.68% 的用户
*/

/**
 * 将两个 s1 拼起来,测试是否包含s2
 */

public class Solution2 {
    public boolean isFlipedString(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;

        return s1.equals(s2) || (s1.length() == s2.length() && (s1 + s1).contains(s2));
    }
}
