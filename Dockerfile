# Use OpenJDK 17 as the base image
FROM openjdk:17-jdk-alpine

# Set the working directory to /app
WORKDIR /app

# Copy the packaged Spring Boot application to the container
COPY target/demo1509*.jar /app/app.jar

# Expose port 8080 for the Spring Boot application
EXPOSE 8080

# Set the command to run the Spring Boot application when the container starts
CMD ["java", "-jar", "app.jar"]