package com.diniz.flavio.model;

public class Node2 {
    private Object item;
    private Node2 next;
    private Node2 previous;

    public Node2(Object item) {
        this.item = item;
        this.next = null;
        this.previous = null;
    }

    public Object getItem() {
        return item;
    }

    public void setItem(Object item) {
        this.item = item;
    }

    public Node2 getNext() {
        return next;
    }

    public void setNext(Node2 next) {
        this.next = next;
    }

    public Node2 getPrevious() {
        return previous;
    }

    public void setPrevious(Node2 previous) {
        this.previous = previous;
    }

    @Override
    public String toString() {
        return this.item.toString();
    }

    public boolean hasNext() {
        return this.next == null;
    }
    public boolean hasPrevious() {
        return this.previous == null;
    }
}
