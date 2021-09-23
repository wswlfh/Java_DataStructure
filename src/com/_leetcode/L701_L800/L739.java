package com._leetcode.L701_L800;

import com._leetcode.L1__L100.L7;

import java.util.Arrays;
import java.util.Stack;

public class L739 {
    /*
    739. 每日温度
    请根据每日 气温 列表 temperatures ，请计算在每一天需要等几天才会有更高的温度。如果气温在这之后都不会升高，请在该位置用 0 来代替。
     */
    //暴力法：超时
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Arrays.fill(ans, -1);
        int round = 1;
        int index = 0;
        while (index >= 0) {
            for (int i = index; i < ans.length && i != -1; i = check(ans, i)) {
                if (i + round >= ans.length) {
                    ans[i] = 0;
                    break;
                } else if (temperatures[i] < temperatures[i + round])
                    ans[i] = round;
            }
            round++;
            index = check(ans, -1);
        }
        return ans;
    }

    private int check(int[] ans, int index) {
        for (int i = index + 1; i < ans.length; i++) {
            if (ans[i] == -1)
                return i;
        }
        return -1;
    }

    //Solution2：单调栈，只存储数组的下标，依次比较栈顶元素，非空进栈
    //进入循环 当前元素比栈顶大，说明已经升温了，则出栈,然后为其ans数组赋值,再次重复
    //若小于，则进栈
    public int[] dailyTemperatures2(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[temperatures.length];
        for (int i = 0; i < ans.length; i++) {
            int temperature = temperatures[i];
            //要理解为什么进入循环，因为当前元素要和进栈的元素逐一比较！！
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperature){
                int prev = stack.pop();
                ans[prev] = i - prev;
            }
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(new L739().dailyTemperatures2(nums)));
    }
}
