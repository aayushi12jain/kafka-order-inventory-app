# Use official Java base image
FROM openjdk:17-jdk-slim

# Add a label (optional)
LABEL maintainer="aayushi12jain@gmail.com"

# Set the working directory
WORKDIR /app

# Copy the built jar to the image
COPY target/order-pipeline-0.0.1-SNAPSHOT.jar app.jar

# Run the application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
