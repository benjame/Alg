public class LeetCode_03_LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == "")
            return 0;
        Set<Character> instinctCharacters = new HashSet<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (!instinctCharacters.contains(s.charAt(i))) {
                instinctCharacters.add(s.charAt(i));
            }
        }
        int numOfInstinctChars = instinctCharacters.size();
        Set<Character> usedCharacters = new HashSet<Character>();
        boolean findRes = false;
        for (int i = numOfInstinctChars; i >= 1 && !findRes; i--) {
            usedCharacters.clear();
            for (int j = 0; j < s.length() - i + 1; j++) {
                usedCharacters.clear();
                for (int j2 = j; j2 < j + i; j2++) {
                    if (!usedCharacters.contains(s.charAt(j2))) {
                        usedCharacters.add(s.charAt(j2));
                    } else
                        break;
                }
                if (usedCharacters.size() == i) {
                    findRes = true;
                    return i;
                }
            }
        }
        return i;
    }
}


class LeetCode_03_LongestSubstringWithoutRepeatingCharacters_Solution2 {
    public int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }
}
