package com._leetcode.L1__L100;

public class L27 {
    //27. 移除元素 (简单)

    //Solution: 返回剩余元素的长度且要改变nums的元素的位置
    //[3,2,2,3] 3 -> [2,2,0,0] 2
    //快排思路，维护[0,k]为不等于val的数
    public int removeElement(int[] nums, int val) {
        int k = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                k++;
                nums[k] = nums[i];
            }
        }
        return k + 1;
    }
}
