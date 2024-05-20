class Cliente:
    def __init__(self, endereco):
        self.endereco = endereco
        self.contas = []
        self.indice = 0

    def realizar_transacao(self, conta, transacao):
        print(f"tamanho: {len(conta.historico.transacoes_do_dia())}")
        if len(conta.historico.transacoes_do_dia()) >= 2:
            print("Número máximo diário de transações atingido.")
            return

        transacao.registrar(conta)

    def adicionar_conta(self, conta):
        self.contas.append(conta)
