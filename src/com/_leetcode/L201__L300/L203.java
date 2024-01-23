package com._leetcode.L201__L300;

import com._leetcode.ListNode;

public class L203 {
    //Solution1： 虚拟头结点
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.val == val)
                prev.next = prev.next.next;
//            if (prev.next == null) break;
//            prev = prev.next.val == val ? prev : prev.next;
            else //引出一个else即可，如果不等才让它next下去
                prev = prev.next;
        }
        return dummyHead.next;
    }

    //Solution2：递归
    public ListNode removeElements2(ListNode head, int val) {
        if (head == null)  //不用判断head.next == null 的情况,因为会递归到head == null
            return null;
        ListNode res = removeElements2(head.next, val);
        if (head.val == val) {
            return res;
        }
        head.next = res;

        return head;
    }

}
