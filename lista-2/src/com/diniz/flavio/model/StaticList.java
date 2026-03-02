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

    public void remove(int element){
        if (isEmpty()){
            throw new RuntimeException("lista vazia não há nada a ser removido!");
        }

        for (int i = firstIndex; i < lastIndex; i++) {
            if

        }
    }
}
