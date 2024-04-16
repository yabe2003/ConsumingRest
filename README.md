
# ConsumingRest

## Overview
This repository contains a Spring Boot application designed to consume a RESTful service.

## Building the Application
To build and run this application, you will need Maven and Java 11 installed on your system.

### Steps to Build:
1. Clone the repository:
   ```bash
   git clone <repository-url>
   ```
2. Navigate to the project directory:
   ```bash
   cd ConsumingRest
   ```
3. Run the application using Maven:
   ```bash
   mvn spring-boot:run
   ```

## Using Docker to Build and Run
To build a Docker image and run it locally, follow these steps:

1. Build the Docker image:
   ```bash
   docker build -t consumingrest .
   ```
2. Run the Docker container:
   ```bash
   docker run -p 8080:8080 consumingrest
   ```
