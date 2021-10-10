package com._leetcode.mianshi;

import java.util.LinkedList;
import java.util.List;

public class M0807 {
    boolean[] used;
    StringBuilder res = new StringBuilder();
    int count = 0;
    String[] ans;
    //List<String> ans = new LinkedList<>();

    public String[] permutation(String S) {
        used = new boolean[S.length()];
        int sum = 1;
        for (int i = 1; i <= S.length(); i++) {
            sum *= i;
        }
        ans = new String[sum];
        gens(S);

        return ans;
    }

    private void gens(String S) {
        if (res.length() == S.length()) {
            ans[count] = res.toString();
            count++;
            return;
        }
        for (int i = 0; i < S.length(); i++) {
            if (!used[i]) {
                used[i] = true;
                res.append(S.charAt(i));
                gens(S);
                res.deleteCharAt(res.length() - 1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new M0807().permutation("hzxEfXdb"));
    }
}
