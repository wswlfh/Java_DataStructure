package com;

import java.util.Scanner;

public class Code {

    public int[] twoSum1(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int key = target - numbers[i];
            int l = i + 1;
            int r = numbers.length - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (numbers[mid] == key)
                    return new int[]{i + 1, mid + 1};
                if (numbers[mid] < key)
                    l = mid + 1;
                else
                    r = mid - 1;
            }
        }
        return null;
    }

    public int[] twoSum2(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;
        while (l < r) { //有效区间
            if (numbers[l] + numbers[r] > target)
                r--;
            else if (numbers[l] + numbers[r] < target)
                l++;
            else
                return new int[]{l + 1, r + 1};
        }
        return null;
    }



    public static void main(String[] args) {

    }
}
