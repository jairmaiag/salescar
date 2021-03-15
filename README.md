# SalesCar

Projeto para cadastro de veículos para venda (backend).

## Índice

- [Iniciando](#iniciando)
  - [Requisitos](#requisitos)
  - [Banco de dados](#banco-de-dados)
  - [Executando](#executando)
  - [Recursos](#recursos)
- [Dúvidas](#dúvidas)

## Iniciando

Segue as instruções de utilização da API.

[Voltar ao Índice](#salescar)

### Requisitos
Ter os programas abaixo já instalados e rodando:
 
1. Ter o **Apache Maven** versão **3.6.0** ou superior.
2. Ter o **SGBD (Sistema de Gestão de Banco de Dados) MySQL**.
3. Saber o usuário e senha padrão do MySQL.
4. [Insomnia](https://insomnia.rest/) versão 2021.1.1

[Voltar ao Índice](#salescar)

### Banco de dados

arquivo [scriptDDLMySQL.sql](#salescar/src/test/resources/scriptDDLMySQL.sql)
[Voltar ao Índice](#salescar)

### Executando

Primeiro acesse, via terminal de comandos, a pasta onde o projeto foi baixado.

Segundo exeute o comando maven, abaixo para baixar as dependências.

`mnv install`

Este passo pode demorar um pouco.

Terceiro execute o comando abaixo:

`mvn spring-boot:run`

Quarto, utilize o [Insomnia](https://insomnia.rest/), para acessar os recursos da API.

[Voltar ao Índice](#salescar)

### Recursos

Este sistema conta com os seguintes recursos, acessados pelo endereço base [http://localhost:8080](http://localhost:8080) e utilizando os métodos do http:

#### Cadastro de Fabricante

| Método | Enderço           | Recurso               |
|--------|-------------------|-----------------------|
| GET    | /fabricantes      | listagem              |
| GET    | /fabricantes/{id} | localizar um registro |
| POST   | /fabricantes      | inclusão              |
| PUT    | /fabricantes      | alteração             |
| DELETE | /fabricantes/{id} | exclusão              |
 	 	

#### Cadastro de Modelo

| Método | Enderço       | Recurso               |
|--------|---------------|-----------------------|
| GET    | /modelos      | listagem              |
| GET    | /modelos/{id} | localizar um registro |
| POST   | /modelos      | inclusão              |
| PUT    | /modelos      | alteração             |
| DELETE | /modelos/{id} | exclusão              |

#### Cadastro de Opcionais

| Método | Enderço         | Recurso               |
|--------|-----------------|-----------------------|
| GET    | /opcionais      | listagem              |
| GET    | /opcionais/{id} | localizar um registro |
| POST   | /opcionais      | inclusão              |
| PUT    | /opcionais      | alteração             |
| DELETE | /opcionais/{id} | exclusão              |

#### Cadastro de Carros

| Método | Enderço      | Recurso               |
|--------|--------------|-----------------------|
| GET    | /carros      | listagem              |
| GET    | /carros/{id} | localizar um registro |
| POST   | /carros      | inclusão              |
| PUT    | /carros      | alteração             |
| DELETE | /carros/{id} | exclusão              |

[Voltar ao Índice](#salescar)

### Dúvidas

Em caso de dúvidas entre em contato com [jairmaiag@gmail.com](jairmaiag@gmail.com)

[Voltar ao Índice](#salescar)