package main.functional_interface;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;


// Supplier não aceita nenhum argumento e retorna um resultado do tipo T.

public class SupplierExample {
  public static void main(String[] args) {
    Supplier<String> saudacao = () -> "Olá, seja bem-vindo(a)!";

    List<String> listaSaudacoes = Stream.generate(saudacao)
        .limit(5)
        .toList();

    listaSaudacoes.forEach(System.out::println);
  }
}
