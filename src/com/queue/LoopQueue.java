package com.queue;

public class LoopQueue<E> implements Queue<E> {
    private E[] data;
    private int front;
    private int tail;
    private int size;

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public void enqueue(E e) {
        if (size == getCapacity())
            resize(2 * getCapacity());
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    private void resize(int newCapacity) {
        if (size == 0) {
            return;
        }
        E[] newData = (E[]) new Object[newCapacity + 1];
        if (front < tail) {
            for (int i = front; i < tail; i++) {
                newData[i - front] = data[i];
            }
        } else {
            for (int i = front; i < data.length; i++) {
                newData[i - front] = data[i];
            }
            for (int i = 0; i < tail; i++) {
                newData[data.length - front + i] = data[i];
            }
        }
        front = 0;
        tail = size;
        data = newData;
    }

    @Override
    public E dequeue() {
        if (size == 0)
            throw new IllegalArgumentException("Queue is empty!");
        E e = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if (size < getCapacity() / 2)
            resize(getCapacity() / 2);
        return e;
    }

    @Override
    public E getFront() {
        if (size == 0)
            throw new IllegalArgumentException("Queue is empty!");
        return data[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        if (size == 0)
            return "Queue is null";
        res.append("LoopQueue: ");
        for (int i = 0; i < data.length; i++) {
            res.append(data[i]);
            if (i == front)
                res.append("(front)");
            if (i == tail)
                res.append("(tail)");
            res.append(' ');
        }

        return res.toString();
    }
}
