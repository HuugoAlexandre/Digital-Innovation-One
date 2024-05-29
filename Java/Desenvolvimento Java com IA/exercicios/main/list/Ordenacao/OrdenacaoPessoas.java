package main.list.Ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class OrdenacaoPessoas {
    private List<Pessoa> listPessoas;

    public OrdenacaoPessoas(){
        this.listPessoas = new ArrayList<>();
    }

    public void adicionarPessoa(String nome, int idade, double altura){
        Pessoa novaPessoa = new Pessoa(nome, idade, altura);
        listPessoas.add(novaPessoa);
    }

    public List<Pessoa> ordenarPorIdade() {
        List<Pessoa> pessoasPorIdade = new ArrayList<>(listPessoas);
        Collections.sort(pessoasPorIdade);
        return pessoasPorIdade;
    }

    public List<Pessoa> ordenarPorAltura() {
        List<Pessoa> pessoasPorAltura = new ArrayList<>(listPessoas);
        Collections.sort(pessoasPorAltura, new ComparatorPorAltura());
        return pessoasPorAltura;
    }

    public static void main(String[] args) {
        OrdenacaoPessoas listaPessoas = new OrdenacaoPessoas();
        listaPessoas.adicionarPessoa("Hugo", 21, 1.68);
        listaPessoas.adicionarPessoa("Luan", 22, 1.73);
        listaPessoas.adicionarPessoa("Gustavo", 21, 1.70);
        listaPessoas.adicionarPessoa("Camila", 23, 1.77);
        listaPessoas.adicionarPessoa("Bia", 19, 1.72);

        System.out.println(listaPessoas.ordenarPorAltura());
        System.out.println(listaPessoas.ordenarPorIdade());
    }
}
