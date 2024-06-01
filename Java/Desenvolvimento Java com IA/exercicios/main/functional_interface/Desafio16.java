package main.functional_interface;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// Desafio 16 - Agrupe os números em pares e ímpares
public class Desafio16 {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);
        
        Map<Boolean, List<Integer>> numerosAgrupados = numeros.stream()
            .distinct()
            .collect(Collectors.partitioningBy(numero -> numero % 2 == 0));

        List<Integer> listaPares = numerosAgrupados.get(true);
        List<Integer> listaImpares = numerosAgrupados.get(false);

        if (listaImpares != null && !listaImpares.isEmpty()) {
            System.out.println("Impares: " + listaImpares);
        } else {
            System.out.println("Nao ha numeros impares na lista.");
        }

        if (listaPares != null && !listaPares.isEmpty()) {
            System.out.println("Pares: " + listaPares);
        } else {
            System.out.println("Nao ha numeros pares na lista.");
        }
    }
}
