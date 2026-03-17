package com.diniz.flavio.service;

import com.diniz.flavio.model.DynamicList;
import com.diniz.flavio.model.Node;

public class AtividadesLista3 {

    public DynamicList e6_changePositions(DynamicList list, Node item1, Node item2) {
        list.throwExceptionIfEmpty();

        if (item1.equals(item2)) {
            throw new IllegalArgumentException("Os itens devem ser diferentes.");
        }

        Node preItem1 = null;
        Node postItem1 = item1.getNext();
        Node preItem2 = null;
        Node postItem2 = item2.getNext();

        Node current = list.getHead();
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
        return list;
    }
}
