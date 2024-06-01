package main.functional_interface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

// Desafio 15 - Verifique se a lista contém pelo menos um número negativo
public class Desafio15 {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);
        
        Predicate<Integer> negativo = numero -> numero < 0;

        List<Integer> negativos = numeros.stream()
        .filter(negativo)
        .toList();

        if(!negativos.isEmpty()) {
            System.out.println("Negativos: " + negativos);
        } else {
            System.out.println("Lista sem numeros negativos.");
        }

    }
}
