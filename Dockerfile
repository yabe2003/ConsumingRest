# Use OpenJDK 11 JRE for the runtime environment
FROM openjdk:11-jre-slim

# Set the working directory inside the Docker container
WORKDIR /app

# Copy the built JAR file into the Docker container
COPY target/*.jar app.jar

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
