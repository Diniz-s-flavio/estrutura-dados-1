package com.diniz.flavio.model;

public class StaticList {

    private Object[] items;

    private int firstIndex;

    private int lastIndex;

    public StaticList(int maxTam) {
        items = new Object[maxTam];
        firstIndex = 0;
        lastIndex = 0;
    }

    public boolean isEmpty() {
        return firstIndex == lastIndex;
    }

    public boolean isFull() {
        return lastIndex == items.length;
    }

    public void addFirst(Object element) {
        if (isFull()) {
            throw new RuntimeException("A lista ta cheia não vai ter como!");
        }
        for (int i = firstIndex; i <= lastIndex; i--) {
            if ((Integer)items[i] > (Integer)element) items[i + 1] = items[i];
        }
        items[lastIndex] = element;
        lastIndex++;
    }

    public void addLast(Object element) {
        if (isFull()) {
            throw new RuntimeException("A lista ta cheia não vai ter como!");
        }
        items[lastIndex] = element;
        lastIndex++;
    }

    public void addOrdered(Object element) {
        if (isFull()) {
            throw new RuntimeException("A lista ta cheia não vai ter como!");
        }
        for (int i = firstIndex - 1; i >= lastIndex; i--) {
            items[i + 1] = items[i];
        }
        items[lastIndex] = element;
        lastIndex++;
    }

    public Object removeFirst(){
        if (isEmpty()){
            throw new RuntimeException("lista vazia não há nada a ser removido!");
        }

        Object items = this.items[0];
        this.lastIndex--;

        for (int i = 0; i < this.lastIndex; i++) {
            this.items[i] = this.items[i + 1];
        }

        return items;
    }

    public Object removeLast(){
        if (isEmpty()){
            throw new RuntimeException("lista vazia não há nada a ser removido!");
        }

        Object items = this.items[this.lastIndex - 1];
        this.lastIndex--;

        return items;
    }

    public Object remove (Object key) throws Exception {
        if (isEmpty() || key == null) {
            throw new RuntimeException("lista vazia não há nada a ser removido!");
        }
        int p = 0;
        while(p < lastIndex && !items[p].equals(key)) {
            p++;
        }
        if (p == lastIndex) {
            return null;
        }
        Object item = this.items[p];
        this.lastIndex--;

        for (int i = p; i < this.lastIndex; i++) {
            this.items[i] = this.items[i + 1];
        }

        return item;
    }

    public Object search (Object key) {
        if (isEmpty() || key == null) {
            throw new RuntimeException("lista vazia não há nada a ser encontrado!");
        }
        for (int p = 0; p < lastIndex; p++) {
            if (items[p].equals(key)) {
                return items[p];
            }
        }
        return null;
    }
}
