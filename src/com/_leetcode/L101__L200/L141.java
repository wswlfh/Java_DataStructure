package com._leetcode.L101__L200;

import com._leetcode.ListNode;

import java.util.HashSet;

public class L141 {
    //141.环形链表

    //Solution1：哈希集合，从头遍历至环开头出，如果包含则说明有环
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;
        HashSet<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head)) //hashSet如果add成功与否都会返回Boolean值
                return true;
            head = head.next;
        }
        return false;
    }
}
