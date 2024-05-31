package main.map.Pesquisa;

import java.util.HashMap;
import java.util.Map;

public class EstoqueProdutos {
    private Map<Long, Produto> estoqueProdutoMap;
    
    public EstoqueProdutos() {
        this.estoqueProdutoMap = new HashMap<>();
    }

    public void adicionarProduto(long cod, String nome, int quantidade, double preco) {
        Produto novoProduto = new Produto(nome, preco, quantidade);
        estoqueProdutoMap.put(cod, novoProduto);
    }

    public void exibirProdutos() {
        System.out.println(estoqueProdutoMap);
    }

    public double calcularValorTotalEstoque() {
        double valorTotalEstoque = 0d;
        if(!estoqueProdutoMap.isEmpty()) {
            for(Produto p : estoqueProdutoMap.values()) {
                valorTotalEstoque += p.getPreco() * p.getQuantidade();
            }
        }
        return valorTotalEstoque;
    }

    public Produto obterProdutoMaisCaro() {
        Produto produtoMaisCaro = null; 
        double maiorPreco = Double.MIN_VALUE;

        if(!estoqueProdutoMap.isEmpty()) {
            for(Produto p : estoqueProdutoMap.values()) {
                if(p.getPreco() > maiorPreco) {
                    produtoMaisCaro = p;
                    maiorPreco = p.getPreco();
                }
            }
        }
        return produtoMaisCaro;
    }

    public Produto obterProdutoMaisBarato() {
        Produto produtoMaisBarato = null;
        double menorPreco = Double.MAX_VALUE;
        
        if(!estoqueProdutoMap.isEmpty()) {
            for(Produto p : estoqueProdutoMap.values()) {
                if(p.getPreco() < menorPreco) {
                    menorPreco = p.getPreco();
                    produtoMaisBarato = p;
                }
            }
        }
        return produtoMaisBarato;
    }

    public Produto obterProdutoMaiorQuantidadeValorTotalNoEstoque() {
        Produto ProdutoMaiorQuantidadeValorTotalNoEstoque = null;
        double maiorCombinacaoPrecoQuantidade = Double.MIN_VALUE;

        if(!estoqueProdutoMap.isEmpty()) {
            for(Produto p : estoqueProdutoMap.values()) {
                if( p.getPreco() * p.getQuantidade() > maiorCombinacaoPrecoQuantidade) {
                    maiorCombinacaoPrecoQuantidade = p.getPreco() * p.getQuantidade();
                    ProdutoMaiorQuantidadeValorTotalNoEstoque = p;
                }
            }
        }
        return ProdutoMaiorQuantidadeValorTotalNoEstoque;
    }

    public static void main(String[] args) {
        EstoqueProdutos estoqueProdutos = new EstoqueProdutos();

        estoqueProdutos.adicionarProduto(1L, "Desodorante", 10, 1);
        estoqueProdutos.adicionarProduto(2L, "Sabonete", 3, 7.8);
        estoqueProdutos.adicionarProduto(3L, "Condicionador", 12, 2);
        estoqueProdutos.adicionarProduto(4L, "Detergente", 5, 3);
        // estoqueProdutos.exibirProdutos();
        System.out.println(estoqueProdutos.obterProdutoMaisBarato());
        System.out.println(estoqueProdutos.obterProdutoMaisCaro());
        System.out.println(estoqueProdutos.obterProdutoMaiorQuantidadeValorTotalNoEstoque());
        System.out.println(estoqueProdutos.calcularValorTotalEstoque());
    }
}