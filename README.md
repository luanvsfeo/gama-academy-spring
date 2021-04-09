                 ## Dev's
- Luan Veiga Sampaio Féo
- Amne Fredo
- Gabriel Oliveira Ferreira


# Documentação Desafio Final Gama Academy

##Categorias

- GET `/categoria`
````text
    Retorna todas as categorias!
````
####*Status Code*: 200

- POST `/categoria`
####Exemplo de body:
````json
{
  "nome": "eletrodomésticos"
}
````
####Resposta:

````json
{
  "id": 1,
  "nome": "eletrodomésticos"
}
````
####*Status Code*: 201

##Compra

- GET `/compra`
````text
    Retorna todas as compras!
````
####*Status Code*: 200

- POST `/categoria`
####Exemplo de body:
````json
{
  "produtos": [
    {
      "produto": {
        "categoria": {
          "nome": "string"
        },
        "codigoBarra": "string",
        "marca": {
          "nome": "string"
        },
        "nome": "string"
      }
    }
  ]
}
````
####Resposta:

````json
{
  "dataCompra": "2021-04-09T13:39:46.792Z",
  "id": 0,
  "produtos": [
    {
      "id": 0,
      "produto": {
        "categoria": {
          "id": 0,
          "nome": "string"
        },
        "codigoBarra": "string",
        "id": 0,
        "marca": {
          "id": 0,
          "nome": "string"
        },
        "nome": "string",
        "quantidadeDisponivel": 0,
        "unidadeMedida": "string",
        "valorUnitario": 0
      },
      "quantidade": 0,
      "valorTotal": 0,
      "valorUnitario": 0
    }
  ],
  "valorTotal": 0
}
````
####*Status Code*: 201

##Marca

- GET `/marca`
````text
    Retorna todas as marcas!
````
####*Status Code*: 200

- POST `/marca`
####Exemplo de body:
````json
{
  "nome": "Consul"
}
````
####Resposta:

````json
{
  "id": 1,
  "nome": "Consul"
}
````
####*Status Code*: 201

##Produtos

- GET `/produto`
````text
    Params:
        - Categoria = eletrodomestico
        - Marca = consul
        - valorUnitario = 12,99
````
####Resposta:
````json
[
  {
    "categoria": {
      "id": 0,
      "nome": "string"
    },
    "codigoBarra": "string",
    "id": 0,
    "marca": {
      "id": 0,
      "nome": "string"
    },
    "nome": "string",
    "quantidadeDisponivel": 0,
    "unidadeMedida": "string",
    "valorUnitario": 0
  }
]
````
####*Status Code*: 200

- POST `/produto`
####Exemplo de body:
````json
{
  "categoria": {
    "nome": "string"
  },
  "codigoBarra": "string",
  "marca": {
    "nome": "string"
  },
  "nome": "string",
  "quantidadeDisponivel": 0,
  "unidadeMedida": "string",
  "valorUnitario": 0
}
````
####Resposta:

````json
{
  "id": 1,
  "produto": {
    "categoria": {
      "id": 0,
      "nome": "string"
    },
    "codigoBarra": "string",
    "id": 0,
    "marca": {
      "id": 0,
      "nome": "string"
    },
    "nome": "string",
    "quantidadeDisponivel": 0,
    "unidadeMedida": "string",
    "valorUnitario": 0
  }
}
````
####*Status Code*: 201

- PUT `/produto/:id`

####Exemplo de body:

````json
{
  "categoria": {
    "nome": "string"
  },
  "codigoBarra": "string",
  "marca": {
    "nome": "string"
  },
  "nome": "string",
  "quantidadeDisponivel": 0,
  "unidadeMedida": "string",
  "valorUnitario": 0
}
````

####Resposta:

````json
{
  "id": 1,
  "produto": {
    "categoria": {
      "id": 0,
      "nome": "string"
    },
    "codigoBarra": "string",
    "id": 0,
    "marca": {
      "id": 0,
      "nome": "string"
    },
    "nome": "string",
    "quantidadeDisponivel": 0,
    "unidadeMedida": "string",
    "valorUnitario": 0
  }
}
````

####*Status Code*: 200

- GET `/produto/:id`

####Resposta:

````json
{
  "id": 1,
  "produto": {
    "categoria": {
      "id": 0,
      "nome": "string"
    },
    "codigoBarra": "string",
    "id": 0,
    "marca": {
      "id": 0,
      "nome": "string"
    },
    "nome": "string",
    "quantidadeDisponivel": 0,
    "unidadeMedida": "string",
    "valorUnitario": 0
  }
}
````

####*Status Code*: 200

- DELETE `/produto/:id`

####Resposta:

````json
{}
````

####*Status Code*: 204

##Usuario

- POST `/usuario`

####Exemplo de Body:

````json
{
  "cpf": "string",
  "dataNascimento": "2021-04-09",
  "email": "string",
  "cep": "string",
  "login": "string",
  "nome": "string",
  "senha": "string"
}
````

####Resposta:

````json
{
  "cpf": "string",
  "dataNascimento": "2021-04-09T14:59:56.251Z",
  "email": "string",
  "endereco": {
    "bairro": "string",
    "cep": "string",
    "complemento": "string",
    "id": 1,
    "localidade": "string",
    "logradouro": "string",
    "numero": 0,
    "uf": "string"
  },
  "id": 1,
  "login": "string",
  "nome": "string",
  "senha": "string"
}
````

####*Status Code*: 201

- GET `/usuario/:id`

####Resposta:
````json
{
  "cpf": "string",
  "dataNascimento": "2021-04-09",
  "email": "string",
  "endereco": {
    "bairro": "string",
    "cep": "string",
    "complemento": "string",
    "id": 1,
    "localidade": "string",
    "logradouro": "string",
    "numero": 0,
    "uf": "string"
  },
  "id": 1,
  "login": "string",
  "nome": "string",
  "senha": "string"
}
````

####*Status Code*: 200

- GET `/usuario/:id`

####Exemplo de Body:

````json
{
  "cpf": "string",
  "dataNascimento": "2021-04-09",
  "email": "string",
  "cep": "string",
  "login": "string",
  "nome": "string",
  "senha": "string"
}
````

####Resposta:
````json
{
  "cpf": "string",
  "dataNascimento": "2021-04-09T15:14:45.113Z",
  "email": "string",
  "endereco": {
    "bairro": "string",
    "cep": "string",
    "complemento": "string",
    "id": 0,
    "localidade": "string",
    "logradouro": "string",
    "numero": 0,
    "uf": "string"
  },
  "id": 0,
  "login": "string",
  "nome": "string",
  "senha": "string"
}
````

####*Status Code*: 200

- DELETE `/usuario/:id`

####Resposta:
````json
{}
````

####*Status Code*: 204

- GET `/venda`

````text
    Params:
        - dataVenda = "08/04/2021"
        - usuarioId = 1
````

####Resposta:
````json
[
  {
    "dataVenda": "2021-04-08",
    "id": 1,
    "produtos": [
      {
        "id": 1,
        "produto": {
          "categoria": {
            "id": 1,
            "nome": "string"
          },
          "codigoBarra": "string",
          "id": 1,
          "marca": {
            "id": 1,
            "nome": "string"
          },
          "nome": "string",
          "quantidadeDisponivel": 0,
          "unidadeMedida": "string",
          "valorUnitario": 0
        },
        "quantidade": 0,
        "valorTotal": 0,
        "valorUnitario": 0
      }
    ],
    "usuario": {
      "cpf": "string",
      "dataNascimento": "2021-04-08",
      "email": "string",
      "endereco": {
        "bairro": "string",
        "cep": "string",
        "complemento": "string",
        "id": 1,
        "localidade": "string",
        "logradouro": "string",
        "numero": 0,
        "uf": "string"
      },
      "id": 1,
      "login": "string",
      "nome": "string",
      "senha": "string"
    },
    "valorTotal": 0
  }
]
````

####*Status Code*: 204

- POST `/venda`

####Exemplo de Body:
````json
{
  "produtos": [
    {
      "produto": {
        "categoria": {
          "nome": "string"
        },
        "codigoBarra": "string",
        "marca": {
          "nome": "string"
        },
        "nome": "string",
        "quantidadeDisponivel": 0,
        "unidadeMedida": "string",
        "valorUnitario": 0
      },
      "quantidade": 0,
      "valorTotal": 0,
      "valorUnitario": 0
    }
  ],
  "usuario": {
    "login": "string",
    "senha": "string"
  },
  "valorTotal": 0
}
````

####Resposta:
````json
{
  "dataVenda": "2021-04-09T15:23:50.801Z",
  "id": 1,
  "produtos": [
    {
      "id": 1,
      "produto": {
        "categoria": {
          "id": 1,
          "nome": "string"
        },
        "codigoBarra": "string",
        "id": 1,
        "marca": {
          "id": 1,
          "nome": "string"
        },
        "nome": "string",
        "quantidadeDisponivel": 0,
        "unidadeMedida": "string",
        "valorUnitario": 0
      },
      "quantidade": 0,
      "valorTotal": 0,
      "valorUnitario": 0
    }
  ],
  "usuario": {
    "cpf": "string",
    "dataNascimento": "2021-04-09T15:23:50.802Z",
    "email": "string",
    "endereco": {
      "bairro": "string",
      "cep": "string",
      "complemento": "string",
      "id": 1,
      "localidade": "string",
      "logradouro": "string",
      "numero": 0,
      "uf": "string"
    },
    "id": 1,
    "login": "string",
    "nome": "string",
    "senha": "string"
  },
  "valorTotal": 0
}
````

####*Status Code*: 201