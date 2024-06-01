package main.functional_interface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Desafio11 {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);
        
        Function<Integer, Integer> quadradro = numero -> numero * numero;

        numeros.stream().map(quadradro).forEach(System.out::println);
    }
}
