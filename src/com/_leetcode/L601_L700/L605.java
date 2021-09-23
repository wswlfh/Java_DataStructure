package com._leetcode.L601_L700;

public class L605 {
    //605. 种花问题
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0)
            return true;
        if (flowerbed.length == 1)
            return flowerbed[0] == 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (i == 0) {
                if (flowerbed[i] == 1)
                    flowerbed[i + 1] = flowerbed[i] = -1;
            } else if (i == flowerbed.length - 1) {
                if (flowerbed[i] == 1)
                    flowerbed[i - 1] = flowerbed[i] = -1;
            } else {
                if (flowerbed[i] == 1) {
                    flowerbed[i - 1] = flowerbed[i] = flowerbed[i + 1] = -1;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < flowerbed.length ; i++) {
            if (i == flowerbed.length -1 && flowerbed[i] == 0)
                count++;
            else if (flowerbed[i] == 0) {
                count++;
                flowerbed[i + 1] = flowerbed[i] = -1;
            }
        }
        return n <= count;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,0,0,1,0,0};
        canPlaceFlowers(nums,2);
    }
}
