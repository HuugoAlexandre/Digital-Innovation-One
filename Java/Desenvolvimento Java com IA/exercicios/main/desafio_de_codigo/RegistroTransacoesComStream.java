import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RegistroTransacoesComStream {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double saldo = scanner.nextDouble();
        
        int quantidadeTransacoes = scanner.nextInt();

        List<Transacao> transacoes = new ArrayList<>();

        for (int i = 1; i <= quantidadeTransacoes; i++) {
            char tipoTransacao = scanner.next().toUpperCase().charAt(0);
            double valorTransacao = scanner.nextDouble();

            transacoes.add(new Transacao(tipoTransacao, valorTransacao));
        }

        System.out.println("Saldo : " + calcularSaldoFinal(saldo, transacoes));
        System.out.println("Transacoes:");
        transacoes.forEach(System.out::println);

        scanner.close();
    }


    private static double calcularSaldoFinal(double saldoInicial, List<Transacao> transacoes) {
        return transacoes.stream()
                .mapToDouble(transacao -> transacao.getTipo() == 'D' ? transacao.getValor() : -transacao.getValor())
                .sum() + saldoInicial;
    }
}

class Transacao {
    private char tipo;
    private double valor;

    public Transacao(char tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    public char getTipo() {
        return tipo;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return (tipo == 'D' ? "d de " : "s de ") + valor;
    }
}
