# microsservicos-acessos

## Introdução
  Uma empresa de co-working conhecida está sofrendo problemas de instabilidade no sistema, o responsável pela infraestrutura analisou a situação, e disse que o que causa a instabilidade é a quantidade de requisições no acesso as portas.

  Sabendo da situação, o responsável pelo departamento de tesouraria disse que não poderia aumentar o orçamento da infraestrutura porque já estava gastando mais de 10mil reais por mês.

  O CTO da empresa recebeu seu contato, como uma recomendação de um excelente profissional para reduzir custos de um sistema monolito. Tendo uma recomendação tão boa, ele não pode exitar em te chamar para refazer o sistema de controle de portas em microsserviços, afinal, você prometeu a ele que vai reduzir o custo em 50% mudando para microsserviços.

 ## Regras de negócio:
  - Um acesso só pode ser criado se o usuário for válido.
  - Um acesso só pode ser criado se a porta for válida.

___
 ## Requisições de Porta:

 ### POST /porta/v1/porta
Cria uma porta no sistema.

**Request Body**
```json
{
    "andar": "11",
    "sala": "11B35" 
}
```

**Response 201**
```json
{
    "id": 1,
    "andar": "11",
    "sala": "11B35" 
}
```

 ### GET /porta/v1/porta/{id}
Exibe uma porta do sistema

**Response 200**
```json
{
    "id": 1,
    "andar": "11",
    "sala": "11B35" 
}
```

 ## Requisições de cliente:

 ### POST /cliente/v1/cliente
Cria um cliente no sistema.

**Request Body**
```json
{
    "nome": "Nicollas Gabriel"
}
```

**Response 201**
```json
{
    "id": 1,
    "nome": "Nicollas Gabriel",
}
```
 ### GET /cliente/v1/cliente/{id}
Exibe um cliente do sistema.

**Response 200**
```json
{
    "id": 1,
    "nome": "Nicollas Gabriel",
}
```
 ## Requisições de acesso:

 ### POST /acesso/v1/acesso
Cria um acesso no sistema.

**Request Body**
```json
{
    "portaId": 1,
    "clienteId": 1
}
```

**Response 201**
```json
{
    "portaId": 1,
    "clienteId": 1
}
```

### DELETE /acesso/v1/acesso/{idCliente}/{idPorta}
Apaga um acesso no sistema.

**Response 204**
```json
```

### GET /acesso/v1/acesso/{idCliente}/{idPorta}
Consulta um acesso no sistema.

**Response 200**
```json
{
    "portaId": 1,
    "clienteId": 1
}
```

