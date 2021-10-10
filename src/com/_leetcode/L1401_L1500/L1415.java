package com._leetcode.L1401_L1500;

import java.util.LinkedList;
import java.util.List;

public class L1415 {
    LinkedList<String> ans;
    StringBuilder res;
    char[] key = {'a', 'b', 'c'};

    public String getHappyString(int n, int k) {
        ans = new LinkedList<>();
        res = new StringBuilder();
        int sum = 3 * (int) Math.pow(2, n - 1);
        int target = 0;
        if (k > sum)
            return "";
        if (k <= sum / 3) {
            res.append('a');
            target = k;
        } else if (k > sum / 3 && k <= 2 * sum / 3) {
            res.append('b');
            target = k - sum / 3;
        } else {
            res.append('c');
            target = k - 2 * sum / 3;
        }
        gens(n, target);
        return ans.getLast();
    }

    private void gens(int n, int target) {
        if (ans.size() == target || res.length() > n)
            return;

        if (res.length() == n) {
            ans.addLast(res.toString());
        }

        for (int i = 0; i < 3; i++) {
            if (res.charAt(res.length() - 1) != key[i]) {
                res.append(key[i]);
                gens(n, target);
                res.deleteCharAt(res.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        new L1415().getHappyString(10,100);
    }

}
