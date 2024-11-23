FROM openjdk:21-jdk-slim as build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:21-jdk-slim
COPY --from=build /target/globetales-0.0.1-SNAPSHOT.jar globetales.jar
EXPOSE 8080
ENTRYPOINT [ "java","-jar","globetales.jar" ]
