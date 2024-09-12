package ContaBanco;

import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Número da conta: ");
        int numeroConta = scanner.nextInt();
        
        System.out.println("Número da agência: ");
        String numeroAgencia = scanner.next();

        System.out.println("Nome do cliente: ");
        String nomeCliente = scanner.next();

        System.out.println("Saldo: ");
        double saldo = scanner.nextDouble();

        System.out.println("Olá " + nomeCliente + ", obrigado por criar uma conta em nosso banco, " +
                "sua agência é " + numeroAgencia + ", conta " + numeroConta + " e seu saldo " + saldo + " já está disponível para saque.");

        scanner.close();        
    }
}
