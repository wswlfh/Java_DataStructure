package com._leetcode.L201__L300;

import com._leetcode.ListNode;

import java.util.Stack;

public class L234 {
    //234. 回文链表
    //Solution1：用栈
    public boolean isPalindrome(ListNode head) {
        if (head.next == null)
            return true;
        Stack<ListNode> stack = new Stack<>();
        ListNode node = head;
        int size = 0;
        while (node != null) {
            size++;
            node = node.next;
        }
        node = head;
        for (int i = 0; i < size / 2; i++) {
            stack.push(node);
            node = node.next;
        }
        node = (size % 2 == 0) ? node : node.next;
        while (node != null) {
            if (stack.peek().val == node.val)
                stack.pop();
            node = node.next;
        }
        return stack.isEmpty();
    }

    //Solution2：递归法 有空搞 设置两个指针，官方解法十分巧妙 一个一直移动，一个不断直到底再慢慢回来

    //Solution3：不讲武德法，直接用String相关的api
    public boolean isPalindrome2(ListNode head) {
        if (head.next == null)
            return true;
        StringBuilder res = new StringBuilder();
        while (head != null) {
            res.append(head.val);
            head = head.next;
        }
        return res.toString().equals(res.reverse().toString());
    }

    public static void main(String[] args) {
        StringBuilder res = new StringBuilder();
        res.append(1);
        res.append(1);
        System.out.println(res.toString().equals(res.reverse().toString()));
    }
}
