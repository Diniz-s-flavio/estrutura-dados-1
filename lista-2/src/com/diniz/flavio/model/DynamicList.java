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

    public void addOrdered(Object item) {
        Node newNode = new Node(item);
        Node current = this.head;
        while (current.hasNext() && (Integer) current.getNext().getItem() < (Integer) item) {
            current = current.getNext();
        }

        newNode.setNext(current);
        if (!newNode.hasNext()) {
            this.tail = newNode;
        }
    }

    public Object removeFirst() {
        this.validateEmpty();

        Node current = this.head;

        Node previous = this.head.getNext();

        Object returnedItem = previous.getItem();

        current.setNext(previous.getNext());

        if (!current.hasNext()) {
            this.tail = current;
        }

        return returnedItem;
    }

    public Object removeLast() {
        this.validateEmpty();

        Object returnedItem = this.tail.getItem();
        Node current = this.head;

        while (current.hasNext() && current.getNext() != this.tail ) {
            current = current.getNext();
        }

        current.setNext(null);
        this.tail = current;

        return returnedItem;
    }


    public Object remove(Object item) {
        this.validateEmpty();

        Node current = this.head;

        while (current.hasNext() && !current.getNext().getItem().equals(item)) {
            current = current.getNext();
        }

        if (!current.hasNext()) {
            return null;
        }

        Node q = current.getNext();
        Object returnedItem = q.getItem();
        current.setNext(q.getNext());

        if (!current.hasNext()) {
            this.tail = current;
        }

        return returnedItem;
    }

    public Object pesquisa (Object chave) {
        this.validateEmpty();
        Node current = head;
        while (current.getNext() != null ) {
            if (current.getNext().getItem().equals(chave))
                return current.getNext().getItem();
            current = current.getNext();
        }
        return null;
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

    public void validateEmpty() {
        if (this.isEmpty()) {
            throw new IllegalStateException("A lista está vazia.");
        }
    }


}
