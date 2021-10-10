package com._leetcode.L1801_L2000;

public class L1829 {
    int[] res;

    public int[] getMaximumXor(int[] nums, int maximumBit) {
        res = new int[nums.length];
        res[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res[i] = nums[i] ^ res[i - 1];
        }

        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = getMax(nums.length - 1 - i, maximumBit);
        }
        return ans;
    }

    private int getMax(int index, int maximumBit) {
        int max = Integer.MIN_VALUE;
        int tmp = -1;
        for (int k = 0; k < (1 << maximumBit); k++) {
            if ((res[index] ^ k) > max) {
                max = res[index] ^ k;
                tmp = k;
            }
        }
        return tmp;
    }

    //Solution2：不管k取多少，最后异或的最大结果一定是 pow(2,maximumBit) - 1
    //即尽可能取最多的1就能保证结果最大，而根据异或的运算性质有 a^b = c -> a^c = b
    //所以根据，res[index]^k = pow(2,maximumBit) - 1 就有res[index] ^ (pow(2,maximumBit) - 1) = k
    //直接算出k即可
    public int[] getMaximumXor2(int[] nums, int maximumBit) {
        res = new int[nums.length];
        res[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res[i] = nums[i] ^ res[i - 1];
        }

        int max = (1 << maximumBit) - 1;

        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = res[nums.length - 1 - i] ^ max; //a^b = c -> a^c = b
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 1, 3};

        new L1829().getMaximumXor2(nums, 2);


    }
}
