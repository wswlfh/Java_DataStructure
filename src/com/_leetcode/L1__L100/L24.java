package com._leetcode.L1__L100;

import com._leetcode.ListNode;

public class L24 {
    //Solution:递归
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode node = swapPairs(head.next.next);
        int temp = head.val;
        head.val = head.next.val;
        head.next.val = temp;
        head.next.next = node;

        return head;
    }
}
