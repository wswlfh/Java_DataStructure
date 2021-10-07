package com._leetcode.L101__L200;

import java.util.Arrays;

public class L167 {
    //167. 两数之和 II - 输入有序数组

    //Solution1：暴力法
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            int e = target - numbers[i];
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] == e) {
                    ans[0] = i + 1;
                    ans[1] = j + 1;
                    return ans;
                } else if (numbers[j] > e)
                    break;
            }
        }
        return null;
    }

    //Solution2：二分法 注意2分的边界问题
    public static int[] twoSum2(int[] numbers, int target) {
        int[] ans = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            int e = target - numbers[i];
            int l = i + 1;
            int r = numbers.length - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (numbers[mid] < e)
                    l = mid + 1;
                else if (numbers[mid] > e)
                    r = mid - 1;
                else {
                    ans[0] = i + 1;
                    ans[1] = mid + 1;
                    return ans;
                }
            }
        }
        return null;
    }

    //Soultion3：对撞指针
    //l从头向后，r从后向前，计算 nums[l]+nums[r] 比较 target
    //如果偏小，就增加左边的值(l++)，如果偏大就减小右边的值(r--)
    //只遍历一次数组，复杂度O(n)
    public static int[] twoSum3(int[] numbers, int target) {
        assert (numbers.length >= 2);

        int l = 0, r = numbers.length - 1;
        while (l < r) {
            if (numbers[l] + numbers[r] == target)
                return new int[]{l + 1, r + 1};
            else if (numbers[l] + numbers[r] < target)
                l++;
            else  //numbers[l] + numbers[r] > target
                r--;
        }

        return null;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum2(nums, 9)));
    }

}
