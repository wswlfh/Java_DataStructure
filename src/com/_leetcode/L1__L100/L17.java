package com._leetcode.L1__L100;

import java.util.ArrayList;
import java.util.List;

public class L17 {
    //17.电话号码的字母组合

    //Solution1：使用回溯法
    //可以看成树形问题,即为寻找叶子节点的过程
    //达到叶子节点时，已经递归到最深处，这时候要把结果放进容器，然后回到原来调用递归的状态
    // 即 a -> ad -> a ->ae -> a -> af    不断从既得结果中回退称为回溯
    //          a         b          c          2
    //        d e f     d e f      d e f        3
    //      ad ae af   bd be bf   cd ce cf      res
    StringBuilder res;
    String[] letters = {
            "",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        res = new StringBuilder();
        if (!digits.equals(""))
            gens(digits, 0, list);
        return list;
    }

    private void gens(String digits, int index, List<String> list) {
        if (index == digits.length()) {
            list.add(res.toString());
            return;
        }
        String letter = letters[digits.charAt(index) - '0'];
        if (letter.equals(""))
            return;

        //经典回溯法 回来记得处理
        for (int i = 0; i < letter.length(); i++) {
            res.append(letter.charAt(i));
            gens(digits, index + 1, list);
            res.deleteCharAt(res.length() - 1);
        }
    }

    public static void main(String[] args) {
        new L17().letterCombinations("23");
    }
}
