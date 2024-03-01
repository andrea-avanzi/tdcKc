# Build --platform=linux/amd64
FROM --platform=linux/amd64 maven:3.8.3-openjdk-17 AS build
COPY . /app
WORKDIR /app
RUN mvn package -DskipTests

FROM --platform=linux/amd64 eclipse-temurin:17-jdk

WORKDIR /app
ARG JAR_FILE=/app/target/*.jar
COPY --from=build ${JAR_FILE} app.jar

RUN mkdir config

EXPOSE 8096/tcp

ENTRYPOINT ["java","-jar","app.jar"]

