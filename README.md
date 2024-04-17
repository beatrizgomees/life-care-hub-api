markdown

# JWT Authentication API

🐳 Welcome to the JWT Authentication API documentation! This API allows you to manage authentication and authorization in your application using JSON Web Tokens (JWT).

## Authentication

To access the resources protected by the API, you need to authenticate first. Follow the steps below to authenticate:

### Login Request

Send a POST request to `/api/auth/login` with your user credentials in the request body. For example:

```json
{
  "username": "your-username",
  "password": "your-password"
}
```
If the credentials are correct, you will receive a JWT access token in the response body.

Successful response example:
```
json

{
  "token": "your-jwt-token"
}
```

Authorization

After obtaining the JWT token, you can use it to access the protected resources of the API. Add the JWT token to the Authorization header in your HTTP requests.

Authorization header example:

```

Authorization: Bearer your-jwt-token
```

# How to Use the API

    Clone the application from this repository

```

git clone https://github.com/beatrizgomees/api-authentication
```

### You will need to change the JDBC URL by removing where it has localhost to 172.17.0.1

    Open the application.properties or application.yml file where you configured the Spring Boot properties.

    Locate the database-related configurations. In your case, these configurations include:
```

spring.datasource.url=jdbc:postgresql://172.17.0.1:5432/apiauthentication

```

### Change the value of the spring.datasource.url property to reflect the desired new database URL. For example, if you want to change the database IP to localhost, you can change it to:

Flyway URL, located just below

```

spring.datasource.url=jdbc:postgresql://localhost:5432/apiauthentication
```

Save the changes to the file.

Run the application in a Docker environment:

Make sure you have Docker installed on your machine. Run the following command at the root of the cloned project:

```
docker compose up --build --remove-orphans
```

### After running the command, you can access this URL in your browser to view and interact with the API documentation.

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



