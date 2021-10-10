package com.newcoder.huawei;

import java.util.*;

public class HJ2 {
    //HJ2 计算某字母出现次数
    public static class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine().toLowerCase();
            char key = scanner.nextLine().toLowerCase().charAt(0);
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == key)
                    count++;
            }

            System.out.println(count);
        }
    }
}
