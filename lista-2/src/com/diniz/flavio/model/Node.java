package com.diniz.flavio.model;

public class Node {
    private Object item;
    private Node next;

    public Node(Object item) {
        this.item = item;
        this.next = null;
    }

    public Object getItem() {
        return item;
    }

    public void setItem(Object item) {
        this.item = item;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return this.item.toString();
    }

    public boolean hasNext() {
        return this.next == null;
    }
}
