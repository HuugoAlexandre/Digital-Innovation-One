package main.list.Ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoNumeros {
    private List<Inteiro> listInt;

    public OrdenacaoNumeros() {
        this.listInt = new ArrayList<>();
    }

    public void adicionarNumero(int numero) {
        Inteiro novoInteiro = new Inteiro(numero);
        listInt.add(novoInteiro);
    }

    public List<Inteiro> ordenarAscendente() {
        List<Inteiro> listOrd = new ArrayList<>(listInt);
        Collections.sort(listOrd);
        return listOrd;
    }

    public List<Inteiro> ordenarDescendente() {
        List<Inteiro> listOrd = new ArrayList<>(listInt);
        Collections.sort(listOrd, Collections.reverseOrder());
        return listOrd;
    }

    @Override
    public String toString() {
        return listInt.toString();
    }

    public static void main(String[] args) {
        OrdenacaoNumeros listaNumeros = new OrdenacaoNumeros();
        listaNumeros.adicionarNumero(0);
        listaNumeros.adicionarNumero(4);
        listaNumeros.adicionarNumero(5);
        listaNumeros.adicionarNumero(2);
        listaNumeros.adicionarNumero(3);
        System.out.println(listaNumeros);
        System.out.println(listaNumeros.ordenarAscendente());
        System.out.println(listaNumeros.ordenarDescendente());
    }
}
