# Sistema de Gerenciamento de Cursos e Matrículas

## Aluno

**Nome:** Eduardo Bernardino Gomes Neto - RA: 2508915 & Matheus dos Santos RA: 2613310

## Descrição da API

API REST desenvolvida com Spring Boot para gerenciar cursos, alunos e matrículas. A aplicação utiliza Spring Data JPA para persistência em banco H2 e oferece operações de cadastro, consulta, atualização e remoção. As listagens aceitam paginação e ordenação.

Uma matrícula relaciona um aluno a um curso. A API impede matrículas em cursos inativos e de alunos com menos de 16 anos. Os campos dos cadastros são validados com Bean Validation.

## Endpoints disponíveis

Todos os endpoints usam a base `http://localhost:8080`.

### Cursos

| Método | Endpoint | Descrição |
|---|---|---|
| `POST` | `/cursos` | Cadastrar curso |
| `GET` | `/cursos` | Listar cursos com paginação |
| `GET` | `/cursos/{id}` | Buscar curso por ID |
| `PUT` | `/cursos/{id}` | Atualizar curso |
| `DELETE` | `/cursos/{id}` | Remover curso |

### Alunos

| Método | Endpoint | Descrição |
|---|---|---|
| `POST` | `/alunos` | Cadastrar aluno |
| `GET` | `/alunos` | Listar alunos com paginação |
| `GET` | `/alunos/{id}` | Buscar aluno por ID |
| `PUT` | `/alunos/{id}` | Atualizar aluno |
| `DELETE` | `/alunos/{id}` | Remover aluno |

### Matrículas

| Método | Endpoint | Descrição |
|---|---|---|
| `POST` | `/matriculas` | Realizar matrícula |
| `GET` | `/matriculas` | Listar matrículas com paginação |
| `GET` | `/matriculas/{id}` | Buscar matrícula por ID |
| `PUT` | `/matriculas/{id}` | Atualizar matrícula |
| `DELETE` | `/matriculas/{id}` | Cancelar matrícula |

As listagens aceitam `page`, `size` e `sort`. Exemplo: `GET /cursos?page=0&size=5&sort=nome,asc`.

Exemplo de corpo para cadastrar uma matrícula:

```json
{
  "dataMatricula": "2026-11-05",
  "status": "ATIVA",
  "cursoId": 1,
  "alunoId": 1
}
```

## Como executar o projeto

### Pré-requisitos

- Java 25
- Maven Wrapper incluído no projeto (`mvnw` / `mvnw.cmd`)

Na raiz do projeto, execute no Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

No Linux ou macOS:

```bash
./mvnw spring-boot:run
```

Após iniciar, a API estará disponível em `http://localhost:8080`. O banco H2 em arquivo será criado na raiz do projeto com o nome `trabalho2_db`.

O console do H2 fica disponível em `http://localhost:8080/h2-console`. Use estas configurações:

- **JDBC URL:** `jdbc:h2:file:./trabalho2_db`
- **User Name:** `sa`
- **Password:** deixe em branco

Uma collection do Postman para testar os endpoints está em `postman/Trabalho2 - Cursos e Matrículas.postman_collection.json`.
