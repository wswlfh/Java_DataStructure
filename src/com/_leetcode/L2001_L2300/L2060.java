package com._leetcode.L2001_L2300;

import java.util.*;

public class L2060 {

    //超时 放弃... 123/215
    class Compare implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return o1.length() - o2.length();
        }
    }

    public boolean possiblyEquals(String s1, String s2) {
        if (isLetter(s1.charAt(0)) && isLetter(s2.charAt(0)) && s1.charAt(0) != s2.charAt(0))
            return false;
        PriorityQueue<String> qS1 = new PriorityQueue<>(new Compare());
        PriorityQueue<String> qS2 = new PriorityQueue<>(new Compare());
        gens(qS1, s1);
        gens(qS2, s2);


        HashSet<String[]> set = new HashSet<>();
        //找出共同长度的序列，set，然后比较是否同源

        while (!qS1.isEmpty() && !qS2.isEmpty()) {
            if (qS1.peek().length() == qS2.peek().length())
                set.add(new String[]{qS1.poll(), qS2.poll()});
            else if (qS1.peek().length() > qS2.peek().length())
                qS2.poll();
            else qS1.poll();
        }
        if (set.size() != 0)
            return sameRoot(set);
        return false;
    }


    private void gens(PriorityQueue<String> pq, String start) {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        map.put(start, 0);
        while (true) {
            Map.Entry<String, Integer> entry = map.entrySet().iterator().next();
            String s = entry.getKey();
            int index = map.get(s) >= s.length() ? 0 : map.get(s);
            int flag = 0;
            char[] chars = s.toCharArray();
            for (int i = index; i < chars.length; i++) {
                if (i + 2 < chars.length) {
                    if (isNumber(chars[i]) && isNumber(chars[i + 1])
                            && isNumber(chars[i + 2])) {
                        int count1 = Integer.parseInt(s.substring(i, i + 3));
                        map.put(insert(s, i, count1, 3), i + count1);

                        int count2 = Integer.parseInt(s.substring(i, i + 2));
                        int count3 = Integer.parseInt(s.substring(i + 2, i + 3));
                        map.put(insert(s, i, count2 + count3, 3), i + count2 + count3);

                        int count4 = Integer.parseInt(s.substring(i, i + 1));
                        int count5 = Integer.parseInt(s.substring(i + 1, i + 3));
                        map.put(insert(s, i, count4 + count5, 3), i + count4 + count5);

                        int count6 = Integer.parseInt(s.substring(i + 1, i + 2));
                        map.put(insert(s, i, count3 + count4 + count6, 3), i + count3 + count4 + count6);
                        i = i + 2;
                        flag = 1;
                        break;
                    }
                }

                if (i + 1 < chars.length) {
                    if (isNumber(chars[i]) && isNumber(chars[i + 1])) {
                        int count1 = Integer.parseInt(s.substring(i, i + 2));
                        map.put(insert(s, i, count1, 2), i + count1);
                        int count2 = Integer.parseInt(s.substring(i, i + 1));
                        int count3 = Integer.parseInt(s.substring(i + 1, i + 2));
                        map.put(insert(s, i, count2 + count3, 2), i + count2 + count3);
                        i = i + 1;
                        flag = 1;
                        break;
                    }
                }

                if (isNumber(chars[i])) {
                    int count = Integer.parseInt(s.substring(i, i + 1));
                    map.put(insert(s, i, count, 1), i + count);
                    flag = 1;
                    break;
                }
            }
            if (flag == 0)
                break;

            map.remove(s);
        }

        pq.addAll(map.keySet());

    }

    private boolean sameRoot(HashSet<String[]> set) {
        for (String[] ss : set) {
            int flag = 0;
            String s1 = ss[0];
            String s2 = ss[1];
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) != '*' && s2.charAt(i) != '*'
                        && s1.charAt(i) != s2.charAt(i)) {
                    flag = 1;
                    break;
                }
            }

            if (flag == 0)
                return true;
        }
        return false;
    }

    private boolean isLetter(char c) {
        return 'a' <= c && c <= 'z';
    }

    private boolean isNumber(char c) {
        return '1' <= c && c <= '9';
    }

    private String insert(String s, int index, int count, int len) {
        StringBuilder res1 = new StringBuilder(s);
        StringBuilder res2 = new StringBuilder();

        for (int i = 0; i < count; i++) {
            res2.append('*');
        }
        res1.delete(index, index + len);
        res1.insert(index, res2);
        return res1.toString();
    }

    public static void main(String[] args) {

        System.out.println(new L2060().possiblyEquals(
                "v375v736v443v897v633v527v781v121v317",
                "475v899v753v784v438v415v431v216v968"
        ));


    }
}
