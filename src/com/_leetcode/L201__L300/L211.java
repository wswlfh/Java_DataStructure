package com._leetcode.L201__L300;

import java.util.TreeMap;

public class L211 {
    class WordDictionary {
        class Node {
            public TreeMap<Character, Node> next;
            boolean isWord;

            Node() {
                next = new TreeMap<>();
                isWord = false;
            }
        }

        private Node root;

        public WordDictionary() {
            root = new Node();
        }

        public void addWord(String word) {
            Node cur = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (cur.next.get(c) == null)
                    cur.next.put(c, new Node());
                cur = cur.next.get(c);
            }
            cur.isWord = true;
        }

        public boolean search(String word) {
            return match(root, word, 0);
        }

        private boolean match(Node node, String word, int index) {
            if (index == word.length())
                return node.isWord; //已经到末尾了，判断是前缀还是单词
            char c = word.charAt(index);
            if (c != '.') {
                if (node.next.get(c) == null)
                    return false;
                return match(node.next.get(c), word, index + 1);
            }
            for (Character next : node.next.keySet()) {
                if (match(node.next.get(next), word, index + 1))
                    return true;
            }
            return false;
        }

    }
}
