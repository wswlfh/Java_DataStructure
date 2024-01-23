package com._leetcode.jianzhi;


import java.util.*;

public class J31 {
    //Solution：
    // 入栈序列和出栈序列都存储到队列中，
    // 将入栈序列出队后依次入栈
    //  每次压入栈后马上和出栈序列判断，如果对得上，栈和出栈序列都出栈
    //  对不上则继续压入，直至入栈序列都为空
    //  最后查看出栈队列是否还有元素
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> push = new LinkedList<>();
        Deque<Integer> pop = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < pushed.length; i++) {
            push.add(pushed[i]);
            pop.add(popped[i]);
        }

        while (!push.isEmpty()) {
            stack.push(push.pop());
            while (!stack.isEmpty() && stack.peek().equals(pop.peek())) {
                stack.pop();
                pop.pop();
            }
        }

        return pop.isEmpty();
    }

    public static void main(String[] args) {
        new J31().validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1});
    }
}
