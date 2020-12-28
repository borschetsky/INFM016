package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        CircularQueue<Integer> queue = new CircularQueue<Integer>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.dequeue();

        System.out.println(queue.size());
        System.out.println(queue.dequeue());
//        System.out.println(queue.dequeue());

    }
}
