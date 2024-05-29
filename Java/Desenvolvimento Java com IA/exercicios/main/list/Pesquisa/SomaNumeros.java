package main.list.Pesquisa;

import java.util.ArrayList;
import java.util.List;

public class SomaNumeros {
    private List<Integer> listNumeros;

    public SomaNumeros() {
        this.listNumeros = new ArrayList<>();
    }

    public void adicionarNumero(int numero) {
        listNumeros.add(numero);
    }

    public int calcularSoma() {
        int soma = 0;
        if(!listNumeros.isEmpty()) {
            for(Integer i : listNumeros) {
                soma = soma + i;
            }
        }
        return soma;
    }

    public int encontrarMaiorNumero() {
        int maior = Integer.MIN_VALUE;

        if(!listNumeros.isEmpty()) {
            for(Integer i : listNumeros) {
                if(i > maior) {
                    maior = i;
                }
            }
        }
        return maior;
    }

    public int encontrarMenorNumero() {
        int menor = Integer.MAX_VALUE;

        if(!listNumeros.isEmpty()) {
            for(Integer i : listNumeros) {
                if(i < menor) {
                    menor = i;
                }
            }
        }
        return menor;
    }

    public List<Integer> exibirNumeros() {
        return listNumeros;
    }

    public static void main(String[] args) {
        SomaNumeros somador = new SomaNumeros();

        somador.adicionarNumero(2);
        somador.adicionarNumero(3);
        somador.adicionarNumero(1);
        somador.adicionarNumero(4);
        somador.adicionarNumero(7);
        somador.adicionarNumero(6);
        System.out.println(somador.exibirNumeros());
        System.out.println(somador.calcularSoma());
        System.out.println(somador.encontrarMenorNumero());
        System.out.println(somador.encontrarMaiorNumero());
    }
}
