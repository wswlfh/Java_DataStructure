package com._leetcode.L201__L300;

public class L268 {

    //Solution1：计数法
    public int missingNumber(int[] nums) {
        int[] count = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0)
                return i;
        }
        return 0;
    }

    //Solution2：异或法 ：a^b^a = b; a^b = c -> a^c = b；0^a = a;
    //将 0 异或[0,n-1] 完后 再异或 nums[0,n-1] 就能得到没有的那个数
    public int missingNumber2(int[] nums) {
        int res = 0;
        for (int i = 1; i <= nums.length; i++) {
            res ^= i;
            res ^= nums[i - 1];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(2 ^ 0);
    }
}
