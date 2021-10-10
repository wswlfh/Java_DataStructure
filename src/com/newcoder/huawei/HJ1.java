package com.newcoder.huawei;

import java.util.Scanner;
import java.util.Stack;

public class HJ1 {
    public static class Main {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            String word = scanner.nextLine();
            String[] words = word.split(" ");
            System.out.println(words[words.length - 1].length());
        }
    }
}
