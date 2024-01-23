package com._leetcode.L701_L800;

public class L788 {
    public int rotatedDigits(int n) {
        // 2 5 6 9
        // 0 1 8
        // 3 4 7
        int ans = 0;
        for (int i = 0; i <= n; i++) {
            String s = String.valueOf(i);
            if (s.contains("3") || s.contains("4") || s.contains("7")) continue;
            if (s.contains("2") || s.contains("5") || s.contains("6") || s.contains("9")) ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new L788().rotatedDigits(10));
    }
}
