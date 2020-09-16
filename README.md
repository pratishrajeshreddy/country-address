# GraphQL Application

This application helps you get the list of address based on country code (Example USA) using GraphQL. GraphQL is a query language that offers an alternative model to developing APIs (REST, SOAP or gRPC) with detailed description.

Address will have ID, country, addressLine1, addressLine2, street, city, state, country, countryCode, zipCode

## Getting Started

This application was developed using Spring Boot, Mysql, JPA and Graphql.

## Requirements

Java - 1.8.x

Maven - 3.x.x

Mysql - 5.x.x

## Steps to Setup

**1. Configure MySQL Database

+ open `src/main/resources/application.properties`

+ change `spring.datasource.url` value for database as per your mysql installation. Currently the value provided is "graphql"

Create Mysql database if there is no existing database**
```bash
create database graphql
```

+ change `spring.datasource.username` and `spring.datasource.password` as per your mysql installation

**2. Build and run the app using maven**

```bash
mvn clean install
java -jar target/graphql-0.0.1-SNAPSHOT.jar```

Alternatively, you can run the app without packaging it using -

```bash
mvn spring-boot:run
```

The app will start running at <http://localhost:8080>.

## Explore GraphQL

The app defines following endpoint (POST Request)

http://localhost:8080/apis/graphql

Set the Content-type:application/graphql in headers

Graphql provides findAllAddress and findAllAddressByCountry functionality.

You can test them using postman or any other rest client.

## Running the tests

To run the unit tests, call mvn test