package com._leetcode.L1801_L2000;

import java.util.HashSet;

public class L1935 {
    public static int canBeTypedWords(String text, String brokenLetters) {
        String[] words = text.split(" ");
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < brokenLetters.length(); i++) {
            set.add(brokenLetters.charAt(i));
        }
        int ans = words.length;
        for (String word : words){
            for (int i = 0; i < word.length(); i++) {
                if (set.contains(word.charAt(i))) {
                    ans--;
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        canBeTypedWords("leet code","lt");
    }
}
