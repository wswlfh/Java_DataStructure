package com._leetcode.L401_L500;

import com._leetcode.ListNode;

public class L445 {
    //Solution1:反转链表(206)+两数相加1(2)
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        //相加结果还需要反转一次
        ListNode newHead = new ListNode(-1);
        add(l1, l2, newHead, 0);
        return reverse(newHead.next);
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    private void add(ListNode l1, ListNode l2, ListNode cur, int carry) {
        if (l1 == null && l2 == null && carry == 0) return;
        int n1 = l1 == null ? 0 : l1.val;
        int n2 = l2 == null ? 0 : l2.val;
        cur.next = new ListNode((n1 + n2 + carry) % 10, cur.next);
        add(l1 == null ? null : l1.next, l2 == null ? null : l2.next,
                cur.next, (n1 + n2 + carry) / 10);
    }

}
