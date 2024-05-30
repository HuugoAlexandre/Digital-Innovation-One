package main.set.OperacoesBasicas;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoConvidados {
    private Set<Convidado> convidadoSet;

    public ConjuntoConvidados() {
        this.convidadoSet = new HashSet<>();
    }

    public void adicionarConvidado(String nome, int codigoConvite) {
        Convidado novoConvidado = new Convidado(nome, codigoConvite);
        convidadoSet.add(novoConvidado);
    }

    public void removerConvidadoPorCodigoConvite(int codigoConvite) {
        Convidado convidadoParaRemover = null;
        for(Convidado c: convidadoSet){
            if(c.getCodigoConvite() == codigoConvite) {
                convidadoParaRemover = c;
                break;
            } else {
                System.out.println("Nao ha convidado com esse codigo.");
            }
        }
        convidadoSet.remove(convidadoParaRemover);
    }

    public int contarConvidados() {
        return convidadoSet.size();
    }

    public void exibirConvidados() {
        System.out.println(convidadoSet);
    }

    public static void main(String[] args) {
        ConjuntoConvidados conjuntoConvidados = new ConjuntoConvidados();
        System.out.println("Quantidade de convidados: " + conjuntoConvidados.contarConvidados());
        conjuntoConvidados.adicionarConvidado("Felipe", 1);
        conjuntoConvidados.adicionarConvidado("Arthur", 2);
        conjuntoConvidados.adicionarConvidado("Hugo", 2);
        System.out.println("Quantidade de convidados: " + conjuntoConvidados.contarConvidados());
        conjuntoConvidados.exibirConvidados();
        conjuntoConvidados.adicionarConvidado("Vini", 3);
        conjuntoConvidados.removerConvidadoPorCodigoConvite(1);
        conjuntoConvidados.contarConvidados();
        conjuntoConvidados.exibirConvidados();
        conjuntoConvidados.adicionarConvidado("Pame", 1);
        conjuntoConvidados.contarConvidados();
        conjuntoConvidados.exibirConvidados();
    }
}
