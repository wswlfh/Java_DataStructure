package com._leetcode.L2001_L2300;

import com.Main;
import com._leetcode.ListNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class L2058 {

    //Soluton1：找出临界点不难，重点是怎么获取临界点之间的最值
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int index = 0;
        ListNode cur = head.next;
        ListNode prevNode = head;

        int min = 0;
        int count = 0;
        int firstIndex = 0;
        int lastIndex = 0;
        while (cur.next != null) {
            ListNode nextNode = cur.next;

            if ((cur.val < prevNode.val && cur.val < nextNode.val) ||
                    (cur.val > prevNode.val && cur.val > nextNode.val)) {
                count++;
                if (count == 1)
                    firstIndex = index;
                else if (count == 2)
                    min = index - firstIndex;
                else if (count > 2 && min != 1)
                    min = Math.min(min, index - lastIndex);
                lastIndex = index;
            }
            prevNode = cur;
            cur = cur.next;
            index++;
        }

        if (count < 2)
            return new int[]{-1, -1};
        int max = lastIndex - firstIndex;

        return new int[]{min, max};
    }



}
