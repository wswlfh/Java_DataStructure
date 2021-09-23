package com._leetcode.L101__L200;

import com._leetcode.ListNode;

import java.util.HashSet;

public class L160 {

    //Solution1：使用哈希链表法，先存入A，然后用B的逐个节点进行比对
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        HashSet<ListNode> hashSet = new HashSet<>();
        ListNode a = headA;
        while (a != null) {
            hashSet.add(a);
            a = a.next;
        }
        ListNode b = headB;
        while (b != null) {
            if (hashSet.contains(b)) //contains方法 可以对比hashcode从而判断是否为同一个节点
                return b;
            b = b.next;
        }
        return null;
    }

    //Solution2：双指针法：pA和pB分别指向表头，使得两指针共同移动到公共节点时，满足
    // a为A在公共节点之前的长度，b为B在公共节点之前的长度，c为公共长度
    // a + c + b (pA跳跃到B表头) = b + c + a (pB跳跃到A表头)
    // 如果有 a==b 则在共同前进到c时跳出循环
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB){
            pA = (pA == null) ? headB : pA.next;
            pB = (pB == null) ? headA : pB.next;
        }
        return pA;
    }


    public static void main(String[] args) {

        System.out.println();
    }
}
