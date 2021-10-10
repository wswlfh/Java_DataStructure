package com._leetcode.L801_L900;

import javax.xml.soap.SOAPElementFactory;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class L869 {

    //Solution1：使用回溯 进行排列 然后判断是否为2幂
    //判断方法：    double t = Math.log10(num) / Math.log10(2);
    //            if (t - (int) t == 0)

    StringBuilder res;
    LinkedList<Integer> ans;
    boolean[] used;

    public boolean reorderedPowerOf2_1(int n) {
        String s = String.valueOf(n);
//        for (int i = 0; i < s.length(); i++) {
//            if ((s.charAt(i) - '0') % 2 != 0 && s.charAt(i) - '0' != 1)
//                return false;
//        }
        res = new StringBuilder();
        ans = new LinkedList<>();
        used = new boolean[s.length()];
        gens(s);
        return ans.size() != 0;
    }

    private void gens(String s) {
        if (res.length() == 1 && (res.charAt(0) == '0'))
            return;
        if (res.length() == s.length()) {
            int num = Integer.parseInt(res.toString());
            System.out.println(num);
            double t = Math.log10(num) / Math.log10(2);
            if (t - (int) t == 0)
                ans.add(num);
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (!used[i]) {
                used[i] = true;
                res.append(s.charAt(i));
                gens(s);
                res.deleteCharAt(res.length() - 1);
                used[i] = false;
                if (ans.size() > 0)
                    return;
            }
        }
    }

    //Solution2: 使用预处理，先计算出 0~10^9 所有是2的幂的数，存入Set中
    //然后对n进行字符排序，将排序后的结果与Set中的元素作对比

    //另一变种方法 是对比 统计组成2的幂的数中每个位置的数的个数
    //如 1024 0有1个 1有1个 2有1个 4有一个  如果传入的数也保持这种性质，则满足

    public boolean reorderedPowerOf2_2(int n) {
        HashSet<String> set = new HashSet<>();
        for (int i = 1; i < 1e9; i <<= 1) {
            char[] chars = String.valueOf(i).toCharArray();
            Arrays.sort(chars);
            set.add(String.valueOf(chars));
        }
        char[] ans = String.valueOf(n).toCharArray();
        Arrays.sort(ans);
        if (set.contains(String.valueOf(ans)))
            return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new L869().reorderedPowerOf2_2(16));
    }

}
