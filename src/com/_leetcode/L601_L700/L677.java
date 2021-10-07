package com._leetcode.L601_L700;

import java.util.TreeMap;

public class L677 {
    class MapSum {
        class Node {
            int val;
            TreeMap<Character, Node> next;

            Node() {
                val = 0;
                next = new TreeMap<>();
            }
        }

        private Node root;

        public MapSum() {
            root = new Node();
        }

        public void insert(String key, int val) {
            Node cur = root;
            for (int i = 0; i < key.length(); i++) {
                char c = key.charAt(i);
                if (cur.next.get(c) == null)
                    cur.next.put(c, new Node());
                cur = cur.next.get(c);
            }
            cur.val = val;
        }

        public int sum(String prefix) {
            Node cur = root;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                if (cur.next.get(c) == null)
                    return 0;
                cur = cur.next.get(c);
            }
            return sum(cur);
        }

        private int sum(Node node) {
            int res = 0;
            res += node.val;

            for (char nextChar : node.next.keySet())
                res += sum(node.next.get(nextChar));

            return res;
        }
    }
}
