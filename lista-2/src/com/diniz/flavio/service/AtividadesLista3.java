package com.diniz.flavio.service;

import com.diniz.flavio.model.DynamicList;

public class AtividadesLista3 {

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
}
