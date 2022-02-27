package com._leetcode.L301_L400;

import com._leetcode.ListNode;

public class L328 {
    //Solution：简单的节点拼接
    //          只需要移动奇数节点即可，偶数节点在奇数节点被移走之后会自动接上
    //          移动节点方法：cur为基准，删除cur.next节点，接上后边；建立新节点，插到odd后面
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode odd = head, cur = head.next;
        while (cur != null && cur.next != null) { //既要判断cur又要判断cur.next 是因为链表中元素数量可能为奇数和偶数
            int val = cur.next.val;
            cur.next = cur.next.next;
            ListNode node = new ListNode(val, odd.next);
            odd.next = node;
            odd = node;
            cur = cur.next;
        }
        return head;
    }
}
