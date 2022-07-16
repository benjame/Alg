package com.cc150;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;


/*
执行结果：
通过
执行用时：7 ms, 在所有 Java 提交中击败了 44.64% 的用户
内存消耗：40 MB, 在所有 Java 提交中击败了 54.14% 的用户
*/

public class Solution1 {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for (int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }

        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode head = stringToListNode(line);

            ListNode ret = new Solution1().removeDuplicateNodes(head);

            String out = listNodeToString(ret);

            System.out.print(out);
        }
    }

    public ListNode removeDuplicateNodes(ListNode head) {
        HashSet<Integer> record = new HashSet<>();
        ListNode curP = head;
        ListNode preP = head;
        while (curP != null) {
            while (record.contains(curP.val)) {
                curP = curP.next;
                preP.next = curP;
                if (curP == null)
                    break;
            }

            if (curP != null && !record.contains(curP.val)) {
                record.add(curP.val);
            }

            if (curP != null) {
                preP = curP;
                curP = curP.next;
            }
        }
        return head;
    }
}

