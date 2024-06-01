package main.functional_interface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;


// Consumer aceita um argumento T e não retorna nenhum resultado
public class ConsumerExample {
    public static void main(String[] args) {

      List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);

      @SuppressWarnings("unused")
      Consumer<Integer> imprimirNumeroPar = numero -> {
          if (numero % 2 == 0) {
            System.out.println(numero);
          }
        };

        numeros.stream()
            .filter(n -> n % 2 == 0)
            .forEach(System.out::println);
      }
  }