package com.company;

import java.util.NoSuchElementException;

public class CircularQueue<T> {
    private int front, rear;
    private Object[] nums;

    public CircularQueue() {
        this.front = this.rear = -1;
        this.nums = new Object[4];
    }

    public  void enqueue(T data) {
        if(isFull()){
            resize();
        } else if (isEmpty()) {
            front++;
        }
        rear = (rear + 1) % nums.length;
        nums[rear] = data;
    }

    public  T dequeue() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        T temp = (T)nums[front];
        if(front == rear){
            front = rear = -1;
        } else {
            front = (front + 1) % nums.length;
        }
        return temp;
    }

    public T peek() {
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        return  (T)nums[front];
    }

    public boolean isEmpty() {
        return  front == -1;
    }

    private boolean isFull() {
        return  (rear + 1) % nums.length == front;
    }

    private void resize() {
        Object[] tempArr = new Object[nums.length * 2];
        int i =0;
        int j = front;

        do {
            tempArr[i++] = nums[j];
            j = (j + 1) % nums.length;
        } while (j != front);

        front = 0;
        rear = nums.length - 1;
        nums = tempArr;
    }

    public int size () {
        return  nums.length;
    }
}
