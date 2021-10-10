package com._leetcode.L1401_L1500;

import java.util.*;

public class L1436 {
    public String destCity(List<List<String>> paths) {

        HashMap<String, String> map = new HashMap<>();
        for (List<String> path : paths) {
            map.put(path.get(0), path.get(1));
        }
        HashSet<String> valueSet = new HashSet<>(map.values());
        Set<String> keySet = map.keySet();
        String ans = null;
        for (String key : valueSet){
            if (!keySet.contains(key)){
                ans = key;
                break;
            }
        }
//        while (set.size() != 1) {
//
//        }

        return ans;
    }
}
