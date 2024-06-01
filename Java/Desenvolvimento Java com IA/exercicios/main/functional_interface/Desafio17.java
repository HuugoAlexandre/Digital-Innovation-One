package main.functional_interface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

// Desafio 17 - Filtrar os números primos da lista
public class Desafio17 {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);

        Predicate<Integer> numerosPrimos = numero -> numero % 2 != 0;

        numeros.stream()
        .filter(numerosPrimos)
        .distinct()
        .forEach(System.out::println);
    }
}
