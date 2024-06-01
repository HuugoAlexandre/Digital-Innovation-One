package main.functional_interface;

import java.util.Arrays;
import java.util.List;

// Desafio 7 - Encontrar o segundo número maior da lista
public class Desafio7 {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);

        Integer segundoMaior = numeros.stream()
                                      .sorted((a, b) -> b.compareTo(a)) // Ordena em ordem decrescente
                                      .skip(1) // Pula o primeiro elemento (maior número)
                                      .findFirst() // Encontra o próximo elemento após pular o primeiro
                                      .orElse(null); // Caso não haja segundo maior número

        System.out.println(segundoMaior);
    }
}
