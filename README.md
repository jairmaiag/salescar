# SalesCar

Projeto para cadastro de veículos para venda (backend).

## Índice

- [Iniciando](#iniciando)
  - [Requisitos](#requisitos)
  - [Executando](#executando)
  - [Recursos](#recursos)
- [Dúvidas](#duvidas)

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
 	 	

Cadastro de Modelo

Cadastro de Opcionais

Cadastro de Carros

[Voltar ao Índice](#salescar)

### Duvidas

Em caso de dúvidas entre em contato com [jairmaiag@gmail.com](jairmaiag@gmail.com)

[Voltar ao Índice](#salescar)