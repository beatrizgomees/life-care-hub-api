# API de Autenticação JWT

Bem-vindo à documentação da API de Autenticação JWT! Esta API permite que você gerencie autenticação e autorização em sua aplicação usando JSON Web Tokens (JWT).

---

## Autenticação

Para acessar os recursos protegidos pela API, você precisa autenticar-se primeiro. Aqui está como você pode fazer isso:

### Solicitação de Login

Envie uma solicitação POST para `/api/auth/login` com suas credenciais de usuário.

Exemplo de corpo da solicitação:
```json
{
  "username": "usuario",
  "password": "senha"
}

```
Se as credenciais estiverem corretas, você receberá um token de acesso JWT no corpo da resposta.

Exemplo de resposta bem-sucedida:

```json

{
  "token": "seu-token-jwt"
}
```
Autorização

Depois de obter o token JWT, você pode usá-lo para acessar os recursos protegidos pela API. Adicione o token JWT ao cabeçalho Authorization em suas solicitações HTTP.

Exemplo de cabeçalho de autorização:
```

Authorization: Bearer seu-token-jwt

```

# Para Utilizar a API

### Faça o clone da aplicação aqui neste repositorio

```
git clone

```

### Depois é só rodar em sua máquina e acessar a url 

```
http://localhost:8080/swagger-ui/index.html

```

