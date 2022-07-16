package com.cc150;

public class Solution2 {
    public static void main(String[] args) {

    }

    /**
     *
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        ListNode root = new ListNode(0);
        root.next = head;
        ListNode curr = root;
        ListNode root2 = new ListNode(1);
        ListNode curr2 = root2;
        ListNode p = head;
        while (p != null) {
            if (p.val < x) {
                curr.next = p;
                curr = p;
                p = p.next;
                curr.next = null;
            } else {
                curr2.next = p;
                curr2 = p;
                p = p.next;
                curr2.next = null;
            }
        }
        curr.next = root2.next;
        return root.next;
    }
}
