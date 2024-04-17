
# API de Autenticação JWT

🐳 Bem-vindo à documentação da API de Autenticação JWT! Esta API permite que você gerencie autenticação e autorização em sua aplicação usando JSON Web Tokens (JWT).

## Autenticação

Para acessar os recursos protegidos pela API, você precisa autenticar-se primeiro. Siga as etapas abaixo para autenticar-se:

### Solicitação de Login

Envie uma solicitação POST para `/api/auth/login` com suas credenciais de usuário no corpo da solicitação. Por exemplo:

```json
{
  "username": "seu-usuario",
  "password": "sua-senha"
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

1. Faça o clone da aplicação aqui neste repositorio

```
git clone https://github.com/beatrizgomees/api-authentication

```
### Será necessário alterar a url do jdbc removendo onde tiver localhost por 172.17.0.1

2. Abra o arquivo application.properties ou application.yml onde você configurou as propriedades do Spring Boot.

  Localize as configurações relacionadas ao banco de dados. No seu caso, essas configurações incluem:

  Url do postgres
  ```
  spring.datasource.url=jdbc:postgresql://172.17.0.1:5432/apiauthentication
  ```
  
  Altere o valor da propriedade spring.datasource.url para refletir a nova URL do banco de dados desejada. Por exemplo, se você deseja alterar o IP do banco de dados     para localhost, você pode alterar para:
  
  Url do Flyway, localizada logo abaixo
  
```
  spring.datasource.url=jdbc:postgresql://localhost:5432/apiauthentication
```
  
  Salve as alterações no arquivo.

3. Execute a aplicação em um ambiente Docker:

  Certifique-se de ter o Docker instalado em sua máquina. Execute o seguinte comando na raiz do projeto clonado:

  ```
  
  docker compose up --build --remove-orphans
  
  ```

  Após a execução do comando, você pode acessar essa URL em seu navegador para visualizar e interagir com a documentação da API.

  ```
  
  http://localhost:8080/swagger-ui/index.html
  
  ```
## Stacks 
- Java 21
- SpringBoot
- SpringSecurity
- SpringDoc
- OpenApi
- Docker
- Gradlew
- PostgreSQL
<div style="display: inline_block">
  <h4>Stacks</h4>
  
  <img align="center" alt="Bea-Java" height="30" width="40" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" />
  <img align="center" alt="Bea-Dart" height="50" width="60" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/docker/docker-original-wordmark.svg" />
 <img align="center" height="50" width="60" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/openapi/openapi-plain-wordmark.svg" />
  <img align="center" height="30" width="40" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/postgresql/postgresql-original.svg" />
  <img align="center" height="30" width="40" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original.svg" />
  <img align="center" height="30" width="40" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/gradle/gradle-original.svg" />
         
</div>



