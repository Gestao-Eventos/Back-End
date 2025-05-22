# 🎉 Gerenciador de Eventos e Participantes

Este projeto é uma API REST desenvolvida em Java com Spring Boot para o gerenciamento de eventos e participantes. Ele permite o cadastro de eventos, inscrição de participantes, controle de vagas e organização das informações.


## 📌 Funcionalidades:

### 🔹 Eventos
- Criar novo evento (nome, descrição, data, local e número de vagas)
- Listar eventos disponíveis
- Atualizar informações de um evento
- Excluir evento

### 🔹 Participantes
- Cadastro de participante (nome, e-mail, telefone)
- Inscrição em evento (verifica disponibilidade de vagas)
- Cancelamento de inscrição
- Listar todos os participantes de um evento


## 🚀 Tecnologias

- Java 21
- Dev Tools
- Spring Web
- Validation
- Spring Data JPA
- MySQL

## 🔧 Como Executar o Projeto

*1.* **Clone o repositório**
   ```bash
   git clone https://github.com/Gestao-Eventos
   cd Back-End
   ```
**2.** **Abra o eclipse IDE**

**3.** **Execute o projeto:**

**Clique com o botão direito no projeto**

**Selecione: Run As > Java Application**

**4. Certifique-se de que o MySQL esteja rodando e configure corretamente o application.properties.**



## 🔗 Endpoints

```
🔸 Eventos
POST /eventos – Criar evento

GET /eventos – Listar todos os eventos

PUT /eventos/{id} – Atualizar evento

DELETE /eventos/{id} – Deletar evento

🔸 Participantes
POST /participantes – Cadastrar participante

POST /eventos/{id}/inscricao – Inscrever participante em evento

DELETE /eventos/{id}/cancelar – Cancelar inscrição

GET /eventos/{id}/participantes – Listar participantes de um evento

```

```
| Pessoa         | Membro         | Responsabilidades                                                              |
| -------------- | -------------- | ------------------------------------------------------------------------------ |
| Pessoa 1       | **Claudemir**  | Configuração do projeto, criação das entidades e mapeamento de relacionamentos |
| Pessoa 2       | **Matheus S.** | Implementação dos repositórios, DTOs, regras de negócio e lógica de inscrições |
| Pessoa 3       | **Matheus F.** | Desenvolvimento dos controllers (endpoints) e testes com o Postman             |
| Pessoa 4       | **Monique**    | Organização do GitHub, documentação (`README.md`) e acompanhamento de commits  |

```






   

