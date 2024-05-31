package main.map.Ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LivrariaOnline {
    private Map<String, Livro> livrariaOnline;

    public LivrariaOnline() {
        this.livrariaOnline = new HashMap<>();
    }

    public void adicionarLivro(String link, Livro livro) {
        livrariaOnline.put(link, livro);
    }

    public void removerLivro(String titulo) {
        List<String> chavesRemover = new ArrayList<>();
        for (Map.Entry<String, Livro> entry : livrariaOnline.entrySet()) {
            if (entry.getValue().getTitulo().equalsIgnoreCase(titulo)) {
                chavesRemover.add(entry.getKey());
        }
    }

        for (String chave : chavesRemover) {
            livrariaOnline.remove(chave);
        }
    }

    public Map<String, Livro> exibirLivrosOrdenadosPorPreco() {
        List<Map.Entry<String, Livro>> livrosParaOrdenarPorPreco = new ArrayList<>(livrariaOnline.entrySet());
        
        Collections.sort(livrosParaOrdenarPorPreco, new ComparatorPorPreco());
       
        Map<String, Livro> livrosOrdenadosPorPreco = new LinkedHashMap<>();
        
        for (Map.Entry<String, Livro> entry : livrosParaOrdenarPorPreco) {
            livrosOrdenadosPorPreco.put(entry.getKey(), entry.getValue());
        }

    return livrosOrdenadosPorPreco;
    }

    public Map<String, Livro> exibirLivrosOrdenadosPorAutor() {
        List<Map.Entry<String, Livro>> livrosParaOrdenarPorAutor = new ArrayList<>(livrariaOnline.entrySet());
    
        Collections.sort(livrosParaOrdenarPorAutor, new ComparatorPorAutor());
    
        Map<String, Livro> livrosOrdenadosPorAutor = new LinkedHashMap<>();
    
        for (Map.Entry<String, Livro> entry : livrosParaOrdenarPorAutor) {
          livrosOrdenadosPorAutor.put(entry.getKey(), entry.getValue());
        }
    
        return livrosOrdenadosPorAutor;
      }

    public Map<String, Livro> pesquisarLivrosPorAutor(String autor) {
    Map<String, Livro> livrosPorAutor = new LinkedHashMap<>();
    for (Map.Entry<String, Livro> entry : livrariaOnline.entrySet()) {
        Livro livro = entry.getValue();
        if (livro.getAutor().equals(autor)) {
            livrosPorAutor.put(entry.getKey(), livro);
        }
    }
    return livrosPorAutor;
    }

    public Livro obterLivroMaisCaro() {
        Livro livroMaisCaro = null;
        double maiorValor = Double.MIN_VALUE;

        for (Map.Entry<String, Livro> entry : livrariaOnline.entrySet()) {
            Livro livro = entry.getValue();
            if (entry.getValue().getPreco() > maiorValor) {
                maiorValor = entry.getValue().getPreco();
                livroMaisCaro = livro;
            }
        }
        return livroMaisCaro;
    }

    public Livro obterLivroMaisBarato() {
        Livro livroMaisBarato = null;
        double menorValor = Double.MAX_VALUE;

        for (Map.Entry<String, Livro> entry : livrariaOnline.entrySet()) {
            Livro livro = entry.getValue();
            if (entry.getValue().getPreco() < menorValor) {
                menorValor = entry.getValue().getPreco();
                livroMaisBarato = livro;
            }
        }
        return livroMaisBarato;
    } 


    public static void main(String[] args) {
        LivrariaOnline livrariaOnline = new LivrariaOnline();

        livrariaOnline.adicionarLivro("https://a.co/d/9cNUhRG", new Livro("Berserk Vol 1", "Kentaro Miura", 29.84));
        livrariaOnline.adicionarLivro("https://a.co/d/hQNlfV4", new Livro("Attack on Titan Season 1 Part 1", "Hajime Isayama", 151.43));
        livrariaOnline.adicionarLivro("https://a.co/d/aXk5N0h", new Livro("Vagabond - Volume 31", "Takehiko Inoue", 29.90));
        livrariaOnline.adicionarLivro("https://a.co/d/5sJfoKX", new Livro("Monster Kanzenban Vol. 1", "Naoki Urasawa", 79.00));
        livrariaOnline.adicionarLivro("https://a.co/d/60gZGKZ", new Livro("Box Tokyo Ghoul Vols. 1 ao 14", "Sui Ishida", 355.95));
        
        System.out.println("Livros ordenados por preço: \n" + livrariaOnline.exibirLivrosOrdenadosPorPreco());
        // System.out.println(livrariaOnline.pesquisarLivrosPorAutor("Kentaro Miura"));
        // System.out.println("Livro mais caro: " + livrariaOnline.obterLivroMaisCaro());
        // System.out.println("Livro mais barato: " + livrariaOnline.obterLivroMaisBarato());
        // System.out.println("Livros ordenados por autor: \n" + livrariaOnline.exibirLivrosOrdenadosPorAutor());
        
        // livrariaOnline.removerLivro("Vagabond - Volume 31");
        // System.out.println(livrariaOnline.livrariaOnline);
    }
}
