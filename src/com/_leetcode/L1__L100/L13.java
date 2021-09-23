package com._leetcode.L1__L100;

import java.util.HashMap;

public class L13 {
    //13. 罗马数字转整数

    //Solution1：利用HashSet和双指针
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        if (s.length() == 1)
            return map.get(s.charAt(0));
        int i = 0, j = 1, ans = 0;
        while (j < s.length()) {
            if (map.get(s.charAt(i)) >= map.get(s.charAt(j))) //如果存在倒序，则置负
                ans += map.get(s.charAt(i));
            else
                ans -= map.get(s.charAt(i));
            i++;
            j++;
        }
        ans += map.get(s.charAt(i));
        return ans;
    }
}
