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
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
        }
        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    //Solution2：似快排思路：从前向后遍历，维护[0，k]为非零的元素
    public void moveZeroes2(int[] nums) {
        int k = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                k++;
                nums[k] = nums[i];
                if (k != i) nums[i] = 0; //当i不等于k，意味着这个不为0的数的位置可以替换为0（因为用不着了）
            }
        }
    }

}

