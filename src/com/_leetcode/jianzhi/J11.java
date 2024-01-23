package com._leetcode.jianzhi;

public class J11 {
    //Solution: 二分查找，但要特别注意边界问题
    //维护三个指针，一个永远在高段，一个永远在低段，一个为二分指针
    //如果三个指针元素都相等，则无法判断，只能用顺序查找
    public int minArray(int[] numbers) {
        int l = 0, r = numbers.length - 1, mid = l;
        while (numbers[l] >= numbers[r]) {
            if (r - l == 1) {
                mid = r;
                break;
            }
            mid = l + (r - l) / 2;
            //三者相等，则顺序查找
            if (numbers[l] == numbers[r] && numbers[l] == numbers[mid]) {
                int res = numbers[l];
                for (int i = l; i <= r; i++) {
                    res = Math.min(numbers[i], res);
                }
                return res;
            }
            if (numbers[mid] >= numbers[l]) //落在高段,不加1是保证l一直位于高段
                l = mid;
            else if (numbers[mid] <= numbers[r])//落在低段,不加1是保证r一直位于低段
                r = mid;
        }
        return numbers[mid];
    }
}

