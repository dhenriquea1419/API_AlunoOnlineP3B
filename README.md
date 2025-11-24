# 🎓 Aluno Online API

A **Aluno Online API** é uma aplicação RESTful desenvolvida em **Java 17 com Spring Boot**, que permite o gerenciamento de **alunos**, **professores**, **disciplinas** e **notas** através de matrículas. É ideal para uso em sistemas escolares ou universitários.

---

## 📦 Tecnologias Utilizadas

- ✅ Java 17  
- ✅ Spring Boot
- ✅ Spring Security
- ✅ Spring Data JPA  
- ✅ PostgreSQL  
- ✅ Maven  

---

## 📁 Entidades do Sistema

### 🧑 Aluno

| Campo      | Tipo   |
|------------|--------|
| idAluno    | Long   |
| nomeAluno  | String |
| emailAluno | String |
| cpfAluno   | String |

---

### 👨‍🏫 Professor

| Campo           | Tipo   |
|-----------------|--------|
| idProfessor     | Long   |
| nomeProfessor   | String |
| emailProfessor  | String |
| cpfProfessor    | String |

---

### 📚 Disciplina

| Campo         | Tipo    |
|---------------|---------|
| idDisciplina  | Long    |
| nomeDisciplina| String  |
| cargaHoraria  | Integer |
| professor     | Professor (relacionamento @ManyToOne) |

---

### 📝 MatriculaAluno

| Campo        | Tipo     |
|--------------|----------|
| idMatricula  | Long     |
| aluno        | Aluno (@ManyToOne) |
| disciplina   | Disciplina (@ManyToOne) |
| nota1        | Double   |
| nota2        | Double   |
| status       | Enum (`MatriculaAlunoStatusEnum`) |

---

## 🔌 Endpoints Planejados

> ⚠️ Endpoints em desenvolvimento – essa seção pode evoluir com o projeto

### Aluno

- `GET /alunos` – Listar todos os alunos  
- `GET /alunos/{id}` – Buscar aluno por ID  
- `POST /alunos` – Cadastrar novo aluno  
- `PUT /alunos/{id}` – Atualizar dados do aluno  
- `DELETE /alunos/{id}` – Deletar aluno  

### Professor

- `GET /professores`  
- `POST /professores`  
- ...

### Disciplina

- `GET /disciplinas`  
- `POST /disciplinas`  
- ...

### Matrícula e Notas

- `GET /matriculas`  
- `POST /matriculas` – Registrar matrícula com notas  
- `PUT /matriculas/{id}` – Atualizar notas e status  
- `GET /matriculas/aluno/{id}` – Consultar notas por aluno  

---

## ⚙️ Como Executar Localmente

1. **Clone o repositório:**

```bash
git clone https://github.com/dhenriquea1419/API_AlunoOnlineP3B.git
cd API_AlunoOnlineP3B


Configure o banco de dados no arquivo src/main/resources/application.properties:

properties
Copiar
Editar
spring.application.name=Aluno Online

# Configuração do Banco de Dados
spring.datasource.url=jdbc:postgresql://localhost:5432/aluno_online_p3b
spring.datasource.username=postgres
spring.datasource.password=postgres
spring.datasource.driver-class-name=org.postgresql.Driver

# Configuração do Hibernate (JPA)
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

# Pool de Conexões com HikariCP
spring.datasource.hikari.maximum-pool-size=10
spring.datasource.hikari.minimum-idle=2
spring.datasource.hikari.idle-timeout=30000
spring.datasource.hikari.max-lifetime=1800000
spring.datasource.hikari.connection-timeout=30000

# Log SQL detalhado (útil para debug)
logging.level.org.hibernate.SQL=DEBUG
logging.level.org.hibernate.type.descriptor.sql.BasicBinder=TRACE
⚠️ Verifique se o banco aluno_online_p3b existe em sua instância PostgreSQL local.
Você pode criá-lo com:

sql
Copiar
Editar
CREATE DATABASE aluno_online_p3b;


🧪 Testes
./mvnw test


🙋‍♂️ Contribuições
Contribuições são bem-vindas!
Abra uma issue ou envie um pull request com suas melhorias.
