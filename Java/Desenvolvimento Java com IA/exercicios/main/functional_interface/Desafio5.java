package main.functional_interface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;


// Desafio 5 - Calcule a média dos números maiores que 5
public class Desafio5 {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);

        Predicate<Integer> numerosMaioresQueCinco = numero -> numero > 5;

        double media = numeros.stream()
                              .filter(numerosMaioresQueCinco)
                              .mapToInt(Integer::intValue)
                              .average()
                              .orElse(Double.NaN);

        System.out.println(media);
        }
}
