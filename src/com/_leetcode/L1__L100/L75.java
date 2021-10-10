package com._leetcode.L1__L100;

import java.util.ArrayList;
import java.util.Arrays;

public class L75 {
    /*
    75. 颜色分类
    红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
    此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
     */
    //Solution1：直接排序法
    public void sortColors(int[] nums) {
        if (nums.length <= 1)
            return;
        Arrays.sort(nums);
    }

    //Solution2：统计法，遍历一次扫描所有元素统计个数，然后还原
    public static void sortColors2(int[] nums) {
        int[] count = new int[3];
        for (int i = 0; i < nums.length; i++)
            count[nums[i]]++;

        int k = 0;
        for (int i = 0; i < 3; i++) {
            while (count[i] != 0) {
                nums[k++] = i;
                count[i]--;
            }
        }
    }

    //Solution3: 一次三路快排
    public static void sortColors3(int[] nums) {
        int zeros = -1; //0的区间 [0,zeros] 初值为-1
        int two = nums.length; //2的区间 [two,num.length-1] 初值为nums.length
        int i = 0; //扫描游标
        while (i < two) {
            if (nums[i] == 2) {
                two--;
                nums[i] = nums[two];
                nums[two] = 2;
                //这里不能加1的原因是，跟num[i]和nums[two]置换回来的元素可能为0，还能加入[0,zeros]中，此时不能动i，还需要判断
            } else if (nums[i] == 0) {
                zeros++;
                nums[i] = nums[zeros];
                nums[zeros] = 0;
                i++;  //这里加1是因为，跟zeros所指的元素换过来的，肯定不能加回[0,zeros]了
                //如果不加1，会导致i一直滞留，直至num[i]=1时才动，这时候zeros和two早已移动多次，整个数组已被打乱
            } else {
                assert nums[i] == 1;
                i++;
            }
        }
    }


    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors3(nums);
        System.out.println(Arrays.toString(nums));
    }
}
