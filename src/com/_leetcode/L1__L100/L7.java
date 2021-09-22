package com._leetcode.L1__L100;

public class L7 {
    //7. 整数反转 转成字符串 或 取模
    public int reverse(int x) {
        StringBuilder res = new StringBuilder();
        res.append(Math.abs(x));
        try {
            int t = Integer.parseInt(res.reverse().toString());
            return x > 0 ? t : -t;
        }catch (NumberFormatException e){
            e.printStackTrace();
        }
        return 0;
    }

    public static void main(String[] args) {
        L7 l7 = new L7();
        //System.out.println(l7.reverse(1534236469));
    }
}
