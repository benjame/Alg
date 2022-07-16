package com.geeksforgeeks;

/**
 *
 */

public class KMP_StringMatching_DFA {
    public static void main(String[] args) {

    }

    private String pat;
    private int[][] dfa;
    /* dfa[text.charAt(i)][j]表示目前
     当text索引为i, pattern索引为j时,
     pattern索引应该更新的值Value */

    /**
     * @param pat
     */
    public KMP_StringMatching_DFA(String pat) {
        // 由模式字符串构造DFA
        this.pat = pat;
        int M = pat.length();
        int R = 256; //256种character字符
        dfa = new int[R][M];
        dfa[pat.charAt(0)][0] = 1;
        for (int X = 0, j = 1; j < M; j++) {
            // 计算dfa[][j]
            for (int c = 0; c < R; c++)
                dfa[c][j] = dfa[c][X];
            dfa[pat.charAt(j)][j] = j + 1;
            X = dfa[pat.charAt(j)][X];
        }
    }


    /**
     * @param txt
     * @return 匹配成功返回匹配的位置,
     * 否则未找到匹配则返回N(文本txt的长度N)
     */
    public int search(String txt) {
        // 模拟DFA处理文本txt时的操作
        int i, j, N = txt.length(), M = pat.length();
        for (i = 0, j = 0; i < N && j < M; i++)
            j = dfa[txt.charAt(i)][j];
        if (j == M)
            return i - M;  // 找到匹配
        else
            return N;  // 未找到匹配
    }
}
