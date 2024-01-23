package com._leetcode.jianzhi;

import java.util.Arrays;

public class J17 {
    //Solution：大数打印，模拟字符串加一,抹零输出
    public void printNumbers(int n) {
        char[] s = new char[n + 1];
        Arrays.fill(s, '0');
        while (true) {
            //字符串模拟计算整数加一
            plus1(s, n);
            if (s[0] == '1') break;
            else
                printNo0(s);
        }

    }

    private void printNo0(char[] s) {
        int start = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] != '0') {
                start = i;
                break;
            }
        }
        if (start == 0) return;
        for (int i = start; i < s.length; i++) {
            System.out.print(s[i] + "");
        }
        System.out.print(" ");
    }

    private void plus1(char[] s, int index) {
        assert index >= 0 && '0' <= s[index] && s[index] <= '9';
        if (s[index] == '9') {
            s[index] = '0';
            plus1(s, index - 1);
        } else s[index] = (char) (s[index] + 1);
    }


    public static void main(String[] args) {
        new J17().printNumbers(10);
    }
}
