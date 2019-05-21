## xy-inc

Este projeto foi desenvolvido utilizando Java e Spring Boot. Foi utilizado **Docker** para escalar a aplicação e dispensar instalações de banco de dados adicionais.

# Pré-requisitos

* Java 8
* Maven
* Docker Compose

## Execução

1 - Clone o projeto utilizando o link <https://github.com/brunocrez/xy-inc.git>    

2 - Acesse o diretório clonado utilizando o **terminal** e execute os comandos:    

$ mvn clean install -DskipTests    

$ docker-compose up    

## API

1 - Cadastrar Ponto de Interesse 
   
	POST    
	
	<https://localhost:8080/poi>  
	
	**\{ "nome": "Churrascaria Tropeiro", "x": 27, y": 12 \}**   
	
2 - Listar Todos os Pontos de Interesse   
 
	GET    
	
	<https://localhost:8080/poi/getAll>  
	
3 - Listar Pontos de Interesse por Proximidade   
 
	GET    
	
	<https://localhost:8080/poi/inRange?x=20&y=10&dMax=10>   
	
	**Pode-se alterar os valores dos parâmetros x, y e dMax para obter diferentes pontos de interesse**

