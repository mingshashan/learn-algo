package com.mingshashan.learn.lt.l225;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {

    Queue<Integer> queue = new LinkedList<>();
    int top;

    public MyStack() {

    }

    public void push(int x) {
        queue.offer(x);
        top = x;
    }

    public int pop() {
        int size = queue.size();
        while (size > 2) {
            push(queue.poll());
            size--;
        }

        top = queue.peek();
        queue.offer(queue.poll());
        return queue.poll();
    }

    public int top() {
        return top;
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
