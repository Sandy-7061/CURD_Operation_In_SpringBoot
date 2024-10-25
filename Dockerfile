# Use an OpenJDK base image suitable for Java applications
FROM openjdk:17-jdk-slim

# Add author metadata
LABEL authors="Sandeep"

# Set the working directory in the container
WORKDIR /app

# Copy the Spring Boot JAR file into the container
COPY target/CURD_operation-0.0.1-SNAPSHOT.jar app.jar

# Expose the port Spring Boot runs on (usually 8080)
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]
