package com.diniz.flavio.model;

public class DynamicList {
    private Node head;
    private Node tail;

    public DynamicList() {
        this.head = new Node();
        this.tail = this.head;
    }

    public void addFirst(Object item) {
        Node newNode = new Node(item);

        this.head.setNext(newNode);
        if (isEmpty()) {
            this.tail = newNode;
        } else {
            newNode.setNext(this.head);
            this.head = newNode;
        }
    }

    public void addLast(Object item) {
        Node newNode = new Node(item);
        if (this.isEmpty()) {
            this.head.setNext(newNode);
            this.tail = newNode;
        }
        tail.setNext(newNode);
        tail = newNode;

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
        this.throwExceptionIfEmpty();

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
        this.throwExceptionIfEmpty();

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
        this.throwExceptionIfEmpty();

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
        this.throwExceptionIfEmpty();
        Node current = head;
        while (current.getNext() != null ) {
            if (current.getNext().getItem().equals(chave))
                return current.getNext().getItem();
            current = current.getNext();
        }
        return null;
    }

    public Node findNodeByKey (Object key) {
        this.throwExceptionIfEmpty();
        Node current = head;
        while (current.hasNext() ) {
            if (current.getNext().getItem().equals(key))
                return current.getNext();

            current = current.getNext();
        }
        return null;
    }

    public void print() {
        if (this.isEmpty()){
            System.out.println("A lista está vazia.");
            return;
        }
        Node current = this.head.getNext();
        while (current != null) {
            System.out.print(current +(current.hasNext() ? ", ": "\n"));
            current = current.getNext();
        }
    }

    public boolean isEmpty() {
        return this.head == this.tail;
    }

    public void throwExceptionIfEmpty() {
        if (this.isEmpty()) {
            throw new IllegalStateException("A lista está vazia.");
        }
    }


    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }


    //Listas 3

    /** E4 - Faça um método para remover os n primeiros elementos de uma lista. O método deve
    * retornar true se a remoção de todos os “n” elementos for concluída com sucesso, ou false
    * caso a lista possua menos de “n” elementos (neste caso, nenhum elemento deve ser removido).
    */
    public boolean removeElements(int n){
        if (this.isEmpty()) {
            return false;
        }

        Node current =  this.getHead().getNext();
        int listLength = 1;

        while (current.hasNext()){
            listLength++;
            current = current.getNext();
        }

        if (listLength < n) {
            return false;
        }

        for (int i = 0; i < n; i++) {
            this.removeFirst();
        }

        return true;
    }

    // E6 - Trocar as posições de dois itens na lista, sem alterar os itens em si, ou seja, apenas alterando os ponteiros.
    public void e6_changePositions(Node item1, Node item2) {
        this.throwExceptionIfEmpty();

        if (item1.equals(item2)) {
            throw new IllegalArgumentException("Os itens devem ser diferentes.");
        }

        Node preItem1 = null;
        Node postItem1 = item1.getNext();
        Node preItem2 = null;
        Node postItem2 = item2.getNext();

        Node current = this.head;
        while (current.hasNext()) {
            if (current.getNext().equals(item1)) {
                preItem1 = current;
            } else if (current.getNext().equals(item2)) {
                preItem2 = current;
            }
            current = current.getNext();
        }

        if (preItem1 == null || preItem2 == null) {
            throw new IllegalArgumentException("Um ou ambos os itens náo foram encontrados.");
        }

        item1.setNext(postItem2);
        preItem2.setNext(item1);

        item2.setNext(postItem1);
        preItem1.setNext(item2);

        if (postItem1 == null){
            this.tail = item1;
        } else if (postItem2 == null) {
            this.tail = item2;
        }
    }
}
