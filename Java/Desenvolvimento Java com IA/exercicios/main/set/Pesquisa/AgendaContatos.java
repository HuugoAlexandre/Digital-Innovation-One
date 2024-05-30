import java.util.HashSet;
import java.util.Set;

public class AgendaContatos {
    private Set<Contato> contatoSet;

    public AgendaContatos() {
        this.contatoSet = new HashSet<>();
    }

    public void adicionarContato(String nome, int numero) {
        Contato novoContato = new Contato(nome, numero);
        contatoSet.add(novoContato);
    }

    public void exibirContatos() {
        System.out.println(contatoSet);
    }

    public Set<Contato> pesquisarPorNome(String nome) {
        Set<Contato> contatoPorNome = new HashSet<>();
        for(Contato c : contatoSet) {
            if(c.getNome().startsWith(nome)) {
                contatoPorNome.add(c);
            }
        }
        return contatoPorNome;
    }

    public Contato atualizarNumeroContato(String nome, int novoNumero) {
        Contato contatoAtualizado = null;

        for(Contato c : contatoSet) {
            if(c.getNome().equalsIgnoreCase(nome)) {
                c.setNumero(novoNumero);
                contatoAtualizado = c;
                break;
            }
        }
        return contatoAtualizado;
    }

    public static void main(String[] args) {
        AgendaContatos agendaContatos = new AgendaContatos();

        agendaContatos.adicionarContato("Hugo", 123);
        agendaContatos.adicionarContato("Victor", 456);
        agendaContatos.adicionarContato("Rickelly", 789);
        agendaContatos.adicionarContato("João", 364);
        agendaContatos.exibirContatos();
        agendaContatos.atualizarNumeroContato("João", 999);
        System.out.println(agendaContatos.pesquisarPorNome("Victor"));
        agendaContatos.exibirContatos();
    }
}
