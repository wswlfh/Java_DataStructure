package com._leetcode.L1101_L1200;

import java.util.TreeMap;

public class L1160 {
    /* 1160. 拼写单词
    给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
    假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
    注意：每次拼写（指拼写词汇表中的一个单词）时，chars 中的每个字母都只能用一次。
    返回词汇表 words 中你掌握的所有单词的 长度之和。
     */
    public static int countCharacters(String[] words, String chars) {
        TreeMap<Character, Integer> map = new TreeMap<>();
        for (int i = 0; i < chars.length(); i++) {
            int value = 1;
            if (map.containsKey(chars.charAt(i))) {
                value = map.get(chars.charAt(i)) + 1;
            }
            map.put(chars.charAt(i), value);
        }
        int ans = 0, temp = 0;
        TreeMap<Character, Integer> mapTemp;
        for (String word : words) {
            temp = 0;
            mapTemp = (TreeMap<Character, Integer>) map.clone();
            for (int i = 0; i < word.length(); i++) {
                if (mapTemp.containsKey(word.charAt(i))) {
                    char key = word.charAt(i);
                    int value = mapTemp.get(key);
                    if (value >= 1) {
                        mapTemp.replace(key, value - 1);
                        temp++;
                    }
                }else
                    break;
            }
            if (temp == word.length())
                ans += temp;
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] words1 = {"cat", "bt", "hat", "tree"};
        String chars1 = "atach";
        String[] words2 = {"dyiclysmffuhibgfvapygkorkqllqlvokosagyelotobicwcmebnpznjbirzrzsrtzjxhsfpiwyfhzyonmuabtlwin", "ndqeyhhcquplmznwslewjzuyfgklssvkqxmqjpwhrshycmvrb", "ulrrbpspyudncdlbkxkrqpivfftrggemkpyjl", "boygirdlggnh", "xmqohbyqwagkjzpyawsydmdaattthmuvjbzwpyopyafphx", "nulvimegcsiwvhwuiyednoxpugfeimnnyeoczuzxgxbqjvegcxeqnjbwnbvowastqhojepisusvsidhqmszbrnynkyop", "hiefuovybkpgzygprmndrkyspoiyapdwkxebgsmodhzpx", "juldqdzeskpffaoqcyyxiqqowsalqumddcufhouhrskozhlmobiwzxnhdkidr", "lnnvsdcrvzfmrvurucrzlfyigcycffpiuoo", "oxgaskztzroxuntiwlfyufddl", "tfspedteabxatkaypitjfkhkkigdwdkctqbczcugripkgcyfezpuklfqfcsccboarbfbjfrkxp", "qnagrpfzlyrouolqquytwnwnsqnmuzphne", "eeilfdaookieawrrbvtnqfzcricvhpiv", "sisvsjzyrbdsjcwwygdnxcjhzhsxhpceqz", "yhouqhjevqxtecomahbwoptzlkyvjexhzcbccusbjjdgcfzlkoqwiwue", "hwxxighzvceaplsycajkhynkhzkwkouszwaiuzqcleyflqrxgjsvlegvupzqijbornbfwpefhxekgpuvgiyeudhncv", "cpwcjwgbcquirnsazumgjjcltitmeyfaudbnbqhflvecjsupjmgwfbjo", "teyygdmmyadppuopvqdodaczob", "qaeowuwqsqffvibrtxnjnzvzuuonrkwpysyxvkijemmpdmtnqxwekbpfzs", "qqxpxpmemkldghbmbyxpkwgkaykaerhmwwjonrhcsubchs"};
        String chars2 = "usdruypficfbpfbivlrhutcgvyjenlxzeovdyjtgvvfdjzcmikjraspdfp";
        System.out.println(countCharacters(words2, chars2));
    }
}
