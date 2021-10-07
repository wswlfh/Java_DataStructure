package com._leetcode.L1__L100;

import java.util.Arrays;

public class L80 {

    //Solution1：双指针 slow和fast
    //fast用于向后遍历检查元素，slow用于定标
    //一开始让fast与slow都为2，即从第三个元素开始，因为前两个元素组成的子数组一定满足要求
    //因为每个元素最多能存在两个，所以slow所占的位置，是默认前面两个元素满足条件(即nums[slow-2] <= nums[slow-1])
    //也就是说，slow所指向的位置，需要用来置放一个新元素，这个元素必须满足nums[slow]!=nums[slow-2],因为不能出现三个相等元素
    //所以fast向后遍历，如果遇到nums[fast]!=nums[slow-2],就可以将slow指元素换成fast所指，然后一起前进一步
    //如果遇到严格的有序数组，slow和fast就一起前进到末尾
    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 2)
            return nums.length;
        int slow = 1, fast = 1;
        while (fast < nums.length) {
            if (nums[slow - 1] != nums[fast]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 3};
        System.out.println(removeDuplicates(arr));
        //一行打印数组
        System.out.println(Arrays.toString(arr));
    }
}
