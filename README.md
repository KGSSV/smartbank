# Smart-Bank-Spring-boot-Application
Smart-Bank-Spring-boot-Application

This repository contains a Spring Boot application with Spring Security implemented using JWT (JSON Web Token) authentication.

# Prerequisites
Before building and running the application, ensure you have the following installed:

1. Java Development Kit (JDK) 8 or later
2. Apache Maven (for building the project)
3. Postman (for testing the REST endpoints)

# Getting Started
Clone the repository to your local machine
```
git clone https://github.com/amitchalwade/Smart-Bank-Spring-boot-Application.git
cd Smart-Bank-Spring-boot-Application
```
# Build the project using Maven:
```
mvn clean package
```
# Run the application:
```
mvn spring-boot:run
```
The Spring Boot application will start, and the REST endpoints will be available at http://localhost:8080.

## Testing the Authentication Endpoint
To test the authentication endpoint, use Postman to send a POST request with the credentials:

Request Type: POST

Request URL: http://localhost:8080/api/users/authenticate

Request Type: GET

Request URL: http://localhost:8080/api/users/transactions

