![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/SpringBoot-3.4.1-green)
![Spring Cloud](https://img.shields.io/badge/SpringCloud-2024.x-blue)
![Netflix Eureka](https://img.shields.io/badge/Netflix%20Eureka-Discovery-brightgreen)
![Spring Cloud Gateway](https://img.shields.io/badge/Gateway-Routing-blueviolet)
![OpenFeign](https://img.shields.io/badge/OpenFeign-HTTPClient-9cf)
![Spring Data JPA](https://img.shields.io/badge/Spring%20Data%20JPA-ORM-ff69b4)
![MySQL](https://img.shields.io/badge/MySQL-8.0-blue)
![Maven](https://img.shields.io/badge/Maven-Build-success)
![Lombok](https://img.shields.io/badge/Lombok-1.18.36-informational)


#Java Microservices Architecture
Spring Boot | Spring Cloud | Eureka | API Gateway
GitHub Repository: github.com/SantiagoCrivellaro/Java-Microservicios

#Overview

This project implements a robust microservices architecture using Spring Boot and Spring Cloud. It demonstrates best practices for distributed system design, including service registration and discovery, API gateway routing, inter-service communication via Feign client, and centralized configuration management.

The system manages student and course data with isolated databases, enabling independent scaling and deployment while maintaining seamless data coordination across service boundaries.

#System Architecture
Core Components
ServicePortDescriptionEureka Server8761Service registry and discoveryConfig Server8888Centralized configuration managementAPI Gateway8080Request routing and load balancingStudents Service8090Student management with MySQLCourses Service9090Course and enrollment management

##Prerequisites

Java Development Kit (JDK) 21
Apache Maven 3.8.1 or higher
MySQL 8.0 or compatible
Spring Boot 3.4.1

#Project Structure
The project is organized as a Maven multi-module application:

microservice-config – Spring Cloud Config Server
microservice-eureka – Service Registry
microservice-gateway – API Gateway
microservice-students – Student Management Service
microservice-course – Course Management Service

#Installation and Setup

##1. Clone Repository
git clone https://github.com/SantiagoCrivellaro/Java-Microservicios.git
cd Java-Microservicios

##2. Database Setup
Create two MySQL databases:

studentdb – Student microservice data
coursedb – Course microservice data

SQL initialization scripts are included in each service module.

##3. Build Project
mvn clean install

##4. Service Startup Order
Start services in the following order:

Config Server (port 8888)
Eureka Server (port 8761)
Students Service (port 8090)
Courses Service (port 9090)
API Gateway (port 8080)



#API Endpoints

##Students Service
MethodEndpointDescriptionStatusPOST/api/students/createCreate new student201GET/api/students/allRetrieve all students200GET/api/students/search/{id}Get student by ID200GET/api/students/search-by-course/{id}Get students by course200


##Courses Service
MethodEndpointDescriptionStatusPOST/api/courses/createCreate new course201GET/api/courses/allRetrieve all courses200GET/api/courses/search/{id}Get course by ID200GET/api/courses/search-student/{id}Get students by course200

#Key Technologies

Spring Boot 3.4.1 – Application framework
Spring Cloud – Microservices toolkit
Netflix Eureka – Service discovery
Spring Cloud Gateway – API gateway and routing
Spring Cloud Config – Configuration management
OpenFeign – Declarative HTTP client
Spring Data JPA – Persistence layer
MySQL 8.0 – Relational database
Lombok – Boilerplate code reduction


#Design Patterns & Best Practices

##Service Discovery
Services are automatically registered with Eureka upon startup and deregistered on shutdown. This enables dynamic service discovery without hardcoded endpoints.

##API Gateway
Spring Cloud Gateway provides a unified entry point for all client requests, handling routing, load balancing, and cross-cutting concerns.

##Inter-Service Communication
The Courses microservice uses OpenFeign to call the Students service via the gateway, demonstrating the proper pattern for synchronous inter-service communication.

##Centralized Configuration
All services retrieve their configuration from the Config Server, allowing environment-specific settings without code changes.


#Configuration Details

##Students Service Database
Database: studentdb

Uses JPA with automatic schema generation. Contains student records with course enrollment information.

##Courses Service Database
Database: coursedb
Manages course catalogs and instructor information. Integrates with Students service for enrollment queries.

#Troubleshooting

##Services Not Registering with Eureka
Ensure Eureka Server is running on port 8761. Verify each service has the correct eureka.client.service-url.defaultZone configuration pointing to the Eureka server.

##Database Connection Failures
Verify MySQL is running and accessible. Check datasource URL, username, and password in application configuration. Confirm databases exist and are accessible.

##Feign Client Errors
Ensure the target service is registered in Eureka. The gateway must be running to route inter-service requests. Check service names match exactly in @FeignClient annotation.

#Author
Santiago Crivellaro

GitHub: github.com/SantiagoCrivellaro
