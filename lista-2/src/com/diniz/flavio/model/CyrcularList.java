package com.diniz.flavio.model;

public class CyrcularList {
        private Node2 head;
        private Node2 tail;

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

        public CyrcularList() {
            this.head = null;
            this.tail = null;
        }

        public void addFirst(Object item) {
            Node2 newNode = new Node2(item);

            if (isEmpty()) {
                head = newNode;
                tail = newNode;
                head.setNext(head);
                head.setPrevious(head);
            } else {
                newNode.setNext(head);
                newNode.setPrevious(tail);
                head.setPrevious(newNode);
                tail.setNext(newNode);
                head = newNode;
            }
        }

        public void addLast(Object item) {
            Node2 newNode = new Node2(item);

            if (isEmpty()) {
                head = newNode;
                tail = newNode;
                head.setNext(head);
                head.setPrevious(head);
            } else {
                newNode.setNext(head);
                newNode.setPrevious(tail);
                tail.setNext(newNode);
                head.setPrevious(newNode);
                tail = newNode;
            }
        }

        public void addOrdered(Object item) {
            Node2 newNode = new Node2(item);

            if (isEmpty()) {
                head = newNode;
                tail = newNode;
                head.setNext(head);
                head.setPrevious(head);
                return;
            }

            Node2 current = head;

            do {
                if ((Integer) item < (Integer) current.getItem()) {
                    if (current == head) {
                        addFirst(item);
                    } else {
                        Node2 previous = current.getPrevious();
                        newNode.setNext(current);
                        newNode.setPrevious(previous);
                        previous.setNext(newNode);
                        current.setPrevious(newNode);
                    }
                    return;
                }
                current = current.getNext();
            } while (current != head);

            addLast(item);
        }

        public Object removeFirst() {
            throwExceptionIfEmpty();

            Object returnedItem = head.getItem();

            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.getNext();
                head.setPrevious(tail);
                tail.setNext(head);
            }

            return returnedItem;
        }

        public Object removeLast() {
            throwExceptionIfEmpty();

            Object returnedItem = tail.getItem();

            if (head == tail) {
                head = null;
                tail = null;
            } else {
                tail = tail.getPrevious();
                tail.setNext(head);
                head.setPrevious(tail);
            }

            return returnedItem;
        }

        public Object remove(Object key) {
            throwExceptionIfEmpty();

            Node2 current = head;

            do {
                if (current.getItem().equals(key)) {
                    Object returnedItem = current.getItem();

                    if (head == tail) {
                        head = null;
                        tail = null;
                    } else if (current == head) {
                        removeFirst();
                    } else if (current == tail) {
                        removeLast();
                    } else {
                        Node2 previous = current.getPrevious();
                        Node2 next = current.getNext();
                        previous.setNext(next);
                        next.setPrevious(previous);
                    }

                    return returnedItem;
                }
                current = current.getNext();
            } while (current != head);

            return null;
        }

        public Object pesquisa(Object chave) {
            throwExceptionIfEmpty();

            Node2 current = head;

            do {
                if (current.getItem().equals(chave)) {
                    return current.getItem();
                }
                current = current.getNext();
            } while (current != head);

            return null;
        }

        public Node2 findNodeByKey(Object key) {
            throwExceptionIfEmpty();

            Node2 current = head;

            do {
                if (current.getItem().equals(key)) {
                    return current;
                }
                current = current.getNext();
            } while (current != head);

            return null;
        }

        public void print() {
            if (isEmpty()) {
                System.out.println("A lista está vazia.");
                return;
            }

            Node2 current = head;

            do {
                System.out.print(current + (current.getNext() != head ? ", " : ""));
                current = current.getNext();
            } while (current != head);

            System.out.println();
        }

        public boolean isEmpty() {
            return head == null;
        }

        public void throwExceptionIfEmpty() {
            if (isEmpty()) {
                throw new IllegalStateException("A lista está vazia.");
            }
        }

        public void changeNodesPosition(Node2 firstNode, Node2 secondNode) {
            throwExceptionIfEmpty();

            if (firstNode == null || secondNode == null) {
                throw new IllegalArgumentException("Os nós não podem ser nulos.");
            }

            if (firstNode == secondNode) {
                return;
            }

            Node2 firstPrev = firstNode.getPrevious();
            Node2 firstNext = firstNode.getNext();
            Node2 secondPrev = secondNode.getPrevious();
            Node2 secondNext = secondNode.getNext();

            if (firstNext == secondNode) {
                firstNode.setNext(secondNext);
                firstNode.setPrevious(secondNode);
                secondNode.setNext(firstNode);
                secondNode.setPrevious(firstPrev);

                firstPrev.setNext(secondNode);
                secondNext.setPrevious(firstNode);
            } else if (secondNext == firstNode) {
                secondNode.setNext(firstNext);
                secondNode.setPrevious(firstNode);
                firstNode.setNext(secondNode);
                firstNode.setPrevious(secondPrev);

                secondPrev.setNext(firstNode);
                firstNext.setPrevious(secondNode);
            } else {
                firstPrev.setNext(secondNode);
                firstNext.setPrevious(secondNode);
                secondPrev.setNext(firstNode);
                secondNext.setPrevious(firstNode);

                firstNode.setPrevious(secondPrev);
                firstNode.setNext(secondNext);
                secondNode.setPrevious(firstPrev);
                secondNode.setNext(firstNext);
            }

            if (head == firstNode) {
                head = secondNode;
            } else if (head == secondNode) {
                head = firstNode;
            }

            if (tail == firstNode) {
                tail = secondNode;
            } else if (tail == secondNode) {
                tail = firstNode;
            }
        }

        public static int countNodes(CyrcularList list) {
            int count = 0;
            Node2 current = list.getHead();
            if (current == null){
                System.out.println("Lista Vasia!!");
                return 0;
            }
            do{
                count++;
                current = current.getNext();
            } while (current != list.getHead());

            return count;
        }
    }
