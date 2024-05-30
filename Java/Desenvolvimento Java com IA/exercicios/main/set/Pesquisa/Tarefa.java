import java.util.Objects;

public class Tarefa {
    private String descricao;
    private boolean tarefaConcluida;

    public Tarefa(String descricao, boolean tarefaConcluida) {
        this.descricao = descricao;
        this.tarefaConcluida = tarefaConcluida;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setTarefaConcluida(boolean tarefaConcluida) {
        this.tarefaConcluida = tarefaConcluida;
    }

    public boolean isConcluido() {
        return tarefaConcluida;
    }
    
    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(!(obj instanceof Tarefa tarefa)) return false;
        return getDescricao() == tarefa.getDescricao(); 
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDescricao());
    }

    @Override
    public String toString() {
        return "Desc: " + descricao + "| Status: " + tarefaConcluida;
    }
}
