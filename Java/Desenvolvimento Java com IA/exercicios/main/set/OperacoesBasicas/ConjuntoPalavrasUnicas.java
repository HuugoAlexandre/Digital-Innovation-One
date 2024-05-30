package main.set.OperacoesBasicas;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoPalavrasUnicas {
    private Set<String> palavrasUnicasSet;

    public ConjuntoPalavrasUnicas() {
        this.palavrasUnicasSet = new HashSet<>();
    }

    public void adicionarPalavra(String palavra) {
        palavrasUnicasSet.add(palavra);
    }

    public void removerPalavra(String palavra) {
        palavrasUnicasSet.remove(palavra);
    }

    public boolean verificarPalavra(String palavra) {
        return palavrasUnicasSet.contains(palavra);
    }

    public void exibirPalavrasUnicas() {
        System.out.println(palavrasUnicasSet);
    }

    public static void main(String[] args) {
        ConjuntoPalavrasUnicas conjuntoPalavras = new ConjuntoPalavrasUnicas();

        conjuntoPalavras.adicionarPalavra("Sorvete");
        conjuntoPalavras.adicionarPalavra("Pudim");
        conjuntoPalavras.adicionarPalavra("Celular");
        conjuntoPalavras.adicionarPalavra("Pudim");
        conjuntoPalavras.exibirPalavrasUnicas();
        conjuntoPalavras.removerPalavra("Pudim");
        conjuntoPalavras.exibirPalavrasUnicas();
        System.out.println(conjuntoPalavras.verificarPalavra("Sorvete"));
        System.out.println(conjuntoPalavras.verificarPalavra("Pudim"));
    }
}
