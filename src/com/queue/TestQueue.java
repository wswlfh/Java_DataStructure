package com.queue;

import java.util.Random;

public class TestQueue {
    public double testQueue(Queue<Integer> q, int opCount) {
        long startTime = System.nanoTime();

        for (int i = 0; i < opCount; i++) {
            Random random = new Random();
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            q.dequeue();
        }

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        int opCount = 100000;
        //循环队列的平均用时比数组队列快了一百多倍
        System.out.println(new TestQueue().testQueue(new ArrayQueue<>(),opCount));
        System.out.println(new TestQueue().testQueue(new LoopQueue<>(),opCount));
    }
}
