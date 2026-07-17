# 🚗 DriverHub

API REST desenvolvida em Java com Spring Boot para auxiliar motoristas de aplicativo a compararem corridas do **Uber**, **99** e **inDrive**.

## 📋 Funcionalidades

- Cadastro de corridas por plataforma
- Cálculo automático do valor por km
- Classificação das corridas em **RUIM**, **BOA** ou **EXCELENTE**
- Ranking das melhores corridas em tempo real
- Validação de dados e tratamento de erros

## 🛠️ Tecnologias

- Java 17
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Lombok
- Maven

## 📡 Endpoints

| Método | Rota | Descrição |
|--------|------|-----------|
| POST | /corridas | Cadastrar corrida |
| GET | /corridas | Listar todas |
| GET | /corridas/melhores | Ranking das melhores |
| PUT | /corridas/{id} | Atualizar corrida |
| DELETE | /corridas/{id} | Deletar corrida |

## 👨‍💻 Autor

Feito por **Abner** — em desenvolvimento 🚀# DiverHub
