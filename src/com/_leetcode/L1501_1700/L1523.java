package com._leetcode.L1501_1700;

public class L1523 {
    public int countOdds(int low, int high) {
        int ans = 0;
        //超时
//        for (int i = low; i <= high; i++) {
//            if (i % 2 != 0)
//                ans++;
//        }
        //找出规律即可
        ans = (high - low + 1) / 2;
        if (low % 2 != 0 && high % 2 != 0)
            ans++;
        return ans;
    }
}
