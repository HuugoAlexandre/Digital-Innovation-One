AGENCIA = "0001"
LIMITE_SAQUES = 3
saldo = 0
limite = 500
extrato = ''
numero_saques = 0
usuarios = []
contas = []
numero_conta = 0

def depositar(valor, saldo_atual, extrato_atual):
    if valor <= 0:
        print(f'Não é possível depositar valores inferiores ou igual a zero.')
    else:
        saldo_atual += valor
        extrato_atual += f'\nDepósito: R$ {valor:.2f}'
        print(f'A quantia de R$ {valor:.2f} foi depositada com sucesso!')

    return saldo_atual, extrato_atual

def sacar(*, valor, saldo_atual, extrato_atual, numero_saques):
    if valor > saldo_atual:
        print(f'A quantia R$ {valor} está acima do saldo atual ( R$ {saldo_atual} ).')
    elif numero_saques >= LIMITE_SAQUES:
        print('Você já atingiu o número diário de saques.')
    elif valor > 500:
        print('Você não pode realizar saques acima de R$ 500,00.')
    else:
        saldo_atual -= valor
        extrato_atual += f'\nSaque: R$ {valor:.2f}'
        print(f'O saque de R$ {valor:.2f} foi realizado com sucesso!')
        numero_saques += 1

    return saldo_atual, extrato_atual, numero_saques

def registro(saldo, /, *, extrato):
    print('\n======== EXTRATO ========')
    print(extrato)
    print(f'\n\nSaldo: R$ {saldo:.2f}')

def filtrar_usuario(cpf, usuarios):
    for usuario in usuarios:
        if usuario["cpf"] == cpf:
            return usuario
    return None

def criar_usuario(usuarios):
    cpf = input('CPF: ')
    if filtrar_usuario(cpf, usuarios):
        print('Já existe uma conta registrada com esse CPF.')
        return
    
    nome = input('Nome: ')
    data_nascimento = input('Data de nascimento: ')
    endereco = input('Endereço: ')

    novo_usuario = {"nome": nome, "data_nascimento": data_nascimento, "cpf": cpf, "endereco": endereco}
    usuarios.append(novo_usuario)
    print('Usuário cadastrado com sucesso!')

def criar_conta(agencia, numero_conta, usuarios):
    cpf = input('CPF: ')
    usuario = filtrar_usuario(cpf, usuarios)

    if usuario:
        print('Conta criada com sucesso!')
        return {"agencia": agencia, "numero_conta": numero_conta, "usuario": usuario}

    print('Usuário não encontrado...')

def listar_contas():
    for conta in contas:
        print(f'\nAgência: {conta["agencia"]}'
              f'\nC/C: {conta["numero_conta"]}'
              f'\nTitular: {conta["usuario"]["nome"]}')

menu = """
[1] depositar
[2] sacar
[3] extrato
[4] criar usuário
[5] criar conta
[6] listar contas
[7] sair

> """

while True:
    opcao = int(input(menu))

    if opcao == 1:
        valor = float(input('Valor a ser depositado: '))
        saldo, extrato = depositar(valor, saldo, extrato)
    elif opcao == 2:
        valor = float(input('\nValor a ser sacado: '))
        saldo, extrato, numero_saques = sacar(valor=valor,saldo_atual=saldo, extrato_atual=extrato, numero_saques=numero_saques)
    elif opcao == 3:
        registro(saldo, extrato=extrato)
    elif opcao == 4:
        criar_usuario(usuarios)
    elif opcao == 5:
        conta = criar_conta(AGENCIA, numero_conta, usuarios)
        if conta:
            contas.append(conta)
            numero_conta += 1
    elif opcao == 6:
        listar_contas()
    elif opcao == 7:
        break
    else:
        print('Valor inválido, por favor, insira uma opção válida.')