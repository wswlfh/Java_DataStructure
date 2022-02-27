package com._leetcode.L1__L100;

import java.util.*;

public class L15 {
    //Solution：排序+对撞指针
    public  List<List<Integer>> threeSum(int[] nums) {
        //使用set是为了保持插入的三元组不重复
        HashSet<List<Integer>> set = new HashSet<>();
        if (nums.length < 3)
            return new ArrayList<>();

        Arrays.sort(nums);
        //-4 -1 -1 0 1 2
        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1])
                continue;
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                List<Integer> last;
                if (nums[i] + nums[l] + nums[r] == 0) {
                    List<Integer> list = new LinkedList<>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    set.add(list);
                    l++;
                    r--;
                } else if (nums[i] + nums[l] + nums[r] > 0)
                    r--;
                else
                    l++;
            }
        }
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
    }
}
