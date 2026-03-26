package com.diniz.flavio.service;

import com.diniz.flavio.model.DynamicList;
import com.diniz.flavio.model.DynamicList2;
import com.diniz.flavio.model.Node;
import com.diniz.flavio.model.Node2;

public class AtividadesLista3 {

    // E1 - Escreva um método que crie uma lista encadeada a partir de um vetor, mantendo a ordem original dos elementos.
    public DynamicList toDynamicListFromVector(Object[] v){
        DynamicList list = new DynamicList();
        if (v == null || v.length == 0){
            return list;
        }

        for (int i = 0; i < v.length; i++) {
            list.addLast(v[i]);
        }

        return list;
    }

    // E2 - Escreva um método que copie uma lista encadeada para um vetor, mantendo a ordem original dos elementos.
    public Object[] toVectorFromDynamicList(DynamicList list){
        list.throwExceptionIfEmpty();

        Node current =  list.getHead().getNext();
        int listLength = 1;

        while (current.hasNext()){
            listLength++;
            current = current.getNext();
        }

        Object[] vector = new Object[listLength];

        current =  list.getHead().getNext();
        for (int i = 0; i < listLength; i++) {
            vector[i] = current.getItem();
            current = current.getNext();
        }

        return vector;
    }

    /** E3 - Faça um método para concatenar duas listas (L1 e L2) em uma nova lista (L3), que
    *  deverá ser retornada. Os elementos de L1 devem preceder os de L2. L1 e L2 devem permanecer intactas.
    */
    public DynamicList concatLists(DynamicList l1, DynamicList l2){
        DynamicList l3 = new DynamicList();

        Node currentL1 = l1.getHead();
        Node currentL3 = l3.getHead();

        while(currentL1.hasNext()){
            currentL3.setNext(currentL1.getNext());

            currentL1 = currentL1.getNext();

            if (!currentL1.hasNext()){
                l3.setTail(currentL3.getNext());
            }

            currentL3 = currentL3.getNext();
        }

        Node currentL2 = l2.getHead();

        while(currentL2.hasNext()){
            currentL3.setNext(currentL2.getNext());

            currentL2 = currentL2.getNext();

            if (!currentL2.hasNext()){
                l3.setTail(currentL3.getNext());
            }

            currentL3 = currentL3.getNext();

        }

        return l3;
    }

    // Métodos de Teste
    public void testarExercicio1() {
        Integer[] vector = {1,2,3,4,5};

        System.out.println("Vetor base");
        int i = 0;
        while(i< vector.length){
        System.out.print(vector[i] + (i != vector.length - 1? ", ": "\n"));
        i++;
        }

        System.out.println("Lista com atributos do vetor");
        toDynamicListFromVector(vector).print();
    }

    public void testarExercicio2() {
        DynamicList list = new DynamicList();

        list.addLast(5);
        list.addLast(12);
        list.addLast(7);
        list.addLast(19);
        list.addLast(3);
        list.addLast(15);
        list.addLast(8);
        list.addLast(1);
        list.addLast(20);
        list.addLast(10);

        System.out.println("Lista base:");
        list.print();

        Object[] vector = toVectorFromDynamicList(list);

        System.out.println("Vetor com atributos da lista:");
        int i = 0;
        while(i< vector.length){
            System.out.print(vector[i] + (i != vector.length - 1? ", ": "\n"));
            i++;
        }
    }

    public void testarExercicio3() {
        DynamicList l1 = new DynamicList();
        DynamicList l2 = new DynamicList();

        l1.addLast(1);
        l1.addLast(2);
        l1.addLast(3);
        l1.addLast(4);
        l1.addLast(5);

        System.out.println("Lista 1:");
        l1.print();

        l2.addLast(6);
        l2.addLast(7);
        l2.addLast(8);
        l2.addLast(9);
        l2.addLast(10);

        System.out.println("Lista 2:");
        l2.print();

        System.out.println("Lista 3:");
        DynamicList l3 = concatLists(l1, l2);
        l3.print();
        System.out.println("Ultimo elemento L3: " + l3.getTail().getItem());
    }

    public void testarExercicio4() {
        DynamicList list = new DynamicList();

        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);
        list.addLast(7);
        list.addLast(8);
        list.addLast(9);
        list.addLast(10);

        System.out.println("Lista Antes:");
        list.print();

        System.out.println("Conseguiu remover 5 elementos? " + (list.removeElements(5)? "Sim": "Não"));

        System.out.println("Lista depois:");
        list.print();
    }

    public void testarExercicio6() {
        DynamicList list = new DynamicList();

        list.addLast(5);
        list.addLast(12);
        list.addLast(7);
        list.addLast(19);
        list.addLast(3);
        list.addLast(15);
        list.addLast(8);
        list.addLast(1);
        list.addLast(20);
        list.addLast(10);

        list.print();

        list.e6_changePositions(list.findNodeByKey(5), list.findNodeByKey(15));
        System.out.println("\n\nDepois de trocar as posições de 5 e 15:");

        list.print();
    }

    public void testarExercicio6_2() {
        DynamicList2 list = new DynamicList2();

        list.addLast(5);
        list.addLast(12);
        list.addLast(7);
        list.addLast(19);
        list.addLast(3);
        list.addLast(15);
        list.addLast(8);
        list.addLast(1);
        list.addLast(20);
        list.addLast(10);

        list.print();

        list.changeNodesPosition(list.findNodeByKey(5), list.findNodeByKey(15));
        System.out.println("\n\nDepois de trocar as posições de 5 e 15:");


        list.addFirst(101);

        list.print();
    }
}
