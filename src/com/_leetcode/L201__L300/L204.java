package com._leetcode.L201__L300;

import java.util.*;

public class L204 {
    //204：计算质数，统计所有小于非负整数 n 的质数的数量。
    //Solution1：存质数入栈循环对比，超时
    public static int countPrimes(int n) {
        if (n <= 2)
            return 0;
        int j = 0;
        int count = 0;
        int[] list = new int[n / 2];
        list[0] = 2;
        list[1] = 3;
        count++;
        for (int i = 5; i < n; i = i + 2) {
            for (j = 0; j < count; j++) {
                if (i % list[j] != 0) {
                    if (list[j] > Math.pow(i, 0.5)) {
                        list[count] = i;
                        count++;
                        break;
                    } else
                        break;
                }
            }
        }
        System.out.println(Arrays.toString(list));
        return count;
    }

    //Solution2：枚举法，判断一个数是否为质数：只需要对[2,x^0.5]的数进行取模运算，
    // 如果遍历完模还不为0，说明此数为质数
    //复杂度 O(n * n^0.5),超时
    public static int countPrimes2(int n) {
        if (n == 0 || n == 1)
            return 0;
        int count = 1;
        for (int i = 3; i < n; i = i + 2) {
            if (isPrime(i))
                count++;
        }
        return count;
    }

    private static boolean isPrime(int x) {
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0)
                return false;
        }
        return true;
    }

    //Solution3：筛选法，设置一个标志位数组，标记元素是否为质数
    //此数组在遍历中不断完善，如遍历到i时，从i*i起，把i的倍数不断筛掉
    //这样在遍历到后面的数时，只要对比标志位就能知道是不是质数
    //复杂度 O(n log(log n))
    public static int countPrimes3(int n) {
        int[] isPrime = new int[n]; //默认为0
        Arrays.fill(isPrime, 1);
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i] == 1) count++;
            //这里不用long的话 i * i 就会超过最大整数溢出了
            if ((long) i * i < n) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = 0;
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {
        System.out.println(L204.countPrimes3(2));
    }
}
