package com.company;

public class LinkedList<T> {
    private Node head;
    private Node tail;
    private int length;

    public LinkedList () {

    }

    public LinkedList (T data) {
        this.add(data);
    }
    public void add(T data) {
        Node newNode = new Node(data);
        if (tail == null){
            head = newNode;
        } else {
            newNode.setPrevious(tail);
            tail.setNext(newNode);
        }
        tail = newNode;
        length++;
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.setNext(head);

        if(head == null) {
            tail = newNode;
        } else {
            head.setPrevious(newNode);
        }
        head = newNode;
        length++;
    }

    public void printList() {
        if(head != null) {
            head.print();
        }
    }
    public class  Node<T> {
        private T data;
        private Node left;
        private Node right;

        public Node (T data) {
            this.data = data;
        }

        public Node getNext() {
            return  this.right;
        }

        public void setNext(Node node) {
            this.right = node;
        }

        public Node getPrevious() {
            return this.left;
        }

        public void setPrevious(Node node) {
            this.left = node;
        }

        public void print() {
            System.out.println(data);
            if(right != null){
                right.print();
            }
        }
    }
}


