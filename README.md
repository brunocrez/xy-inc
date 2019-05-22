# XY-inc

Este projeto foi desenvolvido utilizando Java e Spring Boot. Foi utilizado **Docker** para escalar a aplicação e a imagem do banco de dados PostgreSQL.

## Pré-requisitos

* Java 8
* Maven
* Docker Compose

## Execução

1 - Clone o projeto 

2 - Acesse o diretório clonado utilizando o **terminal** e execute os comandos: 

	$ mvn clean install
	$ docker-compose build 
	$ docker-compose up

## API

- 1 - Cadastrar Ponto de Interesse 

  **POST**

  http://localhost:8080/poi

		{ "nome": "Churrascaria Tropeiro", "x": 27, "y": 12 }

- 2 - Listar Todos os Pontos de Interesse

  **GET**

  http://localhost:8080/poi/getAll

- 3 - Listar Pontos de Interesse por Proximidade

  **GET**

  http://localhost:8080/poi/inRange?x=20&y=10&dMax=10

	Pode-se alterar os valores dos parâmetros x, y e dMax para obter diferentes pontos de interesse

## Teste de Aplicação

Para executar os testes separadamente, execute o seguinte comando:

	$ mvn test
