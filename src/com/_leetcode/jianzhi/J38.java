package com._leetcode.jianzhi;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class J38 {
    //Solution：回溯 全排列
    // 特别需要注意的点：调用回溯的时候需不需要加循环？否 进入和撤出是否在同一个循环？是 是否需要index？ 否
    Set<String> res = new HashSet<>();
    StringBuilder sb = new StringBuilder();
    boolean[] visited;

    public String[] permutation(String s) {
        visited = new boolean[s.length()];
        char[] chars = s.toCharArray();
        fb(chars);

        return res.toArray(new String[0]);
    }

    private void fb(char[] chars) {
        if (sb.length() == chars.length) {
            res.add(sb.toString());
            return;
        }
        for (int j = 0; j < chars.length; j++) {
            if (visited[j]) continue;
            visited[j] = true;
            sb.append(chars[j]);
            fb(chars);
            visited[j] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }


}
