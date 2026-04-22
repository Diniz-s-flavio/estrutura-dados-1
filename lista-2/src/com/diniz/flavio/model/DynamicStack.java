package com.diniz.flavio.model;

public class DynamicStack<T> {
    private static class No<T> {
        T value;
        No<T> prox;

        No(T value) {
            this.value = value;
        }
    }

    private No<T> top;
    private int tamanho;

    public void push(T valor) {
        No<T> novo = new No<>(valor);
        novo.prox = top;
        top = novo;
        tamanho++;
    }

    // Desempilha
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("A pilha está vazia.");
        }

        T valor = top.value;
        top = top.prox;
        tamanho--;
        return valor;
    }

    // Consulta o topo sem remover
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("A pilha está vazia.");
        }

        return top.value;
    }

    // Verifica se está vazia
    public boolean isEmpty() {
        return top == null;
    }

    // Retorna a quantidade de elementos
    public int size() {
        return tamanho;
    }

    // Exibe os elementos
    public void imprimir() {
        No<T> atual = top;
        System.out.println("Topo da pilha:");
        while (atual != null) {
            System.out.println(atual.value);
            atual = atual.prox;
        }
    }
}
