package com.cc150;

public class Solution1 {
    public static void main(String[] args) {
        int[] linkData = {1, 2, 3, 4, 5};
        ListNode linkList = new ListNode(0);
        ListNode curP = linkList;
        for (int i = 0; i < linkData.length; i++) {
            ListNode newNode = new ListNode(linkData[i]);
            curP.next = newNode;
            System.out.println(curP.val);
            curP = curP.next;
        }
    }

    /**
     * 思路：(1)线性遍历整个链表，小于x的元素插入新建的链表中
     * (2)然后删除原链表中的该元素
     * (3)最后将新建的链表链接到原链表之前
     *
     * @param head
     * @param x
     * @retur
     */
    public ListNode partition(ListNode head, int x) {
        ListNode curP = head;
        ListNode newListNode = new ListNode(0);
        ListNode newhead = newListNode;
        while (curP != null) {
            if (curP.val < x) {
                newListNode.next = new ListNode(x);
                newListNode = newListNode.next;
                deleteNode(head, curP);
                curP = curP.next;
            }
            curP = curP.next;
        }
        newhead = deleteNode(newhead, newhead);
        curP = newhead;
        while (curP.next != null) {
            curP = curP.next;
        }
        curP.next = head;
        return newhead;

    }

    /**
     * 函数： 删除指定节点node
     *
     * @param head
     * @param node
     * @return
     */
    private ListNode deleteNode(ListNode head, ListNode node) {
        if (head == null) return head;
        if (head != null && head.next == null && node == head) return null;

        ListNode curNode = head;
        ListNode preNode = head;
        while (curNode != null) {
            if (curNode == node) {
                /* 如果删除节点是尾节点 */
                if (curNode.next == null) {
                    preNode.next = null;
                    curNode = null;
                }
                /* 如果删除节点是头节点 */
                if (node == head) {
                    curNode = curNode.next;
                    head = head.next;
                }
                /* 如果删除节点是中间节点 */
                if (node.next != null) {
                    preNode.next = node.next;
                }
            }
            preNode = curNode;
            curNode = curNode.next;
        }
        return head;
    }


}