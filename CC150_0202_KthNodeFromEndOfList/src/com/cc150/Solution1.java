package com.cc150;

/*
执行结果：
通过
执行用时：0 ms, 在所有 Java 提交中击败了 100.00% 的用户
内存消耗：36.4 MB, 在所有 Java 提交中击败了 91.02% 的用户
*/

public class Solution1 {
    public static void main(String[] args) {

    }

    public int kthToLast(ListNode head, int k) {
        ListNode P2 = head; //the front pointer
        ListNode P1 = head; //the back pointer
        int distFromP1ToP2 = 1;

        while (P2.next != null) {
            if (distFromP1ToP2 < k) {
                P2 = P2.next;
                distFromP1ToP2++;
            }

            if (distFromP1ToP2 == k && P2.next == null) {
                return P1.val;
            }
            if (distFromP1ToP2 == k && P2.next != null) {
                P2 = P2.next;
                P1 = P1.next;
            }
        }
        return P1.val;
    }
}
