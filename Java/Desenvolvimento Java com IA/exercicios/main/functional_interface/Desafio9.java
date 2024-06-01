package main.functional_interface;

import java.util.Arrays;
import java.util.List;

// Desafio 9 - Verificar se todos os números da lista são distintos
public class Desafio9 {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);

        boolean saoDistintos = numeros.stream()
                                     .distinct() 
                                     .count() == numeros.size(); 

        System.out.println(saoDistintos);
    }
}
