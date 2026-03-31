package com.diniz.flavio.model;

public class QueueNode {
    private Integer item;
    private QueueNode next;

    public QueueNode(int item) {
        this.item = item;
        this.next = null;
    }

    public QueueNode() {
        this.item = null;
        this.next = null;
    }

    public Integer getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public QueueNode getNext() {
        return next;
    }

    public void setNext(QueueNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return this.item.toString();
    }

    public boolean hasNext() {
        return this.next != null;
    }
}
