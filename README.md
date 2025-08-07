# 🍽️ Restaurante API

Uma API RESTful para simular o gerenciamento de um restaurante. Ela oferece endpoints para cadastro de usuários e pratos principais, utilizando um sistema de autenticação e autorização robusto.

## 🚀 Tecnologias Utilizadas

* **Java 21**
* **Spring Boot 3.4.4**: Framework principal da aplicação.
* **Spring Security**: Gerencia a segurança da aplicação, com autenticação via JWT.
* **JWT (JSON Web Tokens)**: Padrão para geração e validação de tokens de acesso.
* **MySQL**: Banco de dados relacional.
* **Flyway**: Responsável por versionar e migrar o banco de dados.
* **Maven**: Gerenciador de dependências.
* **Lombok**: Reduz a verbosidade do código Java.
* **ModelMapper**: Mapeia objetos DTOs para entidades de forma automática.
* **Swagger/Springdoc**: Cria a documentação interativa da API.

---

## 🛠️ Como Executar o Projeto

### Pré-requisitos

Certifique-se de que você tem os seguintes itens instalados em sua máquina:

* **JDK 21** ou superior
* **Maven**
* **MySQL**

### Configuração do Banco de Dados

1.  Crie um banco de dados MySQL com o nome `restaurantespringboot`.
2.  Verifique se o arquivo `src/main/resources/application.yml` está configurado com as credenciais corretas do seu banco de dados, como no exemplo abaixo:

```yaml
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/restaurantespringboot?createDatabaseIfNotExist=true
    username: root
    password: Pedro12272
```
**Observação:** O Flyway criará as tabelas `usuarios` e `pratos_principais` automaticamente na primeira execução.

### Executando a aplicação
Navegue até a pasta raiz do projeto e execute o seguinte comando no terminal:
```bash
mvn spring-boot:run
```
#### A API será iniciada na porta 8080 por padrão.
---

## 🔑 Autenticação e Endpoints

### 1. Cadastro de Usuário

Antes de fazer login, você precisa criar um usuário.

* **Endpoint**: `POST /usuarios`
* **Corpo da requisição (JSON)**:
    ```json
    {
      "login": "seu_login",
      "password": "sua_senha"
    }
    ```
* **Retorno**: O usuário cadastrado com seu ID.

### 2. Login e Geração do Token

Após cadastrar um usuário, use suas credenciais para fazer login e obter um token JWT.

* **Endpoint**: `POST /login`
* **Corpo da requisição (JSON)**:
    ```json
    {
      "login": "seu_login",
      "password": "sua_senha"
    }
    ```
* **Retorno**: Um token JWT para autenticação.

### 3. Acessando Endpoints Protegidos

Para acessar qualquer endpoint que exige autenticação, inclua o token obtido no cabeçalho `Authorization` da requisição. O formato deve ser `Bearer <seu_token>`.

#### Exemplos de Endpoints Protegidos:
#### Pratos Principais

Estes são os endpoints para gerenciar os pratos:

* `POST /pratos`: Cadastrar um novo prato principal.
* `GET /pratos`: Buscar todos os pratos principais.
* `GET /pratos/{id}`: Buscar um prato específico por ID.
* `PUT /pratos/{id}`: Atualizar um prato principal existente.
* `DELETE /pratos/{id}`: Deletar um prato principal.

---

---

## 📖 Documentação da API (Swagger)

A documentação interativa da API está disponível no seu navegador assim que a aplicação for iniciada.

* **URL**: `http://localhost:8080/swagger-ui.html`

Use o Swagger para explorar os endpoints, entender os modelos de dados e testar as requisições diretamente pela interface.

---

## 🤝 Contribuição

Sinta-se à vontade para contribuir com o projeto! Você pode abrir issues para relatar bugs ou sugerir melhorias, ou enviar pull requests com novas funcionalidades.
