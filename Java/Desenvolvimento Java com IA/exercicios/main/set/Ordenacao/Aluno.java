package main.set.Ordenacao;

import java.util.Comparator;
import java.util.Objects;

public class Aluno implements Comparable<Aluno> {
    private String nome;
    private long matricula;
    private double nota;

    public Aluno(String nome, long matricula, double nota) {
        this.nome = nome;
        this.matricula = matricula;
        this.nota = nota;
    }

    public long getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }
    
    public double getNota() {
        return nota;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(!(obj instanceof Aluno aluno)) return false;
        return getMatricula() == aluno.getMatricula();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMatricula());
    }

    @Override
    public int compareTo(Aluno a) {
        return nome.compareToIgnoreCase(a.getNome());
    }

    @Override
    public String toString() {
        return "\nNome: " + nome + "\nMatricula: " + matricula + "\nNota: " + nota + "\n\n";

    }
}

class ComparatorPorNota implements Comparator<Aluno> {
    @Override
    public int compare(Aluno p1, Aluno p2) {
        return Double.compare(p1.getNota(), p2.getNota());
    }
}
