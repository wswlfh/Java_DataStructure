package com._leetcode.L201__L300;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class L260 {

    //Solution1：哈希map
    public int[] singleNumber(int[] nums) {
        //Arrays.sort(nums);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]))
                map.put(nums[i], map.get(nums[i]) + 1);
            else
                map.put(nums[i], 1);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int key : map.keySet()) {
            if (map.get(key) == 1) {
                list.add(key);
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }

    //Solution2：双链表
    public int[] singleNumber2(int[] nums) {
        ArrayList<Integer> blackList = new ArrayList<>(nums.length);
        ArrayList<Integer> ansList = new ArrayList<>(nums.length);

        for (int i = 0; i < nums.length; i++) {
            if (ansList.contains(nums[i])) {
                ansList.remove((Object) nums[i]);
                blackList.add(nums[i]);
                continue;
            }
            if (!blackList.contains(nums[i])) {
                ansList.add(nums[i]);
            }
        }

        int[] ans = new int[ansList.size()];
        for (int i = 0; i < ansList.size(); i++) {
            ans[i] = ansList.get(i);
        }

        return ans;
    }

    public int[] singleNumber3(int[] nums) {


        return null;
    }
    public static void main(String[] args) {
        new L260().singleNumber2(new int[]{1, 2, 1, 3, 2, 5});
    }
}
