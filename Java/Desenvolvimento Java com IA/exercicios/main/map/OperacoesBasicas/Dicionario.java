package main.map.OperacoesBasicas;

import java.util.HashMap;
import java.util.Map;

public class Dicionario {
    private Map<String, String> dicionario;

      public Dicionario() {
        this.dicionario = new HashMap<>();
      }

      public void adicionarPalavra(String palavra, String definicao) {
        palavra = palavra.toLowerCase();
        dicionario.put(palavra, definicao);
      }

      public void removerPalavra(String palavra) {
        palavra = palavra.toLowerCase();
        if(!dicionario.isEmpty()) {
            dicionario.remove(palavra);
        }
      }

      public void exibirPalavras() {
        System.out.println(dicionario);
      }

      public String pesquisarPorPalavra(String palavra) {
        palavra = palavra.toLowerCase();
        String definicaoPorNome = null;
        if(!dicionario.isEmpty()) {
            definicaoPorNome = dicionario.get(palavra);
        }
        return definicaoPorNome;
      }

      public static void main(String[] args) {
        Dicionario dicionario = new Dicionario();

        dicionario.adicionarPalavra("Hugo", "Uma pessoa");
        dicionario.adicionarPalavra("Caneta", "Um objeto");
        dicionario.adicionarPalavra("CaJu", "Uma fruta");
        dicionario.adicionarPalavra("Paladins", "Um jogo");
        dicionario.removerPalavra("CajU");
        System.out.println(dicionario.pesquisarPorPalavra("PAladins"));
        dicionario.exibirPalavras();
      }
}
