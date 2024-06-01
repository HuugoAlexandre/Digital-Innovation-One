package main.functional_interface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;


// Desafio 6 - Verificar se a lista contém algum número maior que 10
public class Desafio6 {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);

        Predicate<Integer> numerosMaioresQueDez = numero -> numero > 10;
        
        numeros.stream()
        .filter(numerosMaioresQueDez)
        .forEach(System.out::println);
    }
}
