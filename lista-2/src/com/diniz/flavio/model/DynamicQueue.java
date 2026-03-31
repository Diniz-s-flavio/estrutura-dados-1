package com.diniz.flavio.model;

public class DynamicQueue {
    private QueueNode head;
    private QueueNode tail;

    public DynamicQueue() {
        this.head = null;
        this.tail = this.head;
    }

    public QueueNode getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public QueueNode getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public void enqueue(int item) {
        QueueNode newNode = new QueueNode(item);

        this.head.setNext(newNode);
        if (isEmpty()) {
            this.tail = newNode;
        } else {
            newNode.setNext(this.head);
            this.head = newNode;
        }
    }

    public Integer dequeue() {
        this.throwExceptionIfEmpty();

        Integer returnItem = this.head.getItem();

        this.head = this.head.getNext();

        if (this.isEmpty()) {
            this.tail = null;
        }

        return returnItem;
    }

    public Object pesquisa (Object chave) {
        this.throwExceptionIfEmpty();
        Node current = head;
        while (current.getNext() != null ) {
            if (current.getNext().getItem().equals(chave))
                return current.getNext().getItem();
            current = current.getNext();
        }
        return null;
    }

    public void print() {
        if (this.isEmpty()){
            System.out.println("A lista está vazia.");
            return;
        }
        Node current = this.head;
        while (current != null) {
            System.out.print(current +(current.hasNext() ? ", ": "\n"));
            current = current.getNext();
        }
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public void throwExceptionIfEmpty() {
        if (this.isEmpty()) {
            throw new IllegalStateException("A Fila está vazia.");
        }
    }
}
