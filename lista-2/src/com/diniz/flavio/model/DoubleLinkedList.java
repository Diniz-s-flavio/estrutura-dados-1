package com.diniz.flavio.model;

public class DoubleLinkedList {
    private Node2 head;
    private Node2 tail;

    public DoubleLinkedList() {
        this.head = null;
        this.tail = this.head;
    }

    public void addFirst(Object item) {
        Node2 newNode = new Node2(item);
        newNode.setNext(this.head);

        if (!this.isEmpty()) {
            this.head.setPrevious(newNode);
        } else {
            this.tail = newNode;
        }

        this.head = newNode;
    }

    public void addLast(Object item) {
        Node2 newNode = new Node2(item);
        newNode.setPrevious(this.tail);
        if (this.isEmpty()) {
            this.head = newNode;
        }else {
            this.tail.setNext(newNode);
        }
        this.tail = newNode;

    }

    public void addOrdered(Object item) {
        Node2 newNode = new Node2(item);
        if (!newNode.hasNext()) {
            head = newNode;
            tail = newNode;
        } else {
            Node2 current = head;
            while (current != null && (Integer) current.getItem() < (Integer) item) {
                current = current.getNext();
            }
            newNode.setNext(current);
            if (current == null) {
                newNode.setNext(null);
                newNode.setPrevious(tail);
                tail.setNext(newNode);
                tail = newNode;
            }else if (current.equals(head)) {
                head = newNode;
                newNode.setPrevious(null);
                newNode.setNext(current);
                current.setPrevious(newNode);
            }else {
                Node2 previous = current.getPrevious() ;
                newNode.setPrevious(previous);
                newNode.setNext(current);
                previous.setNext(newNode);
                current.setPrevious(newNode);
            }
        }


    }

    public Object removeFirst() {
        this.throwExceptionIfEmpty();

        Object returnedItem = head.getItem();
        Node2 current = this.head.getNext();

        if (current == null) {
            head = null;
            tail = head;
        } else {
            current.setPrevious(null);
            head = current;
        }

        return returnedItem;
    }

    public Object removeLast() {
        this.throwExceptionIfEmpty();

        Object returnedItem = this.tail.getItem();

        Node2 current = this.head;

        if (current == null) {
            head = null;
            tail = head;
        } else {
            current.setNext(null);
            tail = current;
        }

        return returnedItem;
    }


    public Object remove(Object key) {
        Object item;
        this.throwExceptionIfEmpty();

        Node2 current = this.head;

        while (current.hasNext() && !current.getItem().equals(key)) {
            current = current.getNext();
        }

        if (current == null) {
            return null;
        } else {
            item = current.getItem();

            if (!current.hasPrevious()) {
                Node2 newHead = head.getNext();

                if(newHead == null) {
                    head = null;
                    tail = head;
                } else {
                    newHead.setPrevious(null);
                    head = newHead;
                }
                this.tail = current;
            }
        }

        Node2 q = current.getNext();
        Object returnedItem = q.getItem();
        current.setNext(q.getNext());



        return returnedItem;
    }

    public Object pesquisa (Object chave) {
        this.throwExceptionIfEmpty();
        Node2 current = head;
        while (current.getNext() != null ) {
            if (current.getNext().getItem().equals(chave))
                return current.getNext().getItem();
            current = current.getNext();
        }
        return null;
    }

    public Node2 findNodeByKey (Object key) {
        this.throwExceptionIfEmpty();
        Node2 current = head;
        while (current.getNext() != null ) {
            if (current.getNext().getItem().equals(key))
                return current.getNext();
            current = current.getNext();
        }
        return null;
    }

    public void print() {
        Node2 current = this.head;
        while (current != null) {
            System.out.println(current + (current.hasNext() ? ", ": ""));
            current = current.getNext();
        }
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public void throwExceptionIfEmpty() {
        if (this.isEmpty()) {
            throw new IllegalStateException("A lista está vazia.");
        }
    }


    public Node2 getHead() {
        return head;
    }

    public void setHead(Node2 head) {
        this.head = head;
    }

    public Node2 getTail() {
        return tail;
    }

    public void setTail(Node2 tail) {
        this.tail = tail;
    }
}
