package com._leetcode.L201__L300;

public class L283 {
    //283. 移动零
    //Solution1：两次遍历（不是二重遍历
    //第一次遍历将非零数都赋值到前面，就可以得出0与非0的个数
    //第二次遍历将数组的尾巴全部置为0
    //相当于 以数组自身当做一个新数组
    public void moveZeroes(int[] nums) {
        if (nums.length == 0 || nums.length == 1)
            return;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=0){
                nums[j] = nums[i];
                j++;
            }
        }
        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}

