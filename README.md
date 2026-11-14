# Sistema de Controle de Veículos

Sistema de gerenciamento de estoque de veículos desenvolvido em Java com Spring Boot e MySQL.

## Objetivo

O projeto tem como objetivo realizar o gerenciamento de veículos de uma loja, permitindo cadastrar, consultar, atualizar, excluir e filtrar registros.

## Tecnologias utilizadas

- Java 21
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Git e GitHub
- Postman

## Funcionalidades

- Cadastro de veículos.
- Consulta de veículos cadastrados.
- Consulta por ID.
- Atualização de informações.
- Exclusão de veículos.
- Cadastro e relacionamento de marcas e modelos.
- Filtros por marca, modelo, ano, faixa de preço e status.
- Gerenciamento de status dos veículos.

## Estrutura do projeto

```text
src/
 └── main/
     ├── java/br/com/sistemaveiculos/
     │   ├── controller/
     │   ├── model/
     │   ├── repository/
     │   └── service/
     └── resources/
         └── application.properties
```

## Como executar

1. Instale o Java 21.
2. Instale o MySQL Server.
3. Crie o banco de dados `sistema_veiculos`.
4. Configure as credenciais do MySQL no arquivo `application.properties`.
5. Execute o projeto pelo terminal:

```bash
mvnw.cmd spring-boot:run
```

A aplicação será iniciada na porta 8080.

## Endpoints principais

| Método | Endpoint | Função |
|---|---|---|
| POST | `/api/veiculos` | Cadastrar veículo |
| GET | `/api/veiculos` | Listar e filtrar veículos |
| GET | `/api/veiculos/{id}` | Consultar por ID |
| PUT | `/api/veiculos/{id}` | Atualizar veículo |
| DELETE | `/api/veiculos/{id}` | Excluir veículo |

## Autor

Projeto acadêmico desenvolvido como atividade prática de desenvolvimento de sistemas.