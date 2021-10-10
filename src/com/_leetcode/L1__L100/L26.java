package com._leetcode.L1__L100;

import java.util.Arrays;

public class L26 {

    //双循环暴力法 ： 需要不断移动
    private static int removeDuplicates(int[] nums) {
        int l = 0, r = nums.length - 1, cur, temp = 0;
        cur = 1;
        while (l < r) {
            if (nums[l] == nums[cur]) {
                for (int i = cur; i < r; i++) {
                    temp = cur;
                    nums[i] = nums[i + 1];
                }
                nums[r] = temp;
                r--;
            } else {
                l++;
                cur = l + 1;
            }
        }
        return r + 1;
    }

    //双指针法 : 一个定标slow，定在有效数组+1的位置[0,slow-1]是有效的，一个向后移动 fast
    //重点是 fast只管向后移动，不用再返回来
    private static int removeDuplicates2(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int fast = 1, slow = 1;
        while (fast < n) {
            if (nums[fast - 1] != nums[fast]) { //如果找到不重复的，就换回来
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    //
    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(L26.removeDuplicates2(arr));
        //一行打印数组
        System.out.println(Arrays.toString(arr));
    }

}
