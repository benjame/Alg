package com.cc150;

/*
执行结果：
通过
执行用时：0 ms, 在所有 Java 提交中击败了 100.00% 的用户
内存消耗：38.4 MB, 在所有 Java 提交中击败了 44.07% 的用户
*/

public class Solution1 {
    public static void main(String[] args) {

    }

    public void deleteNode(ListNode node) {
        ListNode preNode = node;
        node = node.next;

        preNode.val = node.val;
        preNode.next = node.next;
    }
}
