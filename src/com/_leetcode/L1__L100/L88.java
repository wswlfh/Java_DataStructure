package com._leetcode.L1__L100;

import java.util.ArrayList;
import java.util.Arrays;

public class L88 {
    //Solution1：直接排序法
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m; i < m + n; i++) {
            nums1[i] = nums2[i - m];
        }
        Arrays.sort(nums1);
    }

    //Solution2：双指针法：考虑边界(又有逆双指针法)
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int[] res = new int[m + n];
        int p1 = 0, p2 = 0, cur = 0;
        while (p1 < m || p2 < n) {
            if (p1 == m)
                cur = nums2[p2++];
            else if (p2 == n)
                cur = nums1[p1++];
            else if (nums1[p1] >= nums2[p2])
                cur = nums1[p1++];
            else
                cur = nums2[p2++];
            res[p1 + p2 - 1] = cur; //这个 p1+p2-1 很妙
        }
        for (int i = 0; i < m + n; i++) {
            nums1[i] = res[i];
        }
    }

    //Solution3：链表法
    public static void merge3(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0, p2 = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while (p1 < m || p2 < n) {
            if (p1 == m) {
                list.add(nums2[p2]);
                p2++;
            } else if (p2 == n) {
                list.add(nums1[p1]);
                p1++;
            } else if (nums1[p1] <= nums2[p2]) {
                list.add(nums1[p1]);
                p1++;
            } else {
                list.add(nums2[p2]);
                p2++;
            }
        }
        for (int i = 0; i < list.size(); i++) {
            nums1[i] = list.get(i);
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        L88.merge(nums1, 3, nums2, 3);
    }
}
