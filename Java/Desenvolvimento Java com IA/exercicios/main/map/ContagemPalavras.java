package main.map;

import java.util.HashMap;
import java.util.Map;

public class ContagemPalavras {
    private Map<String, Integer> contagemPalavrasMap;

    public ContagemPalavras() {
        this.contagemPalavrasMap = new HashMap<>();
    }

    public void adicionarPalavra(String palavra) {
        if (contagemPalavrasMap.containsKey(palavra)) {
            contagemPalavrasMap.put(palavra, contagemPalavrasMap.get(palavra) + 1);
        } else {
            contagemPalavrasMap.put(palavra, 1);
        }
    }

    public void removerPalavra(String palavra) {
       if(!contagemPalavrasMap.isEmpty()) {
        contagemPalavrasMap.remove(palavra);
       } 
    }

    public Map<String, Integer> encontrarPalavraMaisFrequente() {
        Map<String, Integer> maisFrequente = new HashMap<>();
        Integer maiorFrequencia = Integer.MIN_VALUE;

        if (!contagemPalavrasMap.isEmpty()) {
            for (Integer frequencia : contagemPalavrasMap.values()) {
                if (frequencia > maiorFrequencia) {
                    maiorFrequencia = frequencia;
                }
            }

            for (Map.Entry<String, Integer> entrada : contagemPalavrasMap.entrySet()) {
                if (entrada.getValue().equals(maiorFrequencia)) {
                    maisFrequente.put(entrada.getKey(), entrada.getValue());
                }
            }
        }

        return maisFrequente;
    }
    public void exibirContagemPalavras() {
        System.out.println(contagemPalavrasMap);
    }

    public static void main(String[] args) {
        ContagemPalavras contagemPalavras = new ContagemPalavras();

        contagemPalavras.adicionarPalavra("Oi");
        contagemPalavras.adicionarPalavra("Oi");
        contagemPalavras.adicionarPalavra("Oi");
        contagemPalavras.adicionarPalavra("IAE");
        contagemPalavras.exibirContagemPalavras();
        System.out.println(contagemPalavras.encontrarPalavraMaisFrequente());
        contagemPalavras.removerPalavra("Oi");
        contagemPalavras.exibirContagemPalavras();
        System.out.println(contagemPalavras.encontrarPalavraMaisFrequente());
    }
}
