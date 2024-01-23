package com._leetcode.L1__L100;

public class L8 {
    public static int myAtoi(String s) {
        //1.去前导空格
        s = s.trim();
        //Sp
        if (s.length() == 0)
            return 0;

        //2.取符号位
        StringBuilder sb = new StringBuilder();
        int flag = 1;
        char c = s.charAt(0);
        if (c == '-') flag = -1;
        else if (c == '+');
        else if (c >= '0' && c <= '9') sb.append(c);
        else return 0;

        //3.取数字
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9')
                sb.append(s.charAt(i));
            else break;
        }

        //4.转换
        String res = sb.toString();
        long sum = 0;
        for (int i = res.length() - 1, j = 0; i >= 0; i--, j++) {
            sum += (res.charAt(i) - '0') * Math.pow(10, j);
            //5. 判断
            if (sum >= (long) Integer.MAX_VALUE + 1)
                break;
        }

        sum = flag * sum;
        if (sum > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        if (sum < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        return (int) sum;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("42"));
    }
}
