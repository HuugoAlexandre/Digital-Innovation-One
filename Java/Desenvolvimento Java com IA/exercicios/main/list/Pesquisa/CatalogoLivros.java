package main.list.Pesquisa;

import java.util.ArrayList;
import java.util.List;

public class CatalogoLivros {
    private List<Livro> livroList;

    public CatalogoLivros() {
        this.livroList = new ArrayList<>();
    }

    public void adicionarLivro(String titulo, String autor, int ano){
        Livro novoLivro = new Livro(titulo, autor, ano);
        livroList.add(novoLivro);
    }

    public List<Livro> pesquisarPorAutor(String autor) {
        List<Livro> livrosPorAutor = new ArrayList<>();
        if(!livroList.isEmpty()) {
            for(Livro l : livroList) {
                if(l.getAutor().equalsIgnoreCase(autor)) {
                    livrosPorAutor.add(l);
                }
            }
        }

        return livrosPorAutor;
    }

    public List<Livro> pesquisarPorIntervaloAnos(int anoInicio, int anoTermino) {
        List<Livro> livrosPorIntervaloAnos = new ArrayList<>();
        if(!livroList.isEmpty()) {
            for(Livro l : livroList) {
                if(l.getAno() >= anoInicio && l.getAno() <= anoTermino) {
                    livrosPorIntervaloAnos.add(l);
                }
            }
        }

        return livrosPorIntervaloAnos;
    }

    public Livro pesquisarPorTitulo(String titulo) {
        Livro primeiroLivroEncontrado = null;
        if(!livroList.isEmpty()) {
            for(Livro l : livroList) {
                if(l.getTitulo().equalsIgnoreCase(titulo)) {
                    primeiroLivroEncontrado = l;
                    break;
                }
            }
        }

        return primeiroLivroEncontrado;
    }

    public static void main(String[] args) {
        CatalogoLivros catalogoLivros = new CatalogoLivros();
        catalogoLivros.adicionarLivro("Tokyo Ghoul", "Sui Ishida", 2014);
        catalogoLivros.adicionarLivro("Berserk", "Kentaro Miura", 1989);
        catalogoLivros.adicionarLivro("Vagabond", "Takehiko Inoue", 1999);
        catalogoLivros.adicionarLivro("Attack on Titan", "Hajime Isayama", 2009);
        catalogoLivros.adicionarLivro("Attack on Titan", "Hajime Isayama", 2010);
        catalogoLivros.adicionarLivro("Attack on Titan: Before the fall", "Hajime Isayama", 2014);
        
        System.out.println(catalogoLivros.pesquisarPorAutor("Hajime Isayama"));
        System.out.println(catalogoLivros.pesquisarPorIntervaloAnos(1900, 2000));
        System.out.println(catalogoLivros.pesquisarPorTitulo("Attack on Titan"));
    }
}
