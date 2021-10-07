package com._leetcode.L1__L100;

import java.util.Arrays;
import java.util.Comparator;

public class L11 {
    //11. 盛最多水的容器

    /*Solution：双指针法，l、r分别为容器左右边界，初始l = 0,r = n - 1
    l和r向内靠拢，计算出最大容量 = (r-l) * min(height[r],height[l])
    重点：如果将l和r依次取所有值，会使得复杂度为n^2，会超时
    因为设最矮边界索引为X0，则面积 = |X-Xo| * height[Xo] ，这时如果保持X0不变，不管X向内移动到哪里
    |X-Xo|的值会越来越小，所以移动X所在指针是无用的，需要移动最矮边界的指针才能打破僵局
     */
    public static int maxArea(int[] height) {
        int maxArea = 0;
        int l = 0, r = height.length - 1;
        while (l < r) {
            if ((r - l) * Math.min(height[r], height[l]) > maxArea)
                maxArea = (r - l) * Math.min(height[r], height[l]);
            if (height[l] > height[r])
                r--;
            else
                l++;
        }
        return maxArea;
    }


    public static void main(String[] args) {
        int[] nums = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(nums));
    }
}
