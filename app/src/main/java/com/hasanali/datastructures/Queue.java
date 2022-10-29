package com.hasanali.datastructures;

public class Queue {

    private int[] queue;
    private int size;
    private int front;
    private int rear;

    public Queue(int size) {
        this.size = size;
        queue = new int[size];
        front = 0;
        rear = -1;
    }

    public void enQueue(int data) {
        if(isFull()) {
            System.out.println("Full!");
        } else {
            queue[++rear] = data;
        }
    }

    public void deQueue() {
        if(isEmpty()) {
            System.out.println("Empty!");
        } else {
            for(int i = front+1; i <= rear; i++) {
                queue[i-1] = queue[i];
            }
            rear--;
        }
    }

    public void display() {
        for(int i = front; i <= rear; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }

    public void queueUp(int element) { // verilen elmanı kuyruğun sonuna atar
        for(int i = front; i <= rear; i++) {
            if(queue[i] == element) {
                for(int j = i; j < rear; j++) {
                    queue[j] = queue[j+1];
                }
                queue[rear] = element;
            }
        }
    }

    public boolean isEmpty() {
        return rear == -1;
    }

    public boolean isFull() {
        return rear == size - 1;
    }

    public int peek() {
        if(isEmpty()) {
            System.out.println("Empty!");
            return -1;
        }
        return queue[front];
    }

    public int size() {
        return rear + 1;
    }
}
