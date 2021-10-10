package com._leetcode.L601_L700;

public class L640 {

    //Solution：关键在于将 -替换为+-,以=分割开左右两部分，分别计算 x 和 整数部分的值，然后比较左右两部分即可
    public static String solveEquation(String equation) {
        int[] k = {0, 0};
        int[] res = {0, 0};
        StringBuilder sb = new StringBuilder(equation);
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '-') {
                sb.insert(i, '+');
                i++;
            }
        }

        String[] ss = sb.toString().split("=");
        String[] left = ss[0].split("[+]");
        String[] right = ss[1].split("[+]");

        String[] temp = left;
        for (int i = 0; i < 2; i++) {
            for (String word : temp) {
                if (word.equals(""))
                    continue;
                StringBuilder builder = new StringBuilder(word);
                int flag = 1;
                if (builder.charAt(0) == '-') {
                    flag = -1;
                    builder.deleteCharAt(0);
                }

                if (builder.charAt(builder.length() - 1) == 'x') {
                    builder.deleteCharAt(builder.length() - 1);
                    k[i] += builder.length() == 0 ? flag : flag * Integer.parseInt(builder.toString());
                } else
                    res[i] += flag * Integer.parseInt(builder.toString());

            }
            temp = right;
        }
        int leftRes = k[0] - k[1];
        int rightRes = res[1] - res[0];
        if (leftRes == 0 && rightRes == 0)
            return "Infinite solutions";
        if (leftRes == 0 && rightRes != 0)
            return "No solution";

        return "x=" + rightRes / leftRes;
    }

    public static void main(String[] args) {
        System.out.println(solveEquation("-x=-1"));

    }
}
