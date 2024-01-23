package com._leetcode.jianzhi;

import java.util.HashMap;

public class J39 {
    // Solution：哈希表
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int v = map.getOrDefault(num, 0) + 1;
            if (v > nums.length / 2) return num;
            map.put(num, v);
        }
        return -1;
    }

    //Solution：摩尔投票法，又名极限一换一
    // 因为出现最多的元素出现了超过一半，可以设计这么一种算法：
    // 用count记录数某个nums[i]出现的次数，用result来存储nums[i]
    // 遍历数组，如果遇到自己就count++，遇到别的就count--，如果count减到0后就换下一个num[i]为result，count=1
    // 遍历完后，还剩下的result肯定是要找的元素
    public int majorityElement2(int[] nums) {
        int count = 1, result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == result)
                count++;
            else if (nums[i] != result && count > 0)
                count--;
            else if (nums[i] != result && count == 0) {
                result = nums[i];
                count = 1;
            }
        }
        return result;
    }


    //Solution：快排Partition
    //选中间nums[n/2]的数来进行partition，然后看其修正后的位置是不是还位于nums[n/2]
    //如果位置大于n/2，说明中位数在左边的部分，反之则在右边
    public int majorityElement3(int[] nums) {
        while (!partition(nums, nums[nums.length / 2])) ;
        return nums[nums.length / 2];
    }

    private boolean partition(int[] nums, int target) {
        int l = -1, r = nums.length;
        int i = 0;
        while (i < r) {
            if (nums[i] < target) {
                l++;
                swap(nums, l, i);
            } else if (nums[i] > target) {
                r--;
                swap(nums, r, i);
                continue;
            }
            i++;
        }
        return l + 1 <= nums.length / 2 && r - 1 >= nums.length / 2;
    }

    private void swap(int[] arr, int a, int b) {
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }
}
