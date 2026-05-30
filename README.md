# 🎬 CineGraph

API REST desenvolvida com **Spring Boot** e **ArangoDB** para gerenciamento de filmes, usuários e avaliações.

A aplicação fornece endpoints para cadastro, consulta, atualização de dados, permitindo que aplicações consumam informações sobre filmes e suas avaliações.

## Sobre

O CineGraph é uma API responsável por centralizar o gerenciamento de usuários, filmes e avaliações. Através dela, clientes podem realizar operações de CRUD, consultar filmes por gênero, visualizar avaliações e calcular a média das notas atribuídas a cada filme.

O projeto foi desenvolvido com o objetivo de explorar os recursos do ArangoDB, um banco de dados NoSQL multi-modelo que suporta documentos, grafos e chave-valor, demonstrando sua integração com o ecossistema Spring.

---

## Tecnologias Utilizadas

- Java 21
- Spring Boot 3.3.5
- Maven
- ArangoDB
- Lombok
- Jakarta Validation

---

## Estrutura do Projeto

```text
src/main/java/arango/dev/CineGraph
│
├── config
│   └── ArangoConfig
│
├── controller
│   ├── AvaliacaoController
│   ├── FilmeController
│   └── UsuarioController
│
├── model
│   ├── Avaliacao
│   ├── Filme
│   ├── Usuario
│   └── dto
│       ├── MediaFilmeDTO
│       └── UsuarioDTO
│
├── repository
│   ├── AvaliacaoRepository
│   ├── FilmeRepository
│   └── UsuarioRepository
│
├── service
│   ├── AvaliacaoService
│   ├── FilmeService
│   └── UsuarioService
│
└── CineGraphApplication
```
---

## Endpoints

### Usuários

| Método | Endpoint |
|----------|----------|
| POST | /usuarios |
| PUT | /usuarios/{id} |
| GET | /usuarios/{id} |
| GET | /usuarios/email |
| GET | /usuarios/{id}/avaliacoes |
| GET | /usuarios |
| DELETE | /usuarios/{id} |

### Filmes

| Método | Endpoint |
|----------|----------|
| POST | /filmes |
| PUT | /filmes/{id} |
| GET | /filmes/{id} |
| GET | /filmes/genero/{genero} |
| GET | /filmes |
| GET | /filmes/{id}/media |
| DELETE | /filmes/{id} |

### Avaliações

| Método | Endpoint |
|----------|----------|
| POST | /avaliacoes |
| GET | /avaliacoes |
| GET | /avaliacoes/filme/{id} |
| GET | /avaliacoes/usuario/{id} |
| DELETE | /avaliacoes/{id} |


---

## Execução

### 1. Clonar o repositório

```bash
git clone https://github.com/CCodeKey/CineGraph
```

### 2. Executar o ArangoDB com Docker

```bash
docker run -d --name arangodb -p 8529:8529 -e ARANGO_ROOT_PASSWORD=root arangodb
```


### 3. Executar a aplicação

```bash
mvn spring-boot:run
```

---
## Autores
<table> <tr> <td align="center"> <a href="https://github.com/CCodekey"> <img src="https://avatars.githubusercontent.com/u/105808889?v=4" width="100px;" alt="Gabriel T."/><br> <sub> <b>Gabriel Tertuliano</b> </sub> </a> </td> <td align="center"> <a href="https://github.com/kaleu-victor"> <img src="https://avatars.githubusercontent.com/u/169067294?v=4" width="100px;" alt="Kaléu V."/><br> <sub> <b>Kaléu Victor</b> </sub> </a> </td> </tr> </table>

---