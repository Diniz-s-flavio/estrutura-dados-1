package com.diniz.flavio.model;

public class StaticStack {
    private Object[] items;
    private int top;

    public StaticStack(int size){
        items = new Object[size];
        top = 0;
    }

    public void push(int item){
        if(top == items.length){
            throw new RuntimeException("Pilha cheia");
        }
        items[top++] = item;
    }

    public Object pop(){
        if (top == 0){
            throw new RuntimeException("Pilha vazia");
        }
        return items[top--];
    }
}
