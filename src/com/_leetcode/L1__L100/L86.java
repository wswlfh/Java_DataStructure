package com._leetcode.L1__L100;

import com._leetcode.ListNode;

import java.util.HashMap;

public class L86 {
    //Solution1：递归
    //           将链表分成两部分，头结点 + 非头结点
    //           整个递归就可以看作为：partition{head + partition{head.next + ....}}
    //           直接假设partition()已经完成了链表分隔的算法，然后考虑返回的新头结点怎么和现有节点对接即可
    //              设经过partition()后返回的头结点为r，然后确定当前节点head应该怎么插入r
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        ListNode r = partition(head.next, x);
        if (head.val < x || r.val >= x) { //r.val >= x 很重要
            head.next = r;
            return head;
        }
        ListNode cur = r;
        while (cur.next != null && cur.next.val < x) {
            cur = cur.next;
        }
        head.next = cur.next;
        cur.next = head;
        return r;
    }

    // Solution2：非递归
    //          引进节点l，用以表示链表中 最后一个小于x的节点
    //              即 [head,l]部分的节点的值小于x，[l+1,tail]的节点值大于等于x
    //              接下来就是遍历链表，如果发现值小于x的节点，就插入到l后面，然后让它成为l，并删除原来的节点完善后续对接
    //                  具体操作 观察cur.next节点，如果符合条件，就删除并承接其next，然后生成一个新节点值为该节点值
    //                  关键在于 如何确定l的位置以及cur与l之间可能的存在的冲突
    public static ListNode partition2(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        ListNode l = head.val < x ? head : null;
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.next.val < x && cur.next != l) { //cur.next != l 很重要
                int val = cur.next.val;
                //删除节点
                ListNode next = cur.next;
                cur.next = next.next;
                next.next = null;
                //节点 "移动"到l后边
                ListNode node;
                if (l == null) {
                    node = new ListNode(val, head);
                    head = node;
                } else {
                    node = new ListNode(val, l.next);
                    l.next = node;
                }
                l = node;
            } else
                cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {
    }
}
