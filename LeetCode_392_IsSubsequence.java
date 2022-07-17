public class LeetCode_392_IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int lenS = s.length();
        int lenT = t.length();
        if (lenS == 0) {
            return true;
        }
        if (lenT == 0) {
            return false;
        }
        for (int i = 0; i < lenT; i++) {
            if (s.charAt(0) == t.charAt(i)) {
                if (isSubsequence(s.substring(i), t.substring(i + 1))) {
                    return true;
                }
            }
        }
        return true;
    }
}
