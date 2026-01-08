**Fitness Tracker Backend Application**

This repository contains the backend implementation of a Fitness Tracker application developed using Java and Spring Boot. The project is designed with a strong emphasis on security, scalability, clean architecture, and production readiness. It exposes RESTful APIs for user authentication, activity tracking, and fitness recommendations.

**Project Overview**

The Fitness Tracker backend is built following standard enterprise backend practices. The application uses stateless authentication, role-based authorization, and a layered architecture to ensure maintainability and extensibility. All sensitive configurations are externalized, and the system is suitable for both local development and cloud deployment.

**Core Features**

The application provides secure REST APIs for user registration and authentication using JWT-based access control. It supports activity tracking and fitness recommendations with a relational data model backed by PostgreSQL. The backend follows clean separation of concerns across controller, service, and repository layers. Centralized exception handling is implemented to ensure consistent error responses. The application is containerized for reliable builds and deployments.

**Technology Stack**

Backend development is done using Java and Spring Boot. Security is implemented using Spring Security with JWT-based authentication and authorization. Data persistence is handled using PostgreSQL with JPA and Hibernate ORM. API testing is performed using Postman. The application is containerized using Docker and uses Maven for dependency management and builds. PostgreSQL is deployed on Neon for cloud-based persistence.

**Architecture and Design**

The application follows a layered architecture. Controllers handle HTTP requests and responses. Services contain business logic. Repositories manage database interactions. DTOs are used to decouple API contracts from persistence models. Security concerns are isolated within a dedicated security package. Global exception handling ensures predictable error responses.
**
Security Implementation**

Authentication is implemented using stateless JWT tokens. Passwords are securely stored using hashing mechanisms. Requests are authorized using Spring Security filters and role-based access control. A custom JWT authentication filter validates tokens on each request. Sensitive configuration values are not stored in source code.

**Project Structure**

The source code is organized into logical packages for controllers, services, repositories, models, DTOs, security configuration, exception handling, and application configuration. This structure improves readability, maintainability, and scalability.

**Database Configuration**

The application uses PostgreSQL as the relational database. Entity relationships are defined using JPA annotations. Queries are optimized using Spring Data JPA. Database credentials and connection URLs are managed through environment variables to avoid hardcoding sensitive information.

**Environment Variables**

The following environment variables must be configured before running the application:

DB_URL
DB_USER
DB_PWD

Spring Boot reads these variables directly through the application configuration.

**Docker Support**

The application is containerized using Docker to ensure consistency across development and deployment environments. Docker enables reliable builds, simplified deployment, and portability across systems.

**Deployment**

The PostgreSQL database is hosted on Neon. The backend is configured to connect securely to the cloud database using production-ready settings. The application is suitable for deployment in containerized environments.

**API Testing**

All APIs are tested using Postman to validate authentication flows, authorization rules, request validation, and error handling. Testing ensures reliability and correctness of the exposed endpoints.

**Future Enhancements**

Planned improvements include refresh token support, pagination and filtering for APIs, rate limiting, unit and integration testing, and deployment to a managed cloud service.

**Author**

**Siddharth **
Computer Science Student with a strong focus on backend development using Java and Spring Boot. Actively building secure, scalable REST APIs and learning industry-grade software engineering practices.﻿


