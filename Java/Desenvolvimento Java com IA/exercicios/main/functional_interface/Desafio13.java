package main.functional_interface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

// Filtrar os números que estão dentro de um intervalo
public class Desafio13 {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);
        
        Predicate<Integer> entreCincoDez = numero -> numero >= 5 && numero <= 10;

        List<Integer> listaIntervalo = numeros.stream()
        .filter(entreCincoDez)
        .distinct()
        .toList();

        System.out.println(listaIntervalo);
        
    }
}
