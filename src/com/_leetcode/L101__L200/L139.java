package com._leetcode.L101__L200;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class L139 {
    //Solution：记忆化搜索，完全背包
    HashMap<String, Boolean> map = new HashMap<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        return search("", s, wordDict);
    }

    private boolean search(String x, String s, List<String> wordDict) {
        if (x.length() > s.length() || s.lastIndexOf(x) == -1) return false;
        if (x.equals(s)) return true;
        if (map.containsKey(x)) return map.get(x);
        boolean res = false;
        for (int i = 0; i < wordDict.size(); i++) {
            res = res || search(x + wordDict.get(i), s, wordDict);
        }
        map.put(x, res);
        return res;
    }

    public static void main(String[] args) {
    }
}
