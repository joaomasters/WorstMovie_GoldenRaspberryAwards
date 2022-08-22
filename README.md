# WorstMovie_GoldenRaspberryAwards
Pré-requisito
Antes de rodar a aplicação é preciso garantir que as seguintes dependências estejam corretamente instaladas:

Java 8
Wildflyw 8.2.0.Final
PostgreSQL 9.3.10 ou superior
maven 3.8.6 ou superior
bower 1.8.0 ou superior
Setup
Primeiramente, faça o clone do repositório:

https://github.com/joaomasters/WorstMovie_GoldenRaspberryAwards.git
Na sequência execute o clean install para baixar as dependências

mvn clean install
Obs: Está configurado para o install do maven tambm executar o bower install e baixar as dependências web.

Após baixado as dependências, é preciso criar a base dados no Postgres:

Por padrão, o Spring Boot configura o aplicativo para se conectar a um armazenamento na memória com o nome de usuário sa e uma senha vazia .

No entanto, podemos alterar esses parâmetros adicionando as seguintes propriedades ao arquivo application.properties :

spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
Inicialização
Como alternativa, também podemos usar YAML para a configuração do banco de dados do aplicativo, adicionando as propriedades correspondentes ao arquivo application.yaml :
Acessando o Console H2
O banco de dados H2 possui um console GUI embutido para navegar pelo conteúdo de um banco de dados e executar consultas SQL. Por padrão, o console H2 não está habilitado no Spring.

Para habilitá-lo, precisamos adicionar a seguinte propriedade a application.properties :

spring.h2.console.enabled=true
Se estivermos usando a configuração YAML, precisamos adicionar a propriedade a application.yaml :

spring:
  h2:
    console.enabled: true
Então, depois de iniciar o aplicativo, podemos navegar para http://localhost:8080/h2-console , que nos apresentará uma página de login.

Na página de login, forneceremos as mesmas credenciais que usamos no application.properties :
Assim que nos conectarmos, veremos uma página da Web abrangente que lista todas as tabelas no lado esquerdo da página e uma caixa de texto para executar consultas SQL:

Outros
Serviços disponíveis no back-end:

GET: http://localhost:8080/ws/pessoa/listar
GET: http://localhost:8080/ws/pessoa/buscar/1
POST: http://localhost:8080/ws/pessoa/cadastrar
 
