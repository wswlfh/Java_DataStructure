package _leetcode.jianzhi;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.TreeSet;

public class J62 {
    private static int lastRemaining(int n, int m) {
        LinkedList<Integer> res = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            res.addLast(i);
        }
        int i = 0;
        while (res.size() != 1) {
            if (i >= res.size())
                i = 0;

            i = (i + m - 1) % res.size();
            res.remove(i);
        }
        return res.getFirst();
    }

    public static void main(String[] args) {
        System.out.println(J62.lastRemaining(88, 10));
    }
}
