package com._leetcode.jianzhi;

import com._leetcode.ListNode;

public class J22 {
    //Solution：双指针，要求只遍历一遍
    // 实际上返回的是链表中第n-k+1个节点
    // 快指针先走到第k个位置，然后还剩n-k个节点，然后慢指针才开始走,快指针走到尾时慢指针所在正是第n-k+1个节点
    //注意k取值及链表的个数
    public ListNode getKthFromEnd(ListNode head, int k) {
        //k为0的情况
        if (head == null || k == 0) return null;
        ListNode slow, fast;
        slow = fast = head;
        //快指针直接走到第k个位置，顺便解决k大于n的问题
        for (int i = 1; i < k; i++) {
            fast = fast.next;
            //出现k大于n的情况
            if (fast == null) return null;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
