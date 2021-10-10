package com._leetcode.L201__L300;

import java.util.PriorityQueue;

public class L215 {
    /*
    215. 数组中的第K个最大元素
    给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
    请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素 ！！！ 指元素可以重复
     */

    //Solution1：优先队列法
    //维护前k个元素的秘诀：
    //如果队内元素达不到k个，就直接往里面塞
    //如果队内元素已到达k个，对于要加进来的元素，比较其与栈顶元素的大小(因为栈顶元素是最小的)，如果后进的比栈顶还大，则可以进来
    //维护第k大的元素，则栈顶就是第k大
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            if (pq.size() < k)
                pq.add(nums[i]);
            else if (pq.peek() < nums[i]) {
                pq.remove();
                pq.add(nums[i]);
            }
        }
        return pq.peek();
    }

    //Solution2：快排法
    //一次快排的思路：选中第k个元素，然后对其partition，返回该元素的实际位置，如果返回的为k，说明该元素已在正确的位置
    //因为含有重复元素，所以要返回这个元素的左右边界[l,r] 这才是其正确位置，判断 n-k 是否落在这个区间
    public int findKthLargest2(int[] nums, int k) {
        int n = nums.length;
        int[] res = partition(nums, nums[n - k]); // left: res[0], right: res[1]
        while (true) {
            if (res[0] <= n - k && n - k <= res[1]) break;
            if (res[1] < n - k)
                res = partition(nums, nums[res[1] + 1]);
            else if (n - k < res[0])
                res = partition(nums, nums[res[0] - 1]);
        }
        return nums[n - k];
    }

    private int[] partition(int[] nums, int target) {
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
        return new int[]{l + 1, r - 1};
    }

    private void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(new L215().findKthLargest2(nums, 4));
    }
}
