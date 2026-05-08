# Etapa 1: Compilación (Usamos Maven con Java 21)
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app

# Copiamos el archivo de configuración y el código fuente
COPY pom.xml .
COPY src ./src

# Compilamos el proyecto y evitamos correr tests para que la imagen se cree más rápido
RUN mvn clean package -DskipTests

# Etapa 2: Ejecución (Usamos una versión súper liviana de Java)
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Traemos el archivo .jar que se generó en la Etapa 1
COPY --from=build /app/target/*.jar app.jar

# Exponemos el puerto que usa tu Spring Boot
EXPOSE 8081

# Le decimos a Docker cómo arrancar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]