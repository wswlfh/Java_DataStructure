package com._leetcode.L1__L100;

import java.util.*;

public class L49 {
    //Solution：Map  (String,List)
    //          将异位词统一为一个key：把每个单词转为数组排序然后再转为String
    //          同key的添加到同一个list
    //          遍历Map将list全拿出来汇总
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            //用排序后的字符串作key，就解决分配问题了
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);

            List<String> temp = map.containsKey(key) ? map.get(key) : new LinkedList<>();
            temp.add(s);
            map.put(key, temp);
        }

        List<List<String>> ans = new LinkedList<>();
        for (String key : map.keySet()) {
            ans.add(map.get(key));
        }
        return ans;
    }

//    private List<Integer> getkey(String s) {
//        ArrayList<Integer> key = new ArrayList<>(0);
//        for (int i = 0; i < 26; i++) {
//            key.add(0);
//        }
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            key.set(c - 'a', key.get(c - 'a') + 1);
//        }
//        return key;
//    }

    public static void main(String[] args) {
        new L49().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    }
}
