package com.mingshashan.learn.lt.l232;

import java.util.Stack;

class MyQueue {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    int head_element;

    public MyQueue() {

    }

    public void push(int x) {
        stack2.push(x);
    }

    public int pop() {
        peek();
        return stack1.pop();
    }

    public int peek() {
        if (stack1.isEmpty()) {
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
        }
        return stack1.peek();
    }

    public boolean empty() {
        return stack2.isEmpty() && stack1.isEmpty();
    }
}
