# 🎬 CineCloud

CineCloud é uma aplicação web desenvolvida em Java com Spring Boot, que permite o cadastro, gerenciamento e consulta de filmes, plataformas de streaming e categorias.  
O projeto conta com autenticação via JWT e persistência de dados com PostgreSQL.

---

## 🚀 Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Security com JWT
- PostgreSQL
- JPA / Hibernate

---

## 📚 Funcionalidades

- ✅ Cadastro, listagem, atualização e remoção de **filmes (Movies)**
- ✅ CRUD completo para **plataformas de streaming (Streaming)**
- ✅ CRUD completo para **categorias (Categorie)**
- 🔒 Autenticação e autorização com **JWT (JSON Web Token)**
- 👤 Sistema de **login e cadastro de usuários**

---

## 🔐 Segurança

O projeto utiliza **Spring Security** com autenticação baseada em **JWT**.  
Somente usuários autenticados podem acessar os endpoints protegidos.

---

## 🧪 Como Rodar Localmente

> Pré-requisitos: Java 17+, Maven, PostgreSQL

1. Clone o repositório:
```bash
git clone https://github.com/seu-usuario/cinecloud.git
cd cinecloud
```

2. Configure o banco de dados no arquivo `.env` ou `application.properties`:
```
spring.datasource.url=jdbc:postgresql://localhost:5432/cinecloud_db
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
jwt.secret=umaChaveSecretaBemForteAqui
```

3. Execute a aplicação:
```bash
./mvnw spring-boot:run
```

4. Acesse:
```
http://localhost:8080
```

---

## 📁 Estrutura do Projeto

```
src/
├── controller/
├── model/
├── repository/
├── service/
├── security/
└── dto/
```

---

## 🚧 Status do Projeto

🛠 Em desenvolvimento

---

## 👤 Autor

**Andrius Anselmi**  
[GitHub](https://github.com/seu-usuario)

---

## 📄 Licença

Este projeto está licenciado sob a licença MIT.  
Consulte o arquivo [LICENSE](./LICENSE) para mais informações.
