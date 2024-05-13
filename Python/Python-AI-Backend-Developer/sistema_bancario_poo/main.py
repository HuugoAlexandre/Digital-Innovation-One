from funcoes_conta import *

def main():
    clientes = []
    contas = []

    while True:
        opcao = menu()

        if opcao == 1:
            depositar(clientes)

        elif opcao == 2:
            sacar(clientes)

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