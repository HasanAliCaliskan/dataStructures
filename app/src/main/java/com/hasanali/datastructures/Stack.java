package com.hasanali.datastructures;

public class Stack {

    private int items[];
    private int top;
    private int capacity;

    public Stack(int capacity) {
        this.capacity = capacity;
        items = new int[capacity];
        top = -1;
    }

    public void push(int value) {
        if(isFull()) {
            System.out.println("Stack is full!");
        } else {
            items[++top] = value;
        }
    }

    public void pop() {
        if(isEmpty()) {
            System.out.println("Stack is empty!");
        } else {
            items[top--] = 0;
        }
    }

    public int peek() {
        if(isEmpty()) {
            System.out.println("Stack is empty!");
            return -1;
        } else {
            return items[top];
        }
    }

    public int size() {
        return top + 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    public void display() {
        for(int i = 0; i < items.length; i++) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }

}

