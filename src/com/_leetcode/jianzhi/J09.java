package com._leetcode.jianzhi;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class J09 {
    //两个栈模拟一个队列
    //Solution：栈1用来入队，栈2用来出队
    // 入队：直接往栈1添加
    // 出队：从栈2弹出，如果栈2为空，则把栈1元素全部弹到栈2，然后取栈顶即可
    class CQueue {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        public CQueue() {
        }

        public void appendTail(int value) {
            stack1.push(value);
        }

        public int deleteHead() {
            if (!stack2.isEmpty())
                return stack2.pop();

            if (stack1.isEmpty()) return -1;
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
    }

    //Additional
    //两个队列模拟一个栈
    //Solution：入队，用有元素的队列列存；出队，将有元素的队列输出到空队列，但留一个元素，作为结果弹出
    class CStack {
        Deque<Integer> queue1 = new LinkedList<>();
        Deque<Integer> queue2 = new LinkedList<>();

        public CStack() {
        }

        public void push(int value) {
            if (queue1.isEmpty())
                queue2.add(value);
            else queue1.add(value);
        }

        public int pop() {
            if (queue1.isEmpty() && queue2.isEmpty())
                return -1;
            if (queue1.isEmpty()) {
                while (queue2.size() > 1)
                    queue1.add(queue2.pop());
                return queue2.pop();
            } else {
                while (queue1.size() > 1)
                    queue2.add(queue1.pop());
                return queue1.pop();
            }
        }
    }


}
