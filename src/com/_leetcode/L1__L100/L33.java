package com._leetcode.L1__L100;

public class L33 {
    //Solution1：半步二分
    public int search(int[] nums, int target) {
        int i;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] == target)
                return i;
            if (i != nums.length - 1 && nums[i] > nums[i + 1])
                break;
        }
        int l = i + 1;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target)
                l = mid + 1;
            else r = mid - 1;
        }
        return -1;
    }

    //Solution2：全二分：注意num[0]、num[mid]、num[n-1]之间的关系

}
