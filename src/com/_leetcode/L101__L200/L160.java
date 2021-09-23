package com._leetcode.L101__L200;

import com._leetcode.ListNode;

public class L160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        ListNode a = headA;
        ListNode b = headB;
        while (a.next != null) {
            a = a.next;
        }
        while (b.next != null) {
            b = b.next;
        }
        if (a != b) return null;
        while (a == b && a !=null) {
            a = findPrev(headA, a);
            b = findPrev(headB, b);
        }
        return a.next;
    }

    private ListNode findPrev(ListNode head, ListNode tail) {
        if (head == tail) return head;
        while (head.next != null) {
            if (head.next == tail)
                return head.next;
            head = head.next;
        }
        return null;
    }


    public static void main(String[] args) {

        System.out.println();
    }
}
