package main.functional_interface;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

// Encontre o maior número primo da lista
public class Desafio14 {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);

        Predicate<Integer> primos = numero -> numero % 2 != 0;
        
        Optional<Integer> maximo = numeros.stream()
                                          .filter(primos)
                                          .max(Integer::compareTo);

        if(maximo.isPresent()){
            System.out.println(maximo);
        } else {
            System.out.println("Lista vazia.");
        }
    }
}
