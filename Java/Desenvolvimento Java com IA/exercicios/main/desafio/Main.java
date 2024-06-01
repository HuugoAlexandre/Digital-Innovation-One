package main.desafio;

public class Main {

	public static void main(String[] args) {
		Cliente joao = new Cliente();
		joao.setNome("Joao");
		Banco santander = new Banco("Santander");

		Cliente caio = new Cliente();
		caio.setNome("Caio");
		Banco itau = new Banco("Itau");

        Cliente erick = new Cliente();
        erick.setNome("Erick");
        
        
		Conta ccJoao = new ContaCorrente(joao, santander);
		Conta caioPoupanca = new ContaPoupanca(caio, itau);
        Conta erickPoupanca = new ContaPoupanca(erick, itau);

		ccJoao.depositar(400);
		ccJoao.transferir(300, caioPoupanca);
        erickPoupanca.depositar(1000);
        erickPoupanca.sacar(300);
        erickPoupanca.transferir(400, ccJoao);
		
        caioPoupanca.imprimirExtrato();
        ccJoao.imprimirExtrato();
        erickPoupanca.imprimirExtrato();

		System.out.println("Contas do Banco Santander:");
		for (Conta conta : santander.getContas()) {
			System.out.println("Número da conta: " + conta.getNumero() + ", Titular: " + conta.cliente.getNome());
		}

		System.out.println("Contas do Banco Itau:");
		for (Conta conta : itau.getContas()) {
			System.out.println("Numero da conta: " + conta.getNumero() + ", Titular: " + conta.cliente.getNome());
		}
	}
}
