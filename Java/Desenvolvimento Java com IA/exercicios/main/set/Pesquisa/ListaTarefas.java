import java.util.HashSet;
import java.util.Set;


public class ListaTarefas {
    private Set<Tarefa> tarefaSet;
    
    public ListaTarefas() {
        this.tarefaSet = new HashSet<>();
    }

    public void adicionarTarefa(String descricao, boolean tarefaConcluida) {
        Tarefa novaTarefa = new Tarefa(descricao, tarefaConcluida);
        tarefaSet.add(novaTarefa);
    } 

    public void removerTarefa(String descricao) {
        Tarefa tarefaParaRemover = null;

        for(Tarefa t : tarefaSet) {
            if(t.getDescricao().equalsIgnoreCase(descricao)) {
                tarefaParaRemover = t;
                break;
            }
        }
        tarefaSet.remove(tarefaParaRemover);
    }

    public void exibirTarefas() {
        System.out.println(tarefaSet);
    }

    public int contarTarefas() {
        return tarefaSet.size();
    }

    public Set<Tarefa> obterTarefasConcluidas(){
        Set<Tarefa> tarefasConcluidas = new HashSet<>();

        for(Tarefa t : tarefaSet) {
            if(t.isConcluido() == true) {
                tarefasConcluidas.add(t);
            }
        }
        return tarefasConcluidas;
    }

    public Set<Tarefa> obterTarefasPendentes(){
        Set<Tarefa> tarefasPendentes = new HashSet<>();

        for(Tarefa t : tarefaSet) {
            if(t.isConcluido() == false) {
                tarefasPendentes.add(t);
            }
        }
        return tarefasPendentes;
    }

    public void marcarTarefaConcluida(String descricao) {
        for(Tarefa t : tarefaSet) {
            if(t.getDescricao().equalsIgnoreCase(descricao)) {
                t.setTarefaConcluida(true);
            }
        }
    } 

    public void marcarTarefaPendente(String descricao) {
        for(Tarefa t : tarefaSet) {
            if(t.getDescricao().equalsIgnoreCase(descricao)) {
                t.setTarefaConcluida(false);
            }
        }
    } 

    public void limparListaTarefas() {
        tarefaSet.clear();
    }

    public static void main(String[] args) {
        ListaTarefas listaTarefas = new ListaTarefas();

        listaTarefas.adicionarTarefa("Banho", false);
        listaTarefas.adicionarTarefa("Dentista", false);
        listaTarefas.adicionarTarefa("Escola", false);
        listaTarefas.exibirTarefas();
        System.out.println(listaTarefas.contarTarefas());
        listaTarefas.removerTarefa("Dentista");
        listaTarefas.exibirTarefas();
        System.out.println(listaTarefas.contarTarefas());
        listaTarefas.adicionarTarefa("Assistir", false);
        System.out.println(listaTarefas.obterTarefasConcluidas());
        System.out.println(listaTarefas.obterTarefasPendentes());
        listaTarefas.marcarTarefaConcluida("Assistir");
        System.out.println(listaTarefas.obterTarefasConcluidas());
        System.out.println(listaTarefas.obterTarefasPendentes());
        listaTarefas.exibirTarefas();
        listaTarefas.limparListaTarefas();
        listaTarefas.exibirTarefas();
    }
}
