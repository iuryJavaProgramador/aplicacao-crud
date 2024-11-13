Requisitos
==========
Para esse projeto é necessário instalar o java jdk-17, eclipse, postgreSQL 15 (pgAdmin 4) e postman.
Utilizei o Spring Boot - https://start.spring.io/

Projeto - Maven
Linguagem - Java 17
Spring Boot - 3.3.3
Packaging - Jar
Dependências - Spring Web, Thymeleaf, Postgresql, Spring Security, Validation, Spring data jpa , Lombok.


Para executar
=============
Clique com botão direito no CrudApplication, run as, por último java application.

Para fazer rodar, digite no navegador
`http://localhost:8080/tarefa`


Decisões tomadas
================

- Caso apareça uma mensagem de erro ao tentar rodar a aplicação.   
***************************
APPLICATION FAILED TO START
***************************
Description:
Web server failed to start. Port 8088 was already in use.

Sugestão:
Abra o cmd e execute como administrador.
Para listar o TCP (todas as portas que estao em uso)Windows. 
digite no cmd: netstat -ao |find /i "listening"
Irá aparecer uma lista com o TCP exemplo: 127.0.0.5:45679    LISTENING 15007
ou TCP [::] 8080    LISTENING 1992
para finalizar e liberar a porta, digite:  Taskkill /F /IM 1992         
e o PID será finalizado. Pronto. Agora, a porta 8080 está ivre para usar.
Vá até o arquivo application.properties, dentro do corpo do projeto e digite server.port=8080
