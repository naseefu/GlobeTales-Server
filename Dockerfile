# Use Maven image for building the application
FROM maven:3.9.4-eclipse-temurin-21 as build

WORKDIR /app

# Copy Maven configuration and fetch dependencies
COPY pom.xml . 
RUN mvn dependency:go-offline

# Copy source code and build the application
COPY src ./src
RUN mvn clean package -DskipTests

# Use OpenJDK for running the application
FROM openjdk:21-jdk-slim

WORKDIR /app

# Copy the built JAR file
COPY --from=build /app/target/globetales-0.0.1-SNAPSHOT.jar .

# Expose the application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "/app/globetales-0.0.1-SNAPSHOT.jar"]
