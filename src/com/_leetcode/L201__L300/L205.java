package com._leetcode.L201__L300;

import java.util.HashMap;

public class L205 {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;

        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            if (!map.containsKey(cs) && !map.containsValue(ct))
                map.put(cs, ct);
            else if (!map.containsKey(cs) && map.containsValue(ct))
                return false;
            else if (map.containsKey(cs) && map.get(cs) != ct) {
                return false;
            }
        }
        return true;
    }
}
