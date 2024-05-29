package main.list.Ordenacao;

public class Inteiro implements Comparable<Inteiro> {
    private int valor;

    public Inteiro(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    @Override
    public int compareTo(Inteiro outro) {
        return Integer.compare(this.valor, outro.valor);
    }

    @Override
    public String toString() {
        return String.valueOf(valor);
    }
}
