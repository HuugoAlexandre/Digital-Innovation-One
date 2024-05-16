from funcoes_conta import *

def main():
    clientes = []
    contas = []

    while True:
        opcao = menu()
        if isinstance(opcao, int):
            if opcao == 1:
                valor = float(input("Informe o valor do depósito: "))
                depositar(clientes, valor)
            elif opcao == 2:
                valor = float(input("Informe o valor do saque: "))
                sacar(clientes, valor)
            elif opcao == 3:
                exibir_extrato(clientes)
            elif opcao == 4:
                criar_cliente(clientes)
            elif opcao == 5:
                numero_conta = len(contas) + 1
                criar_conta(numero_conta, clientes, contas)
            elif opcao == 6:
                listar_contas(contas, clientes)
            elif opcao == 7:
                excluir_conta(clientes, contas)
            elif opcao == 8:
                break
            else:
                print("\nOperação inválida, por favor selecione novamente a operação desejada.")

main()