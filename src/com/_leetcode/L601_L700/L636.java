package com._leetcode.L601_L700;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class L636 {

    //Solution：利用栈，start就入栈，并记录上一个入栈的函数当前的运行时间
    //栈结构 new int[]{id,time} time记录的是 当前函数的开始运行时间(包括被暂停后的重新开始运行时间)
    //遇到end就出栈，遇到的end对应当前函数的start，然后把当前函数所运行的时间记录，并重置当前栈顶的开始时间
    public static int[] exclusiveTime(int n, List<String> logs) {
        int[] count = new int[n];
        Stack<int[]> stack = new Stack<>();
        for (String s : logs) {
            String[] ss = s.split(":");
            int id = Integer.parseInt(ss[0]);
            String action = ss[1];
            int time = Integer.parseInt(ss[2]);

            if ("start".equals(action)) {
                if (!stack.isEmpty()) {
                    int[] peek = stack.peek();
                    count[peek[0]] += time - peek[1];
                }
                stack.add(new int[]{id, time});
            } else if ("end".equals(action)) {
                int[] pop = stack.pop();
                count[pop[0]] += time - pop[1] + 1;

                if (!stack.isEmpty())
                    stack.peek()[1] = time + 1;
            }
        }

        //结果输出 划掉为0的结果 因为传进来的多个函数可能都是同一个id
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0)
                list.addLast(count[i]);
        }

        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        LinkedList<String> logs = new LinkedList<>();
        String[] ss = new String[]{"0:start:0", "0:end:0"};
        for (String s : ss)
            logs.addLast(s);

        exclusiveTime(2, logs);
    }
}
