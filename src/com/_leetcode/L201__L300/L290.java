package com._leetcode.L201__L300;

import java.util.HashMap;

public class L290 {
    //Solution：map
    //         拆分pattern和s，然后得到一一对应
    //          a   b   b   a   pats[]
    //         dog cat cat dog  ss[]
    // 从头开始 放入map
    //         如果k和v都不存在，则插入(k,v)
    //         如果k不存在，v存在，说明单词已经被占用，返回false，就是不存在(a,dog) (b,dog)的情况 dog已经被a占了
    //         如果k存在，对比即将插入的v和之前的v是否相等
    public  boolean wordPattern(String pattern, String s) {
        String[] pats = pattern.split("");
        String[] ss = s.split(" ");
        if (pats.length != ss.length)
            return false;
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < ss.length; i++) {
            boolean containsK = map.containsKey(pats[i]);
            boolean containsV = map.containsValue(ss[i]);
            if (!containsK && containsV)
                return false;
            if (!containsK) {
                map.put(pats[i], ss[i]);
                continue; //省去else的判断
            }
            //存在key，比较value是否一样
            if (!map.get(pats[i]).equals(ss[i]))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
