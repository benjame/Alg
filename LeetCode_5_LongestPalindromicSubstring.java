class LeetCode_5_LongestPalindromicSubstring_Solution1 {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        // dp[i][j] 表示 s[i..j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        // 初始化：所有长度为 1 的子串都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        // 递推开始
        // 先根据子串长度进行枚举
        for (int L = 2; L <= len; L++) {
            // 枚举左边界，左边界的上限设置可以宽松一些
            for (int i = 0; i < len; i++) {
                // 由 L 和 i 可以确定右边界，即 j - i + 1 = L 得
                int j = L + i - 1;
                // 如果右边界越界，就可以退出当前循环
                if (j >= len) {
                    break;
                }

                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}

/**
 * 中心扩展算法
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 */
class LeetCode_5_LongestPalindromicSubstring_Solution2 {
    public String longestPalindrome(String s) {
        // 如果s是null或者长度为0返回长度为0的字符串
        if (s == null || s.length() < 1) {
            return "";
        }
        
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            //len1与len2分别表示两种情况下的最大扩展长度，以i为中心(单元素)以及以(i,i+1)为中心（双元素）
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) { //如果len大于当前(end - start) 更新end与start
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public int expandAroundCenter(String s, int left, int right) {
        //如果满足left和right在范围内，且left位置字符等于right位置字符，就向外扩展
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        // 返回最大扩展长度
        return right - left - 1;
    }

}
