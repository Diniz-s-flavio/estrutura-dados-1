package com.diniz.flavio.model;

public class DynamicList {
    private Node head;
    private Node tail;

    public DynamicList() {
        this.head = null;
        this.tail = this.head;
    }

    public void addFirst(Object item) {
        Node newNode = new Node(item);
        newNode.setNext(this.head.getNext());
        this.head.setNext(newNode);

        if (this.isEmpty()) {
            this.tail = newNode;
        }
    }

    public void addLast(Object item) {
        Node newNode = new Node(item);
        if (this.isEmpty()) {
            this.head.setNext(newNode);
            this.tail = newNode;
        }
        newNode.setNext(this.head.getNext());

    }

    public void print() {
        Node current = this.head;
        while (current != null) {
            System.out.println(current + (current.hasNext() ? ", ": ""));
            current = current.getNext();
        }
    }

    public boolean isEmpty() {
        return this.head == this.tail;
    }


}
