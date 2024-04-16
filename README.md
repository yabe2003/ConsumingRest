# ConsumingRest

## Overview
This repository contains a Spring Boot application designed to consume a RESTful service, demonstrating how to connect to external APIs and handle responses. The application is containerized using Docker, making it easy to deploy in different environments, including Kubernetes.

## Prerequisites
- Java 11
- Maven
- Docker (for building and running Docker containers)
- Kubernetes (for deploying the application on a Kubernetes cluster)

## Building the Application Locally

### Steps to Build:
1. Clone the repository:
   ```bash
   git clone <repository-url>
   ```
2. Navigate to the project directory:
   ```bash
   cd ConsumingRest
   ```
3. Build the project using Maven:
   ```bash
   mvn clean package
   ```
4. Run the application using Maven:
   ```bash
   mvn spring-boot:run
   ```

## Using Docker to Build and Run
Build and run the application using Docker by following these steps:

1. Build the Docker image:
   ```bash
   docker build -t consumingrest .
   ```
2. Run the Docker container (ensure your Docker environment can communicate with any external services it needs to connect to):
   ```bash
   docker run -p 8080:8080 consumingrest
   ```

## Deploying on Kubernetes

### Deploying the Application
Deploy the application to a Kubernetes cluster by applying the Kubernetes configurations:

1. Apply the Kubernetes Deployment:
   ```bash
   kubectl apply -f deployment.yaml
   ```
2. Apply the Kubernetes Service:
   ```bash
   kubectl apply -f service.yaml
   ```

### Verifying the Deployment
Check the status of the deployed resources and ensure they are running correctly:

- View deployments:
  ```bash
  kubectl get deployments
  ```
- View pods:
  ```bash
  kubectl get pods
  ```
- View services to access the External IP (if using LoadBalancer):
  ```bash
  kubectl get services
  ```

### Accessing the Application
If using a LoadBalancer service, the application can be accessed through the external IP provided by the Kubernetes service. Otherwise, configure port forwarding or use a NodePort to access the application.

### Scaling the Application
Scale your deployment if needed by adjusting the number of replicas:

```bash
kubectl scale deployment consumingrest-deployment --replicas=3
```

## Additional Notes
- Ensure that any external services the application needs to communicate with are accessible from your Kubernetes cluster.
- Update the Docker image and redeploy as necessary to reflect changes in the application.
