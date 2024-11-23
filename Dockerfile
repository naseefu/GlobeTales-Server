# Use an official Maven image to build the project
FROM maven:3.8.4-jdk-21 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the pom.xml to download dependencies
COPY pom.xml .

# Download the dependencies first
RUN mvn dependency:go-offline -B

# Copy the project files into the container
COPY src ./src

# Package the application (skipping tests for now)
RUN mvn clean package -DskipTests

# Use a slim JDK image to run the Spring Boot app
FROM openjdk:21-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the jar file from the build stage to the final image
COPY --from=build /app/target/task-0.0.1-SNAPSHOT.jar /app/task-manager.jar

# Expose the default Spring Boot port
EXPOSE 8080

# Command to run the Spring Boot application
ENTRYPOINT ["java", "-jar", "/app/task-manager.jar"]
