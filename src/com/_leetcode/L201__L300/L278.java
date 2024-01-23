package com._leetcode.L201__L300;

public class L278 {

    boolean isBadVersion(int version) {
        return false;
    }

    //找中点，然后判断其相邻
    public int firstBadVersion(int n) {
        int l = 1, r = n;

        if (isBadVersion(1))
            return 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (isBadVersion(mid)) {
                if (mid - 1 >= 1 && !isBadVersion(mid - 1))
                    return mid;
                r = mid - 1;
            } else {
                if (mid + 1 <= n && isBadVersion(mid + 1))
                    return mid + 1;
                l = mid + 1;
            }
        }
        return -1;
    }
}
