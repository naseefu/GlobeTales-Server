FROM openjdk:21-jdk-slim as build

# Install Maven
RUN apt-get update && apt-get install -y maven

# Copy project files
COPY . .

# Run Maven build
RUN mvn clean package -DskipTests

# Final image
FROM openjdk:21-jdk-slim

# Copy the generated .jar file from the build stage
COPY --from=build /target/globetales-0.0.1-SNAPSHOT.jar globetales.jar

# Expose port 8080
EXPOSE 8080

# Run the application
ENTRYPOINT [ "java", "-jar", "globetales.jar" ]
