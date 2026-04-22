package com.diniz.flavio.service;

import com.diniz.flavio.model.DynamicStack;

import java.util.Scanner;

public class AtividadeExercicosSala2 {

    public static boolean returnToStart(String path){
        path = path.toUpperCase();
        String[] pathArray = path.strip().split("");
        DynamicStack<String> stack = new DynamicStack<>();
        for (String s : pathArray) {
            if (stack.isEmpty()){
                stack.push(s);
            } else {
                switch (s) {
                    case "N":
                        cardinalPointComparator(stack, "S", s);
                        break;
                    case "S":
                        cardinalPointComparator(stack, "N", s);
                        break;
                    case "L":
                        cardinalPointComparator(stack, "O", s);
                        break;
                    case "O":
                        cardinalPointComparator(stack, "L", s);
                        break;
                    default:
                        System.out.println("Comando inválido: " + s);
                }
            }
        }

        return stack.isEmpty();

    }

    private static void cardinalPointComparator(DynamicStack<String> stack, String pointOnTop, String comparerTarger) {
        String top = stack.pop();
        if (top.equals(pointOnTop)) {
            stack.push(top);
            stack.push(comparerTarger);
        }
    }

    public static void main(String[] args) {
        String caminho1 = "NSLO";
        String caminho2 = "NNS";
        String caminho3 = "NNSS";
        String caminho4 = "LSLSOSLLOONLNONO";

        System.out.println("Caminho 1: " + (returnToStart(caminho1) ? "válido" : "inválido"));
        System.out.println("Caminho 2: " + (returnToStart(caminho2) ? "válido" : "inválido"));
        System.out.println("Caminho 3: " + (returnToStart(caminho3) ? "válido" : "inválido"));
        System.out.println("Caminho 4: " + (returnToStart(caminho4) ? "válido" : "inválido"));
    }

    private class Step{
        public int x;
        public int y;
        private boolean virified = false;
        private boolean wall;
    }

    public static boolean hasPath(Step[][] matrix, int targetX, int targetY){
        if(matrix.length == 0 || matrix[0].length == 0){
            System.err.println("Matriz vazia");
            return false;
        }
        if(matrix.length < targetX || targetX < 0 || targetY < 0 || targetY > matrix[0].length){
            System.err.println("Posição fora do campo de avaliacão");
        }

        for(int row = 0; row < matrix.length; row++){
            for(int col = 0; col < matrix[row].length; col++){
                if (matrix[row][col].x == targetX && matrix[row][col].y == targetY){
                    return true;
                }else {

                }
            }
        }

        return false;
    }
}
