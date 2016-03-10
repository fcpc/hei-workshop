Blog API - Server Side
===

[![Build Status](https://img.shields.io/travis/TORO-IO/hei-workshop/heroku-blog-api.svg)]()

### Technologies
- [Apache Maven](https://maven.apache.org/) - Project dependency management build tool
- [Spring Framework](http://projects.spring.io/spring-framework) - Dependency injection framework
- [Spring Boot](http://projects.spring.io/spring-boot/) - Project for rapid development of Spring applications

### Running
```
➜ mvn spring-boot:run
```
Access your server via: [http://localhost:8080]()

## **Session 1**: Building RESTful Applications with Spring
**Goal**: Expose JSON-returning URL endpoints for managing a blog application.
  - `GET`     /api/blogs
  - `GET`     /api/blogs/{id}
  - `POST`    /api/blogs
  - `DELETE`  /api/blogs/{id}

**Extras**: Build a well-defined error responses for exceptions.

## **Session 2**: Securing RESTful endpoints with Spring
**Goal**: Secure URL endpoints by implementing a token-based authentication-authorization model.
  - `POST`    /api/login
