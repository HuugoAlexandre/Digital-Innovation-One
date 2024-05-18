from cliente import Cliente


class PessoaFisica(Cliente):
    def __init__(self, nome, data_nascimento, cpf, endereco):
        super().__init__(endereco)
        self.nome = nome
        self.data_nascimento = data_nascimento
        self.cpf = cpf

    def __repr__(self) -> str:
        return (
            f"PessoaFisica(nome='{self.nome}', cpf='{self.cpf}, data_nascimento={self.data_nascimento}',"
            f"endereço={self.endereco})"
        )
