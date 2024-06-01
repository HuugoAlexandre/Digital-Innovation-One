package main.functional_interface;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;


// BinaryOperator combina dois argumentos do tipo T e retorna um resultado do mesmo tipo T.
 
public class BinaryOperatorExample {
  public static void main(String[] args) {
    List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);

    BinaryOperator<Integer> somar = Integer::sum;

    int resultado = numeros.stream()
        .reduce(0, somar);

    System.out.println("A soma dos números é: " + resultado);
  }
}
