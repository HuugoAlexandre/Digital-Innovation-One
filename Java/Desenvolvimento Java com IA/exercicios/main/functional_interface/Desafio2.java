package main.functional_interface;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

// Desafio 2 - Imprima a soma dos números pares da lista
public class Desafio2 {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);

        BinaryOperator<Integer> somar = Integer::sum;
        Predicate<Integer> numerosPares = numero -> numero % 2 == 0;

        int resultado = numeros.stream()
                               .filter(numerosPares)
                               .reduce(0, somar);
     
        System.out.println(resultado);    
    }
}
