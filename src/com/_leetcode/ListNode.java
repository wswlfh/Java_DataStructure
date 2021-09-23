package com._leetcode;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
    public ListNode buildList(int[] nums) {
        ListNode dummyHead = new ListNode(-1);
        for (int i = 0; i < nums.length; i++) {
            ListNode node = new ListNode(nums[i]);
            node.next = dummyHead.next;
            dummyHead.next = node;
        }
        return dummyHead.next;
    }
}
