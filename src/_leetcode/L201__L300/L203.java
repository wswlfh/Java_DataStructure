package _leetcode.L201__L300;

import _leetcode.ListNode;

public class L203 {
    //Solution1： 虚拟头结点
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        while (prev.next!= null) {
            if (prev.next.val == val) {
                ListNode cur = prev.next;
                prev.next = cur.next;
                cur.next = null;
            }
            else
                prev = prev.next;
        }
        return dummyHead.next;
    }

    //Solution2：递归
    public ListNode removeElements2(ListNode head, int val) {
        if (head == null)
            return null;
        ListNode res = removeElements2(head.next,val);
        if (head.val == val){
            return res;
        }
        head.next = res;
        return head;
    }
}
