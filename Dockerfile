# Use Maven with Java 21 (stable and available) to build the Spring Boot app
FROM maven:3.9.6-eclipse-temurin-21 AS build

WORKDIR /app

# Copy pom and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy source code and build
COPY src ./src
RUN mvn clean package -DskipTests

# Use JDK 21 image to run the built app
FROM eclipse-temurin:21-jdk

WORKDIR /app
COPY --from=build /app/target/VerBI-0.0.1-SNAPSHOT.jar .

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "VerBI-0.0.1-SNAPSHOT.jar"]
