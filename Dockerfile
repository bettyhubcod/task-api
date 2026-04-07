# Étape 1 : construire l'application avec Maven (si vous utilisez Maven)
FROM maven:3.8.7-eclipse-temurin-17 AS build

WORKDIR /app

# Copier les fichiers sources dans le conteneur
COPY pom.xml .
COPY src ./src

# Construire le projet et créer le jar
RUN mvn clean package -DskipTests

# Étape 2 : créer l'image finale à partir d'une image Java légère
FROM eclipse-temurin:17-jdk-jammy

# Copier le jar construit depuis l'étape de build
COPY --from=build /app/target/*.jar app.jar

# Exposer le port utilisé par votre app (8085 pour Task API)
EXPOSE 8085

# Lancer l'application
ENTRYPOINT ["java", "-jar", "/app.jar"]