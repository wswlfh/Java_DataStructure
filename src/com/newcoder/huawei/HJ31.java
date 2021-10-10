package com.newcoder.huawei;

import java.util.Scanner;

public class HJ31 {

    public static class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();

            StringBuilder res = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z'
                        || s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'
                        || s.charAt(i) == ' ')
                    res.append(s.charAt(i));
                else
                    res.append(" ");
            }
            String ans = res.toString();

            String[] words = ans.split(" ");
            for (int i = words.length - 1; i >= 0; i--) {
                System.out.printf(words[i]);
                if (i != 0)
                    System.out.printf(" ");
            }
        }
    }
}
