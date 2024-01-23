package com;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class MicroSoft0826 {

    //对撞指针
    public int task1(String S) {
        int l = 0, r = S.length() - 1;
        int[] count = new int[26];
        for (int i = 0; i < S.length(); i++) {
            count[S.charAt(i) - 'a']++;
        }
        while (l < r) {
            if (count[S.charAt(l) - 'a'] % 2 == 0 && count[S.charAt(r) - 'a'] % 2 == 0 && isOk(count))
                return r - l + 1;

            if (S.charAt(l) == S.charAt(r) && count[S.charAt(l) - 'a'] % 2 != 0) {
                count[S.charAt(l) - 'a']--;
                l++;
            } else if (count[S.charAt(l) - 'a'] % 2 == 0 && count[S.charAt(r) - 'a'] % 2 == 0 && !isOk(count) ||
                    count[S.charAt(l) - 'a'] % 2 != 0 && count[S.charAt(r) - 'a'] % 2 != 0
            ) {
                count[S.charAt(l) - 'a']--;
                count[S.charAt(r) - 'a']--;
                l++;
                r--;
            } else if (count[S.charAt(l) - 'a'] % 2 != 0) {
                count[S.charAt(l) - 'a']--;
                l++;
            } else {
                count[S.charAt(r) - 'a']--;
                r--;
            }
        }
        return 0;
    }

    private boolean isOk(int[] count) {
        for (int j : count) {
            if (j % 2 == 1)
                return false;
        }
        return true;
    }

    public int task2(int[] A, int M) {
        //坐标为k的点的集合
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            HashSet<Integer> set = map.getOrDefault(A[i], new HashSet<>());
            set.add(i);
            map.put(A[i], set);
            max = Math.max(max, A[i]);
        }
        int ans = 1;
        for (int i = 0; i < A.length; i++) {
            HashSet<Integer> set = new HashSet<>();
            for (int x = A[i] + M; x <= max; x = x + M) {
                if (map.containsKey(x)) {
                    //自我经典
                    set.addAll(map.get(A[i]));
                    set.addAll(map.get(x));
                }
            }
            ans = Math.max(set.size(), ans);
        }
        return ans;
    }

    public int task3(int[] A, int[] B) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < A.length; i++) {
            list.add(Math.max(A[i], B[i]));
        }
        int ans = Integer.MAX_VALUE;
        for (int x : A) {
            if (!list.contains(x))
                ans = Math.min(x, ans);
        }
        for (int x : B) {
            if (!list.contains(x))
                ans = Math.min(x, ans);
        }
        for (int i = 1; i <= ans; i++) {
            if (!list.contains(i)) {
                ans = i;
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        //System.out.println(new MicroSoft0826().task1("zthtzh"));
        //System.out.println(new MicroSoft0826().task3(new int[]{1, 2, 5}, new int[]{1, 2, 5}));

        //System.out.println(new MicroSoft0826().task2(new int[]{-3, -2, 1, 0, 8, 7, 1}, 3));
        System.out.println(new MicroSoft0826().task2(new int[]{1, 2, 3, 4, 5, 6, 7}, 3));
    }
}
