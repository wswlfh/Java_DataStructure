package com;


import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public class Homework {
    //计算次数，要求循环20亿次以内，这里取1亿次
    private final long CALCULATE_NUMBER = 2L * 100000000;

    class TaskDecomposition {
        //公共容器，存放计算汇总结果
        private volatile Double sum = 0.0;
        //存储每个线程计算时间
        private final ConcurrentHashMap<Integer, Long> computeTime = new ConcurrentHashMap<>();

        public void compute(int threadNums) {
            assert threadNums >= 1;
            Thread[] threads = new Thread[threadNums];
            CountDownLatch countDownLatch = new CountDownLatch(threadNums);
            for (int i = 0; i < threads.length; i++) {
                long start = CALCULATE_NUMBER * i / threads.length;
                long end = CALCULATE_NUMBER * (i + 1) / threads.length;
                //线程id
                int threadId = i;
                threads[i] = new Thread(new Runnable() {
                    //定义每个线程的任务
                    @Override
                    public void run() {
                        //线程开始时间
                        long startTime = System.currentTimeMillis();
                        double temp = 0;
                        //从奇数位置开始算，每次加2
                        for (long j = start % 2 == 0 ? (start + 1) : start; j < end; j += 2) {
                            if (j % 4 == 1) temp += 1.0 / j;//加
                            else if (j % 4 == 3) temp -= 1.0 / j;//减
                        }
                        //线程结束时间
                        long endTime = System.currentTimeMillis();
                        //汇入结果容器
                        synchronized (this) {
                            sum += temp;
                        }
                        computeTime.put(threadId, endTime - startTime);

                        countDownLatch.countDown();
                    }
                });
                //启动线程
                threads[i].start();
            }

            //等待线程执行完成
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //输出信息
            System.out.println("线程数量：" + threadNums);
            //时间
            for (int i = 0; i < threads.length; i++) {
                System.out.println("线程" + i + "的计算时间为: " + computeTime.get(i) + "ms");
            }
            //结果
            System.out.printf("最终结果为：%.6f\n\n", 4 * sum);
        }
    }

    class DataDecomposition {
        //存放计算汇总结果
        private volatile Double sum = 0.0;
        //存储每个线程计算时间
        private final ConcurrentHashMap<Integer, Long> computeTime = new ConcurrentHashMap<>();
        //线程竞争的算子，抢到就可以计算
        AtomicLong number = new AtomicLong(1);

        public void compute(int threadNums) {
            assert threadNums >= 1;
            Thread[] threads = new Thread[threadNums];
            CountDownLatch countDownLatch = new CountDownLatch(threadNums);
            for (int i = 0; i < threads.length; i++) {
                //线程id
                int threadId = i;
                threads[i] = new Thread(new Runnable() {
                    //定义每个线程的任务
                    @Override
                    public void run() {
                        double temp = 0.0;
                        long time = 0L;
                        long v;
                        while ((v = number.getAndAdd(2L)) <= CALCULATE_NUMBER) {
                            //线程计算开始时间
                            long startTime = System.currentTimeMillis();
                            if (v % 4 == 1) temp += 1.0 / v;//加
                            else if (v % 4 == 3) temp -= 1.0 / v;//减
                            //线程计算结束时间
                            long endTime = System.currentTimeMillis();
                            time += endTime - startTime;
                        }

                        //汇入结果容器
                        synchronized (this) {
                            sum += temp;
                        }
                        computeTime.put(threadId, time);
                        countDownLatch.countDown();
                    }
                });
                //启动线程
                threads[i].start();
            }

            //等待线程执行完成
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //输出信息
            System.out.println("线程数量：" + threadNums);
            //时间
            for (int i = 0; i < threads.length; i++) {
                System.out.println("线程" + i + "的计算时间为: " + computeTime.get(i) + "ms");
            }
            //结果
            System.out.printf("最终结果为：%.6f\n\n", 4 * sum);

        }
    }


    public static void main(String[] args) {
        Homework homework = new Homework();
        //任务分解
//        System.out.println("任务分解：");
//        homework.new TaskDecomposition().compute(1); //单线程
//        homework.new TaskDecomposition().compute(2); //双线程
//        homework.new TaskDecomposition().compute(4); //四线程

        //数据分解
        System.out.println("数据分解：");
        //homework.new DataDecomposition().compute(1);
        homework.new DataDecomposition().compute(2);
        //homework.new DataDecomposition().compute(4);

    }
}
