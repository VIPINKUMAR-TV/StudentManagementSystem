# -------- STAGE 1: BUILD --------
FROM maven:3.9.9-eclipse-temurin-21 AS build

WORKDIR /app
COPY pom.xml .
RUN mvn -B -q -e -DskipTests dependency:go-offline

COPY src ./src
RUN mvn clean package -DskipTests


# -------- STAGE 2: RUNTIME (LIGHTWEIGHT) --------
FROM eclipse-temurin:21-jre-jammy

WORKDIR /app

# Copy built JAR from build stage
COPY --from=build /app/target/*.jar app.jar

# Render provides PORT automatically
EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]
