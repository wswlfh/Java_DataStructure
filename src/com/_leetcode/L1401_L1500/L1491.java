package com._leetcode.L1401_L1500;

public class L1491 {
    public static double average(int[] salary) {
        double sum = 0;
        int min = 1000000, max = -1;
        for (int i = 0; i < salary.length; i++) {
            sum += salary[i];
            min = Math.min(salary[i], min);
            max = Math.max(salary[i], max);
        }
        return (sum - min - max) / (salary.length - 2);
    }

    public static void main(String[] args) {
        int[] arr = {4000,3000,1000,2000};
        average(arr);
    }
}
