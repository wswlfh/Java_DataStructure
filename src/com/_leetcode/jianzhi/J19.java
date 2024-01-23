package com._leetcode.jianzhi;

public class J19 {
    public boolean isMatch(String s, String p) {
        int sp = 0, pp = 0;
        while (sp < s.length() && pp < p.length()) {
            if (p.charAt(pp) == '*') pp++;
            else {
                if (isStart(p, pp + 1)) {
                    //后面带*
                    while (p.charAt(pp) == '.' || s.charAt(sp) == p.charAt(pp)) {
                        sp++;
                        if (sp == s.length()) break;
                    }
                    pp++;
                } else {
                    //不带星
                    if (p.charAt(pp) == '.' || s.charAt(sp) == p.charAt(pp)) {
                        sp++;
                        pp++;
                    } else
                        return false;
                }
            }
        }
        for (int i = pp; i < p.length(); i++)
            if (p.charAt(i) != '*') return false;
        return sp == s.length();
    }

    private boolean isStart(String p, int index) {
        if (index >= p.length()) return false;
        return p.charAt(index) == '*';
    }
}
