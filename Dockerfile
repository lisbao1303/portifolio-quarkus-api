# Use a imagem base recomendada pelo Quarkus
FROM eclipse-temurin:17-jre-alpine

# Defina o diretório de trabalho dentro do contêiner
WORKDIR /workspace

ENV HOST=0.0.0.0
ENV PORT=8080

# Exponha a porta usada pela aplicação
EXPOSE 8080

# Copie o JAR gerado para o contêiner
COPY target/portifolio-quarkus-api-runner.jar /workspace/portifolio-quarkus-api-runner.jar

# Comando para rodar o JAR
CMD ["java", "-jar", "/workspace/portifolio-quarkus-api-runner.jar"]
