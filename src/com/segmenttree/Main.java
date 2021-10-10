package com.segmenttree;

public class Main {
    public static void main(String[] args) {
        String s = "abbbabbbcabbbabbbc";
        Character[] chars = new Character[s.length()];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = s.charAt(i);
        }

        SegmentTree<Character> segmentTree = new SegmentTree<>(chars);

    }
}
