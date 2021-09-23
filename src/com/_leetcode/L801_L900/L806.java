package com._leetcode.L801_L900;

public class L806 {
    //806. 写字符串需要的行数
    public static int[] numberOfLines(int[] widths, String s) {
        //a b c d e f g h i j
        //k l m n o p q r s t
        //u v w x y z
        int[][] sum = new int[101][1];
        int row = 1;
        for (int i = 0; i < s.length(); i++) {
            if (sum[row][0] + widths[s.charAt(i) - 'a'] > 100)
                row++;
            sum[row][0] += widths[s.charAt(i) - 'a'];
        }

        int[] ans = {row,sum[row][0]};
        return ans;
    }

    public static void main(String[] args) {
        int[] widths = {
                4,10,10,10,10,
                10,10,10,10,10,
                10,10,10,10,10,
                10,10,10,10,10,
                10,10,10,10,10,10
        };
        L806.numberOfLines(widths,"bbbcccdddaaa");
    }
}
