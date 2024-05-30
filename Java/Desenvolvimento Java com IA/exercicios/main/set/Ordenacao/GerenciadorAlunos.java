package main.set.Ordenacao;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class GerenciadorAlunos {
    private Set<Aluno> alunoSet;

    public GerenciadorAlunos() {
        this.alunoSet = new HashSet<>();
    }

    public void adicionarAluno(String nome, long matricula, double nota) {
        Aluno novoAluno = new Aluno(nome, matricula, nota);
        alunoSet.add(novoAluno);
    } 

    public void removerAluno(long matricula) {
        Aluno alunoParaRemover = null;

        for(Aluno a : alunoSet) {
            if(a.getMatricula() == matricula) {
                alunoParaRemover = a;
                break;
            }
        }
        alunoSet.remove(alunoParaRemover);
    }

    public Set<Aluno> exibirAlunosPorNome() {
        Set<Aluno> alunosPorNome = new TreeSet<>(alunoSet);
        return alunosPorNome;
    }

    public Set<Aluno> exibirAlunosPorNota() {
        Set<Aluno> alunosPorNota = new TreeSet<>(new ComparatorPorNota());
        alunosPorNota.addAll(alunoSet);
        return alunosPorNota;
    }

    public void exibirAlunos() {
        System.out.println(alunoSet);
    }

    public static void main(String[] args) {
        GerenciadorAlunos gerenciadorAlunos = new GerenciadorAlunos();

        gerenciadorAlunos.adicionarAluno("Ana", 9L, 8.5);
        gerenciadorAlunos.adicionarAluno("Hugo", 10L, 7);
        gerenciadorAlunos.adicionarAluno("Maria", 8L, 7.5);
        gerenciadorAlunos.adicionarAluno("Matheus", 8L, 8.5);
        // gerenciadorAlunos.exibirAlunos();
        // System.out.println(gerenciadorAlunos.exibirAlunosPorNome());
        System.out.println(gerenciadorAlunos.exibirAlunosPorNota());
        // gerenciadorAlunos.removerAluno(9L);
        // gerenciadorAlunos.removerAluno(10L);
        // gerenciadorAlunos.removerAluno(8L);
        // gerenciadorAlunos.exibirAlunos();
    }
}
