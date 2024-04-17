# Estágio de compilação:
FROM eclipse-temurin:21-jdk-alpine as builder


# Definir o diretório de trabalho
WORKDIR /app

# Copiar os arquivos Gradle
COPY build.gradle settings.gradle ./

# Copiar o wrapper Gradle
COPY gradlew ./
COPY gradle/ gradle/
RUN dos2unix gradlew
# Baixar dependências Gradle
RUN ./gradlew build

# Copiar o código fonte
COPY src src

# Compilar a aplicação Spring Boot com Gradle
RUN ./gradlew build

# Estágio de execução:
FROM eclipse-temurin:21-jdk-alpine

# Definir o diretório de trabalho
WORKDIR /app

# Expor a porta da aplicação
EXPOSE 8080

# Copiar o JAR gerado para a imagem final
COPY --from=builder /app/build/libs/*.jar app.jar

# Definir o comando de inicialização da aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
