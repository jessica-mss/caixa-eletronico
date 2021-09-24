# Caixa Multibanco Eletrônico 

## Projeto Accenture Academia Java Fast 

A equipe nº 3, da academia Java fast da Accenture, que teve como desafio o case 3, referente a construção de uma API REST, 
em que o cliente poderá cadastrar, alterar, remover e realizar consultas, tal qual um caixa eletrônico, 
o projeto será desenvolvido em Spring Boot que roda em servidor local com conexão ao banco de dados MySQL. 
A referida API simula uma operação de um caixa eletrônico podendo o usuário realizar certas operações como: login, consulta de saldo, saque...

## Regras de Negócio 🔠

Deverá ser criada uma aplicação de gerenciamento de caixa eletrônico, seguindo as regras: 

- [ ] Para fazer qualquer operação o usuário deve estar logado no banco onde possuí conta; 
- [ ] Cada login tem irá gerar um código de acesso que vale 15 minutos; 
- [ ] O usuário apenas pode fazer saques se possuir saldo em sua conta; 
- [ ] Caso não haja saldo na conta deve retornar a mensagem “SALDO INSUFICIÊNTE”; 
- [ ] O banco trabalha com cédulas de R$2,00, R$5,00, R$10,00 e R$50,00 para saques; 
- [ ] Cada caixa tem um reservatório com capacidade de 200 células para cada nota; 
- [ ] Caso não haja cédulas suficientes para atender o saque do cliente deve exibir a mensagem “VALOR INDISPONÍVEL, PROCURE OUTRO CAIXA”;
- [ ] Os dados que o cliente pode alterar da conta são telefone e nome. 

## Rotas Criadas ⚙️ 

### *POST – loginBanco*

Request (exemplo):
{
 "login": "exemplo_login",
 "senha": “S3nh@.d0-Cl13nt3”,
 "caixa": 1,
 "conta": “Conta do Cliente”
}

Response: Sucesso – 200 (exemplo):
{
 "acesso":
"0hVuNFSePgdwjRbzjsB502GHYcsEPVlZO2DXqK6RScsqXm7BngqspTN63PWrd3ei"
}

Response: Erro – 300 – conta, usuário ou senha inválidos(s):
{}

Response: Erro – 500 – Erro na aplicação:
{
 "mensagem": "Erro na aplicação"
}

### *GET – consultarSaldo*
o Request (exemplo):
{
 "acesso":
"0hVuNFSePgdwjRbzjsB502GHYcsEPVlZO2DXqK6RScsqXm7BngqspTN63PWrd3ei",
}
Response: Sucesso – 200 (exemplo):
{
 "saldo_conta": 100.0
}
o Response: Erro – 400 – código de acesso inválido:
{}
o Response: Erro – 500 – Erro na aplicação:
{
 "mensagem": "Erro na aplicação "
}

### *POST – fazerSaque*

Request (exemplo):
{
 "acesso":
"0hVuNFSePgdwjRbzjsB502GHYcsEPVlZO2DXqK6RScsqXm7BngqspTN63PWrd3ei",
 "valor": 50.0
}

Response: Sucesso – 200 (exemplo):
{
 "codigo_banco": 1,
 "conta": “conta do cliente”,
 "cedulas_2": 0,
 "cedulas_5": 0,
 "cedulas_10": 0,
 "cedulas_50": 1
}

Response: Erro – 300 – saldo insuficiente:
{
 "mensagem": "SALDO INSUFICIÊNTE"
}

Response: Erro – 350 – valor indisponível no caixa:
{
 "mensagem": " VALOR INDISPONÍVEL, PROCURE OUTRO CAIXA"
}

Response: Erro – 400 – código de acesso inválido:
{}

Response: Erro – 500 – Erro na aplicação:
{
 "mensagem": "Erro na aplicação "
}

### *PUT – alterarDadosConta*

Request (exemplo):
{
 "acesso":
"0hVuNFSePgdwjRbzjsB502GHYcsEPVlZO2DXqK6RScsqXm7BngqspTN63PWrd3ei",
 "nome_cliente": "Nome do Cliente",
 "telefone_cliente": "00 0000-0000"
}

Response: Sucesso – 200 (exemplo):
{}

Response: Erro – 400 – código de acesso inválido:
{}

Response: Erro – 500 – Erro na aplicação:
{
 "mensagem": "Erro na aplicação "
}

### *GET – consultarDadosConta*

Request (exemplo):
{
 "acesso":
"0hVuNFSePgdwjRbzjsB502GHYcsEPVlZO2DXqK6RScsqXm7BngqspTN63PWrd3ei"
}
Response: Sucesso – 200 (exemplo):
{
 "codigo_banco": 1,
 "nome_banco": “Banco do Brasil”,
 "conta": “conta do cliente”,
 "nome_cliente": “Nome do cliente”,
 "telefone_cliente": "00 0000-0000"
}

Response: Erro – 400 – código de acesso inválido:
{}

Response: Erro – 500 – Erro na aplicação:
{
 "mensagem": "Erro na aplicação "
}


## Desenvolvedoras 👑

| [<img src="https://avatars.githubusercontent.com/u/79282971?v=4" width=115><br><sub>Olga Mahin 👩🏽‍💻🚀</sub>](https://github.com/omahin) |  [<img src="https://avatars.githubusercontent.com/u/83045525?v=4" width=115><br><sub>Jéssica Marques 👩🏽‍💻🚀</sub>](https://github.com/jessica-mss) |  [<img src="https://avatars.githubusercontent.com/u/82973465?v=4" width=115><br><sub>Lílian Guedes 👩‍💻🚀</sub>](https://github.com/Lilian411) | [<img src="https://avatars.githubusercontent.com/u/79282971?v=4" width=115><br><sub>Deisi 👩‍💻🚀</sub>](https://github.com/omahin) | [<img src="https://avatars.githubusercontent.com/u/62125601?v=4" width=115><br><sub>Nath 👩‍💻🚀</sub>](https://github.com/NathiMick) |
| :---: | :---: | :---: | :---: | :---:
