package main.map.Ordenacao;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


public class AgendaEventos {
    private Map<LocalDate, Evento> agendaEventosMap;

    public AgendaEventos() {
        this.agendaEventosMap = new HashMap<>();
    }

    public void adicionarEvento(LocalDate data, String nome, String atracao) {
        Evento novoEvento = new Evento(nome, atracao);
        agendaEventosMap.put(data, novoEvento);
    }

    public void obterProximoEvento() {
        LocalDate dataAtual = LocalDate.now();
        LocalDate proximaData = null;
        Evento proximoEvento = null;
        for (Map.Entry<LocalDate, Evento> entry : agendaEventosMap.entrySet()) {
          LocalDate dataEvento = entry.getKey();
          if (dataEvento.isEqual(dataAtual) || dataEvento.isAfter(dataAtual)) {
            proximaData = dataEvento;
            proximoEvento = entry.getValue();
            break;
          }
        }
        if (proximoEvento != null) {
          System.out.println("O próximo evento: " + proximoEvento.getNomeEvento() + " acontecerá na data " + proximaData);
        } else {
          System.out.println("Não há eventos futuros na agenda.");
        }
      }

    public void exibirAgenda() {
        Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(agendaEventosMap);
        System.out.println(eventosTreeMap);
    }


    public static void main(String[] args) {
        AgendaEventos agendaEventos = new AgendaEventos();

        agendaEventos.adicionarEvento(LocalDate.of(2024, 05, 20), "Aniversario do tio", "Tios de fora");
        agendaEventos.adicionarEvento(LocalDate.of(2024, 12, 25), "Natal", "Papai Noel");
        agendaEventos.adicionarEvento(LocalDate.of(2024, 01, 01), "Ano novo", "Sla");
        
        agendaEventos.exibirAgenda();
        agendaEventos.obterProximoEvento();
    }
}
