saldo = 0
limite = 500
extrato = ''
numero_saques = 0
LIMITE_SAQUES = 3

def depositar(valor, saldo_atual, extrato_atual):
    if valor <= 0:
        print(f'Não é possível depositar valores inferiores ou igual a zero.')
    else:
        saldo_atual += valor
        extrato_atual += f'\nDepósito: R$ {valor:.2f}'
        print(f'A quantia de R$ {valor:.2f} foi depositada com sucesso!')

    return saldo_atual, extrato_atual

def sacar(valor, saldo_atual, extrato_atual, numero_saques):
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

def registro():
    print('\n======== EXTRATO ========')
    print(extrato)
    print(f'\n\nSaldo: R$ {saldo:.2f}')

menu = """
[1] depositar
[2] sacar
[3] extrato
[4] sair
> """

while True:
    opcao = int(input(menu))

    if opcao == 1:
        valor = float(input('Valor a ser depositado: '))
        saldo, extrato = depositar(valor, saldo, extrato)
    elif opcao == 2:
        valor = float(input('\nValor a ser sacado: '))
        saldo, extrato, numero_saques = sacar(valor, saldo, extrato, numero_saques)
    elif opcao == 3:
        registro()
    elif opcao == 4:
        break
    else:
        print('Valor inválido, por favor, insira uma opção válida.')
