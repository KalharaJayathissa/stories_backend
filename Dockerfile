# Use a JDK 21 base image (adjust version as needed)
FROM eclipse-temurin:21-jdk AS build

# Set working directory inside container
WORKDIR /app

# Copy Maven wrapper and pom files first for dependency caching
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Give execute permission to mvnw
RUN chmod +x mvnw

# Download dependencies only (cache layer)
RUN ./mvnw dependency:go-offline

# Copy the rest of the source code
COPY src ./src

# Build the project (skip tests to speed up build)
RUN ./mvnw clean package -DskipTests

# Second stage: minimal runtime image
FROM eclipse-temurin:21-jre

# Set working directory
WORKDIR /app

# Copy the built jar from build stage
COPY --from=build /app/target/*.jar app.jar

# Expose port (adjust if your app runs on a different port)
EXPOSE 8080

# Run the jar
ENTRYPOINT ["java", "-jar", "app.jar"]
