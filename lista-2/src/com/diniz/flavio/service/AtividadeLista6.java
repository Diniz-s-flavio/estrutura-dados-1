package com.diniz.flavio.service;

import com.diniz.flavio.model.DynamicQueue;
import com.diniz.flavio.model.QueueNode;

import java.util.Objects;

public class AtividadeLista6 {


    /**
     *  1) Escreva um método que receba uma fila como parâmetro e retire todos os
     * elementos ímpares dessa fila.
     */
    public static DynamicQueue removeOdd(DynamicQueue queue) {
        queue.throwExceptionIfEmpty();
        QueueNode current = queue.getHead();

        while (current != null) {
            if (current.getItem() % 2 == 0) {
                int item = current.getItem();
                queue.dequeue();
                queue.enqueue(item);
            }
            queue.dequeue();
            current = queue.getHead();
        }

        return queue;
    }
    /**
     *  2) Desenvolva um método para inverter a posição dos elementos de uma fila.
     */
    public static DynamicQueue invertOrder(DynamicQueue queue) {
        queue.throwExceptionIfEmpty();
        QueueNode current = queue.getHead();
        DynamicQueue queue2 = new DynamicQueue();

        while (!Objects.equals(current.getItem(), queue.getTail().getItem())) {
            if (queue2.isEmpty()) {
                queue.enqueue(current.getItem());
            }
            if (current.hasNext()){
                queue.enqueue(current.getNext().getItem());
                queue.dequeue();
            }
            current = current.getNext();
        }

        return queue;
    }

    // Testes
}
