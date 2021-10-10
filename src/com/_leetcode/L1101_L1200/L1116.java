package com._leetcode.L1101_L1200;

import java.util.function.IntConsumer;

public class L1116 {
    private int n;
    private int i = 0;
    boolean print0 = false;

    public L1116(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        while (i <= n ) {
            if (print0) {
                printNumber.accept(0);
                print0 = false;
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        while (i <= n) {
            if (i % 2 == 0) {
                print0 = true;
                while (print0) ;
                printNumber.accept(i);
                i++;
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        while (i <= n) {
            if (i % 2 != 0) {
                print0 = true;
                while (print0) ;
                printNumber.accept(i);
                i++;
            }
        }
    }
}
