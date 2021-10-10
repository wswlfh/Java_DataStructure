package com;

public class BinarySearch {
    int binarySearch(int[] arr, int n, int target) {
        // 在arr[l...r]之中查找target
        int l = 0, r = n - 1;
        while (l <= r) {
            //int mid = (l + r)/2;
            // 防止极端情况下的整形溢出，使用下面的逻辑求出mid
            int mid = l + (r - l) / 2;

            if (arr[mid] == target)
                return mid;

            if (arr[mid] > target)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return -1;
    }
}
