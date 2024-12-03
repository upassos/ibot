FROM adoptopenjdk:11-jre-hotspot

# Set the working directory
WORKDIR /app
# Copy the JAR file to the container
COPY . .
# Expose the port that your Spring Boot application listens on (default is 8080)
EXPOSE 8085
# Define the command to run your application
CMD ["java", "-jar", "orchestrator-0.1.0-SNAPSHOT.jar"]