# Use uma imagem base do OpenJDK
FROM openjdk:17-jdk-slim

# Defina o diretório de trabalho dentro do contêiner
WORKDIR /workspace

# Copie o arquivo .jar gerado para o contêiner
COPY /target/portifolio-quarkus-api.jar /workspace/portifolio-quarkus-api.jar

# Exponha a porta 8080
EXPOSE 8080

# Comando para rodar o .jar
CMD ["java", "-jar", "/workspace/portifolio-quarkus-api.jar"]
