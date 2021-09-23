package com._leetcode.L1__L100;

import com._leetcode.ListNode;

import java.util.LinkedList;
import java.util.Stack;

public class L83 {
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        Stack<ListNode> stack = new Stack<>();
        stack.push(head);
        ListNode node = head.next;
        while (node != null) {
            if (stack.peek().val != node.val)
                stack.push(node);
            node = node.next;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = stack.pop();//取出来的第一个节点并不干净，要断掉尾巴
        dummyHead.next.next = null;
        while (!stack.isEmpty()) {
            node = stack.pop();
            node.next = dummyHead.next;
            dummyHead.next = node;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] arr = {2,2,1,1};
        ListNode node = new ListNode().buildList(arr);
        node = deleteDuplicates(node);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
