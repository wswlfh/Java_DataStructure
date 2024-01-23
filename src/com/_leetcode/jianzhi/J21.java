package com._leetcode.jianzhi;

public class J21 {
    //Solution：双指针法，维护第一个偶数和最后一个奇数
    // 如果最后一个奇数位置在第一个偶数位置之前，说明已经完成划分
    // 问：
    //  是否可以使用额外存储空间？有的话使用两个队，各自存放结果然后拼接即可
    //  是否需要保持原有顺序？
    public int[] exchange(int[] nums) {
        if (nums == null || nums.length == 1)
            return nums;
        int firstE = 0, lastO = nums.length - 1;
        while (lastO > firstE) {
            if (nums[firstE] % 2 != 0) firstE++;
            else if (nums[lastO] % 2 != 1) lastO--;
            else {
                int t = nums[firstE];
                nums[firstE] = nums[lastO];
                nums[lastO] = t;
                firstE++;
                lastO--;
            }
        }
        return nums;
    }
}
