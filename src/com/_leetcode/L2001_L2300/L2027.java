package com._leetcode.L2001_L2300;

public class L2027 {
    public static int minimumMoves(String s) {
        int n = s.length();
        int count = 0;
        char[] chars = s.toCharArray();
        int i = 0;
        while(i < n){
            if(chars[i] == 'O') {
                i++;
                continue;
            }
            int k = 3;
            while(k > 0 && i < n){
                chars[i++] = 'O';
                k--;
            }
            count++;
        }
        return count;

    }

    public static void main(String[] args) {
        System.out.println(minimumMoves("OXXOXOXOOXOOXOXOOXOXXOOXOXXOOXOXXOXXXXOXX"));
    }
}
