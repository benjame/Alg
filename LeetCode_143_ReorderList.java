/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

/**
 * 双指针原地操作
 */
class Solution {
    public void reorderList(ListNode head) {
        ListNode prePt = head;
        ListNode postPt = head;
        if (head == null)
            return;

        ListNode curPt = head;
        while (curPt != null) {
            postPt = curPt;
            curPt = curPt.next;
        }

        // 现在postPt指向最后一个节点node
        // 设置一个boolean标签表示当前是否需要插入节点
        boolean ins = true;
        while (prePt != postPt) {
            if (ins == true) {

            }
        }
    }
}

/**
 * 先用线性表存储链表，然后依照要求的顺序构建链表即可
 */
class Solution2 {
    public void reorderList(ListNode head) {
        if (head == null)
            return;
        List<ListNode> list = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        int i = 0, j = list.size() - 1;
        while (i < j) {
            list.get(i).next = list.get(j);
            i++;
            // 此时需要做判断，i与j是否相遇
            if (i == j) {
                break;
            }
            list.get(j).next = list.get(i);
            j--;
        }
        // 代码运行至该点，i==j，需要将i，j指向的节点的后续链接断掉，避免环的产生
        list.get(i).next = null;
    }
}