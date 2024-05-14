import textwrap
from deposito import *
from saque import *
from pessoa_fisica import * 
from conta_corrente import *
from conta_poupanca import *

def menu():
    menu_selection = """\n
    ================ MENU ================
    [1]\tDepositar
    [2]\tSacar
    [3]\tExtrato
    [4]\tNovo usuário
    [5]\tNova conta
    [6]\tListar contas
    [7]\tExcluir conta
    [8]\tSair
    >>> """

    opcao = input(textwrap.dedent(menu_selection))
    try:
        opcao = int(opcao)
        return opcao
    except:
        print(f'Tipo de dado inválido para a opção, tente novamente.')
        
def log_transacao(func):
    def envelope(*args, **kwargs):
        resultado = func(*args, **kwargs)
        print(f"{datetime.now()}: {func.__name__.upper()}")
        return resultado

    return envelope

def filtrar_cliente(cpf, clientes):
    clientes_filtrados = [cliente for cliente in clientes if cliente.cpf == cpf]
    return clientes_filtrados[0] if clientes_filtrados else None

def recuperar_conta_cliente(cliente):
    if not cliente.contas:
        print("\nCliente não possui conta!")
        return None

    print("Contas do cliente:")
    for i, conta in enumerate(cliente.contas, 1):
        print(f"{i}. {type(conta).__name__} - Número: {i}")

    while True:
        escolha = input("Selecione o número da conta: ")
        try:
            escolha = int(escolha)
            if 1 <= escolha <= len(cliente.contas):
                return cliente.contas[escolha - 1]
            else:
                print("\nFora do intervalo de contas!")
        except ValueError:
            print("\nOpção inválida!")
    return None

@log_transacao
def depositar(clientes):
    cpf = input("Informe o CPF do cliente: ")
    cliente = filtrar_cliente(cpf, clientes)

    if not cliente:
        print("\nCliente não encontrado!")
        return

    conta = recuperar_conta_cliente(cliente)
    if not conta:
        return

    valor = float(input("Informe o valor do depósito: "))
    transacao = Deposito(valor)

    cliente.realizar_transacao(conta, transacao)

@log_transacao
def sacar(clientes):
    cpf = input("Informe o CPF do cliente: ")
    cliente = filtrar_cliente(cpf, clientes)

    if not cliente:
        print("\nCliente não encontrado!")
        return

    conta = recuperar_conta_cliente(cliente)
    if not conta:
        return

    valor = float(input("Informe o valor do saque: "))
    transacao = Saque(valor)

    cliente.realizar_transacao(conta, transacao)

@log_transacao
def exibir_extrato(clientes):
    cpf = input("Informe o CPF do cliente: ")
    cliente = filtrar_cliente(cpf, clientes)

    if not cliente:
        print("\nCliente não encontrado!")
        return

    conta = recuperar_conta_cliente(cliente)
    if not conta:
        return

    print("\n================ EXTRATO ================")
 
    extrato = ""
    tem_transacao = False
    tipo_de_transacao = int(input("Deseja ver: \n"
                              "[1] Apenas saques\n"
                              "[2] Apenas depósitos\n"
                              "[3] Ambos\n"
                              ">>> "))
    
    if tipo_de_transacao == 1:
        for transacao in conta.historico.gerar_relatorio(tipo_transacao="saque"):
            tem_transacao = True
            extrato += f"\n{transacao['data']}\n{transacao['tipo']}: R$ {transacao['valor']:.2f}\n"
        
        if not tem_transacao:
            extrato = "\nSaques não foram realizados até o momento."
    elif tipo_de_transacao == 2:
        for transacao in conta.historico.gerar_relatorio(tipo_transacao="deposito"):
            tem_transacao = True
            extrato += f"\n{transacao['data']}\n{transacao['tipo']}: R$ {transacao['valor']:.2f}\n"
        if not tem_transacao:
            extrato = "\nDepósitos não foram realizados até o momento."
    elif tipo_de_transacao == 3:
        for transacao in conta.historico.gerar_relatorio():
            tem_transacao = True
            extrato += f"\n{transacao['data']}\n{transacao['tipo']}: R$ {transacao['valor']:.2f}\n"
        if not tem_transacao:
            extrato = "\nNenhum tipo de transação foi realizado até o momento."

    print(extrato)
    print(f"\nSaldo: R$ {conta.saldo:.2f}")
    print("==========================================")

@log_transacao
def criar_cliente(clientes):
    cpf = input("Informe o CPF (somente número): ")
    cliente = filtrar_cliente(cpf, clientes)

    if cliente:
        print("\nJá existe cliente com esse CPF!")
        return

    nome = input("Informe o nome completo: ")
    data_nascimento = input("Informe a data de nascimento (dd-mm-aaaa): ")
    endereco = input("Informe o endereço: ")

    cliente = PessoaFisica(nome=nome, data_nascimento=data_nascimento, cpf=cpf, endereco=endereco)

    clientes.append(cliente)

    print("\nCliente criado com sucesso!")

@log_transacao
def criar_conta(numero_conta, clientes, contas):
    cpf = input("Informe o CPF do cliente: ")
    cliente = filtrar_cliente(cpf, clientes)

    if not cliente:
        print("\nCliente não encontrado!")
        return
    tipo_de_conta = input("[CC] - Conta Corrente\n"
                          "[CP] - Conta Poupança\n"
                          ">>> ").lower()
    
    if tipo_de_conta == 'cc':
        conta = ContaCorrente.nova_conta(cliente=cliente, numero=numero_conta)
    elif tipo_de_conta == 'cp':
        conta = ContaPoupanca.nova_conta(cliente=cliente, numero=numero_conta)
    else:
        print(f'Tipo de conta inválida.')
        return

    contas.append(conta)
    cliente.contas.append(conta)

    print("\nConta criada com sucesso!")

def listar_contas(contas, clientes):
    if len(contas) == 0:
        print("\nNão há contas cadastradas até o momento.")
    for conta in contas:
        print("=" * 100)
        if conta.cliente in clientes:
            print(f"Cliente: {conta.cliente.nome}")
            print(f"Tipo de conta: {type(conta).__name__}")
            print(f"Número da conta: {conta.numero}")
            print(f"Saldo: {conta.saldo}")
        else:
            print("Esta conta foi excluída.")

def excluir_conta(clientes, contas):
    cpf = input("Informe o CPF do cliente: ")
    cliente = filtrar_cliente(cpf, clientes)

    if not cliente:
        print("\nCliente não encontrado, fluxo de criação de conta encerrado!")
        return
    
    conta = recuperar_conta_cliente(cliente)
    if conta and conta in cliente.contas:
        cliente.contas.remove(conta)
        contas.remove(conta)  
        print("\nConta excluída com sucesso!")
    else:
        print('\nNão há contas para excluir.')
