# WorstMovie_GoldenRaspberryAwards
## Pré-requisito

Back-end: Java EE 8(JAX-RS) 

Antes de rodar a aplicação é preciso garantir que as seguintes dependências estejam corretamente instaladas:
```
Java 8
Spring boot 2.5.6
Maven 3.8.6 ou superior
H2 Database
```

# Setup
Primeiramente, faça o clone do repositório:

https://github.com/joaomasters/WorstMovie_GoldenRaspberryAwards.git
Na sequência execute o clean install para baixar as dependências
```
mvn clean install
Obs: Está configurado para o install do maven tambm executar o bower install e baixar as dependências web.
```
Após baixado as dependências, é preciso criar a base dados no H2:

Por padrão, o Spring Boot configura o aplicativo para se conectar a um armazenamento na memória com o nome de usuário sa e uma senha vazia .

No entanto, podemos alterar esses parâmetros adicionando as seguintes propriedades ao arquivo application.properties :

spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect

# Inicialização
Como alternativa, também podemos usar YAML para a configuração do banco de dados do aplicativo, adicionando as propriedades correspondentes ao arquivo application.yaml :
Acessando o Console H2
O banco de dados H2 possui um console GUI embutido para navegar pelo conteúdo de um banco de dados e executar consultas SQL. Por padrão, o console H2 não está habilitado no Spring.

Para habilitá-lo, precisamos adicionar a seguinte propriedade a application.properties :
```
spring.h2.console.enabled=true
Se estivermos usando a configuração YAML, precisamos adicionar a propriedade a application.yaml :

spring:
  h2:
    console.enabled: true
    ```
Então, depois de iniciar o aplicativo, podemos navegar para http://localhost:8080/h2-console , que nos apresentará uma página de login.

Na página de login, forneceremos as mesmas credenciais que usamos no application.properties :
Assim que nos conectarmos, veremos uma página da Web abrangente que lista todas as tabelas no lado esquerdo da página e uma caixa de texto para executar consultas SQL:

O console da web possui um recurso de preenchimento automático que sugere palavras-chave SQL. O fato de o console ser leve o torna útil para inspecionar visualmente o banco de dados ou executar SQL bruto diretamente.

Além disso, podemos configurar ainda mais o console especificando as seguintes propriedades no application.properties do projeto com nossos valores desejados:
```
spring.h2.console.path=/h2-console
spring.h2.console.settings.trace=false
spring.h2.console.settings.web-allow-others=false
Da mesma forma, ao usar a configuração YAML, podemos adicionar as propriedades acima como:
```
```
spring:
  h2:
    console.path: /h2-console
    console.settings.trace: false 
    spring.h2.console.settings.web-allow-others: false
    ```
Nos trechos acima, definimos o caminho do console como /h2-console , que é relativo ao endereço e porta do nosso aplicativo em execução. Portanto, se nosso aplicativo estiver sendo executado em http://localhost:8081 , o console estará disponível em http://localhost:8081/h2-console.

Além disso, definimos spring.h2.console.settings.trace como false para evitar a saída de rastreamento e também podemos desabilitar o acesso remoto definindo spring .
```
h2.console.settings.web-allow-others para false .
```
## Outros
Serviços disponíveis no back-end:

- GET: http://localhost:8080/ws/pessoa/listar
- GET: http://localhost:8080/ws/pessoa/buscar/1
- POST: http://localhost:8080/ws/pessoa/cadastrar
 
