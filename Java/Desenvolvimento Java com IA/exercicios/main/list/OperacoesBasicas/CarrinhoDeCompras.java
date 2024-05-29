package main.list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;


public class CarrinhoDeCompras {
    private List<Item> carrinhoCompras;

    public CarrinhoDeCompras() {
        this.carrinhoCompras = new ArrayList<>();
    }

    public void adicionarItem(String item, double preco, int quantidade) {
        Item novoItem = (new Item(item, preco, quantidade));
        carrinhoCompras.add(novoItem);
    }


    public void removerItem(String nome) {
        List<Item> itensParaRemover = new ArrayList<>();

        for(Item i : carrinhoCompras) {
            if(i.getNome().equalsIgnoreCase(nome)) {
                itensParaRemover.add(i);
            }
        }

        carrinhoCompras.removeAll(itensParaRemover);
    }


    public double calcularValorTotal() {
        double soma = 0;

        for(Item i : carrinhoCompras) {
            soma = soma + (i.getPreco() * i.getQuantidade());
        }

        return soma;
    }

    public void exibirItens() {
        System.out.println(carrinhoCompras);   
    }


    public static void main(String[] args) {
        CarrinhoDeCompras comprinhas = new CarrinhoDeCompras(); 
        comprinhas.adicionarItem("Queijo", 1, 2);
        comprinhas.adicionarItem("Presunto", 2.4, 3);
        comprinhas.exibirItens();
        System.out.println("Valor a pagar: " + comprinhas.calcularValorTotal());
        comprinhas.removerItem("Presunto");
        comprinhas.exibirItens();
        System.out.println("Valor a pagar: " + comprinhas.calcularValorTotal());
    }
}
