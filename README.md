## SEI - Sistema de Estudos Integrado

## Introdução
Bem-vindo à documentação da **SEI API**, uma aplicação desenvolvida em Java utilizando o framework Spring Boot. Esta API foi projetada para atender ao **Sistema de Ensino Integrado (SEI)**, uma plataforma de estudos integrada voltada para alunos de engenharia de universidades. O objetivo principal da API é fornecer uma solução robusta e escalável para gerenciar e integrar dados acadêmicos, facilitando o acesso a informações relevantes e melhorando a experiência dos estudantes.

A API segue os princípios RESTful, garantindo uma arquitetura em camadas, de fácil manutenção e altamente escalável. Com endpoints bem definidos, ela permite operações como  por exemplo: autenticação de usuários, gestão de disciplinas, acesso a materiais de estudo, registro de notas e desempenho acadêmico, integração com sistemas universitários existentes etc.

Este projeto foi desenvolvido com o intuito de simplificar o acesso dos alunos de engenharia aos recursos acadêmicos, centralizar informações importantes em uma única plataforma, facilitar a comunicação entre alunos, professores e administradores, etc. Ele é especialmente útil para alunos de engenharia que buscam uma plataforma integrada para estudos, professores que desejam gerenciar conteúdos e avaliações, "administradores universitários que precisam de uma solução centralizada para dados acadêmicos,mas futuramente, nossa ferramente irá abordar aspectos além dos cursos de engenharia para ser mais abrangente à toda universidade etc.].

## Tecnologias Utilizadas

- **Java**: Linguagem de programação principal.
- **Spring Boot**: Framework para desenvolvimento de aplicações Java.
- **Spring Security**: Para autenticação e autorização de usuários.
- **JWT (JSON Web Tokens)**: Para autenticação segura e stateless.
- **Spring Data JPA**: Para persistência de dados e integração com bancos de dados.
- **Hibernate**: Como ORM (Object-Relational Mapping) para mapeamento de entidades.
- **MySQL**: Banco de dados relacional para ambiente de produção.
- **H2 Database**: Banco de dados em memória para testes e desenvolvimento.
- **Docker**: Para conteinerização e facilidade de deploy em diferentes ambientes.
- **Swagger**: Para documentação interativa da API.
-  **MailSender**: Para gerenciamento de envio de emails transacionais.
- **Postman**: Para testes de endpoints e coleções de requisições.
- **Ambientes de Testes**: Configuração de ambientes de desenvolvimento, teste e produção.
- **JaCoCo**: Para cobertura de testes e análise de código.
- **Maven/Gradle**: Para gerenciamento de dependências e build do projeto.


## Funcionalidades Principais

- **Autenticação e Autorização**: Autenticação de usuários (alunose administradores) via JWT.
- **Gestão de Disciplinas e Turmas**: CRUD de disciplinas, turmas e associações entre alunos e disciplinas.
- **Materiais de Estudo**: Upload e download de materiais de estudo (PDFs, vídeos, etc.).
- **Registro de Notas e Desempenho**: Registro e consulta de notas e desempenho acadêmico.
- **Integração com Sistemas Universitários**: Integração com sistemas existentes para sincronização de dados.
- **Documentação Interativa**: Documentação da API via Swagger para facilitar o uso por desenvolvedores.

- ## Estrutura do Projeto

A API foi desenvolvida utilizando uma **arquitetura em camadas**, seguindo boas práticas de desenvolvimento e organização de código. Os pacotes principais da aplicação são:

### Pacotes Principais

1. **Repository**:
   - Contém as interfaces que estendem `JpaRepository` para acesso e manipulação de dados no banco de dados.
   - Responsável pela camada de persistência.

2. **Service**:
   - Contém a lógica de negócio da aplicação.
   - Implementa as regras de negócio e faz a mediação entre a camada de controle (Controller) e a camada de persistência (Repository).

3. **Controller**:
   - Expõe os endpoints da API, recebendo requisições HTTP e retornando respostas adequadas.
   - Responsável pela camada de apresentação.

### Pacotes Modulares

Além dos pacotes principais, a aplicação foi organizada em módulos para melhorar a modularidade e a manutenção do código:

1. **Components**:
   - Contém componentes personalizados e reutilizáveis, como filtros, listeners ou serviços específicos.

2. **Config**:
   - Responsável por centralizar as configurações da aplicação.
   - Inclui configurações do **Swagger** para documentação da API, configurações do **Spring Security** para autenticação e autorização, e configurações web.

3. **Entities**:
   - Contém as entidades da aplicação, que representam as tabelas do banco de dados.
   - Dentro deste pacote, há um subpacote **enum**, que armazena os enums utilizados para mapear valores específicos das entidades (por exemplo, roles de usuários, status de disciplinas, etc.).

4. **JWT**:
   - Pacote dedicado às funcionalidades relacionadas ao **JSON Web Tokens (JWT)**.
   - Inclui classes para geração, validação e manipulação de tokens JWT.

5. **Utils**:
   - Contém métodos e classes utilitárias estáticas, como validadores, formatações e auxiliares para operações comuns.

6. **Web**:
   - Pacote responsável por gerenciar a camada web da aplicação. Ele é dividido em três subpacotes:
     - **Controllers**: Contém os controladores que expõem os endpoints da API.
     - **DTOs (Data Transfer Objects)**: Contém objetos utilizados para transferência de dados entre as camadas da aplicação, garantindo que apenas as informações necessárias sejam expostas.
     - **Exception**: Contém as classes de exceção personalizadas e handlers para tratamento global de erros.

  # Pacote `resources`

O pacote `resources` contém os arquivos de configuração da aplicação, que são essenciais para definir comportamentos específicos em diferentes ambientes. Esses arquivos permitem que a aplicação seja configurada de maneira dinâmica, dependendo do ambiente em que está sendo executada (desenvolvimento, teste ou produção).

---

## Arquivos de Configuração

### 1. **application.properties**
- **Descrição**: Arquivo principal de configuração da aplicação.
- **Funções**:
  - Define configurações globais, como a porta do servidor, configurações básicas do Spring Boot e propriedades comuns a todos os ambientes.
  - Permite definir o perfil ativo (`spring.profiles.active`), que determina qual arquivo de configuração específico do ambiente será carregado (por exemplo, `dev` ou `prod`).

---

### 2. **application-dev.properties**
- **Descrição**: Arquivo de configuração específico para o ambiente de **desenvolvimento**.
- **Configurações comuns**:
  - Conexão com o banco de dados H2 (banco em memória), ideal para testes rápidos e desenvolvimento local.
  - Ativação de logs detalhados para facilitar a depuração.
  - Configurações de segurança relaxadas para facilitar o desenvolvimento.
- **Exemplo de uso**:
  ```properties
  spring.profiles.active=dev

### 3. **application-prod.properties**
- **Descrição**: Arquivo de configuração específico para o ambiente de **produção**.
- **Configurações comuns**:
  - Conexão com o banco de dados principal e configuração de serviços de produção.
  - Ativação de logs detalhados para facilitar a depuração.
  - Configurações de segurança o desenvolvimento.
- **Exemplo de uso**:
  ```properties
  spring.profiles.active=prod


## O que é o arquivo `pom.xml`?

O `pom.xml` (Project Object Model) é o arquivo central de configuração do Maven. Ele contém informações sobre o projeto, suas dependências, plugins e outras configurações necessárias para compilar, testar e empacotar a aplicação.

---

## Estrutura do `pom.xml`

### 1. **Informações Básicas do Projeto**
- **groupId**: `com.marcelo721` - Identifica o grupo ou organização do projeto.
- **artifactId**: `SEI` - Nome do projeto.
- **version**: `0.0.1-SNAPSHOT` - Versão atual do projeto (em desenvolvimento).
- **name**: `SEI` - Nome do projeto.
- **description**: `SEI is an academic project to help students in computer engineering and electrical engineering.` - Descrição do projeto.

### 2. **Configurações do Projeto**
- **Java Version**: `17` - Versão do Java utilizada no projeto.
- **Maven Compiler**: Configurado para usar a versão 21 do Java para compilação.

### 3. **Dependências**
As dependências são bibliotecas externas que o projeto utiliza para funcionar. Abaixo estão as principais dependências e suas funções:

#### Dependências Principais
- **Spring Boot Starter Data JPA** (`spring-boot-starter-data-jpa`):
  - Fornece suporte para acesso a banco de dados usando JPA (Java Persistence API).
  - Facilita a integração com bancos de dados relacionais.

- **Spring Boot Starter Web** (`spring-boot-starter-web`):
  - Fornece suporte para desenvolvimento de aplicações web com Spring MVC.
  - Inclui dependências como Tomcat (servidor embutido) e Jackson (para manipulação de JSON).

- **H2 Database** (`h2`):
  - Banco de dados em memória, ideal para desenvolvimento e testes.
  - Escopo `runtime`: Disponível apenas durante a execução do projeto.

- **MySQL Connector Java** (`mysql-connector-java`):
  - Driver JDBC para conexão com bancos de dados MySQL.
  - Utilizado em ambientes de produção.

- **Spring Boot Starter Mail** (`spring-boot-starter-mail`):
  - Fornece suporte para envio de e-mails.

- **Spring Boot Starter Test** (`spring-boot-starter-test`):
  - Fornece ferramentas para testes unitários e de integração.
  - Escopo `test`: Disponível apenas durante os testes.

- **Lombok** (`lombok`):
  - Biblioteca que simplifica a escrita de código Java, gerando automaticamente métodos como getters, setters, construtores, etc.
  - Escopo `annotationProcessor`: Processa anotações durante a compilação.

- **Java JWT** (`java-jwt`):
  - Biblioteca para criação e validação de tokens JWT (JSON Web Tokens).
  - Utilizada para autenticação e autorização.

- **Spring Boot Starter Security** (`spring-boot-starter-security`):
  - Fornece suporte para segurança em aplicações Spring Boot.
  - Inclui autenticação, autorização e proteção contra ataques comuns.

- **Spring Boot Starter Webflux** (`spring-boot-starter-webflux`):
  - Fornece suporte para programação reativa com Spring WebFlux.
  - Ideal para aplicações que exigem alta escalabilidade.

- **Springdoc OpenAPI Starter WebMVC UI** (`springdoc-openapi-starter-webmvc-ui`):
  - Gera documentação automática da API usando o padrão OpenAPI (Swagger).
  - Facilita a visualização e teste dos endpoints da API.

- **PostgreSQL** (`postgresql`):
  - Driver JDBC para conexão com bancos de dados PostgreSQL.

- **Spring Boot Starter Validation** (`spring-boot-starter-validation`):
  - Fornece suporte para validação de dados em entidades e objetos.

### 4. **Plugins**
- **Maven Compiler Plugin**:
  - Configura o compilador do Maven para usar a versão especificada do Java.

- **Spring Boot Maven Plugin**:
  - Facilita a construção e execução de aplicações Spring Boot.
  - Permite empacotar a aplicação como um arquivo JAR executável.

---

# Configuração do Swagger (SpringDoc OpenAPI)

Este tópico descreve a configuração e utilização do Swagger (SpringDoc OpenAPI) no projeto SEI. O Swagger é uma ferramenta que facilita a documentação e teste de APIs RESTful, gerando automaticamente uma interface interativa para explorar os endpoints da API.

---

---

## Configuração do Swagger no Projeto

A configuração do Swagger foi feita na classe `SpringDocOpenApi`, localizada no pacote `com.marcelo721.SEI.Config`. Abaixo estão os detalhes dessa configuração:

### 1. **Classe `SpringDocOpenApi`**
- **Anotação `@Configuration`**:
  - Indica que a classe contém configurações do Spring.
- **Método `springShopOpenAPI()`**:
  - Define as configurações globais do Swagger, como o título, descrição e versão da API.
  - Configura o esquema de segurança para autenticação via JWT (JSON Web Token).

#### Código da Classe:
```java
@Configuration
public class SpringDocOpenApi {

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .components(new Components().addSecuritySchemes("security", securityScheme()))
                .info(new Info().title("SEI - API")
                        .description("Sei API")
                        .version("v0.0.1"));
    }

    private SecurityScheme securityScheme() {
        return new SecurityScheme()
                .description("Insert token to continue")
                .type(SecurityScheme.Type.HTTP)
                .in(SecurityScheme.In.HEADER)
                .scheme("bearer")
                .bearerFormat("JWT")
                .name("security");
    }
}
```



## exemplo de uso do swagger em um endpoint de um controller 
```java
 @Operation(
            summary = "create a new user", description = "resource to create a new user",
            responses = {
                    @ApiResponse(responseCode = "201", description = "resource created successfully",
                            content = @Content(mediaType= "application/json", schema = @Schema(implementation = UserResponseDto.class))),

                    @ApiResponse(responseCode = "409", description = "User email is already registered",
                            content = @Content(mediaType= "application/json", schema = @Schema(implementation = ErrorMessage.class))),

                    @ApiResponse(responseCode = "422", description = "Invalid Data",
                            content = @Content(mediaType= "application/json", schema = @Schema(implementation = ErrorMessage.class)))

            }
    )
    @PostMapping//tested
    public ResponseEntity<Void> createUser(@RequestBody @Valid UserCreateDto user) {
        User obj = user.toUser();
        userService.save(obj);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
```
