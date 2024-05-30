package main.set.Ordenacao;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class CadastroProdutos {
    private Set<Produto> produtoSet;
    

    public CadastroProdutos(){
        this.produtoSet = new HashSet<>();
    }
    
    public void adicionarProduto(long cod, String nome, double preco, int quantidade) {
        Produto novoProduto = new Produto(cod, nome, preco, quantidade);
        produtoSet.add(novoProduto);
    }

    public Set<Produto> exibirProdutosPorNome() {
        Set<Produto> produtosPorNome = new TreeSet<>(produtoSet);
        return produtosPorNome;
    }

    public Set<Produto> exibirProdutosPorPreco() {
        Set<Produto> produtosPorPreco = new TreeSet<>(new ComparatorPorPreco());
        produtosPorPreco.addAll(produtoSet);
        return produtosPorPreco;
    }
    

    public static void main(String[] args) {
        CadastroProdutos cadastroProdutos = new CadastroProdutos();

        cadastroProdutos.adicionarProduto(1L, "Monitor", 800, 1);
        cadastroProdutos.adicionarProduto(2L, "Teclado", 150, 1);
        cadastroProdutos.adicionarProduto(3L, "Nescau Cereal", 7.5, 4);
        cadastroProdutos.adicionarProduto(3L, "Nescau Cereal", 7.2, 6);
        System.out.println(cadastroProdutos.exibirProdutosPorNome());
        // System.out.println(cadastroProdutos.exibirProdutosPorPreco());
    }
}
