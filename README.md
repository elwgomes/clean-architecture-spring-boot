# spring-boot-rest-api-clean-architecture

An example of a clean architecture REST API with Spring Boot

## Intro
This application is designed using a [Clean Architecture pattern](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html) (also known as Hexagonal Architecture). Therefore [SOLID principles](https://en.wikipedia.org/wiki/SOLID_(object-oriented_design)) are used in code, especially the Dependency Inversion Principle (do not mix up with the classic dependency injection in Spring for example).

Concretely, there are two main packages: `core` (`domain` and `usecases`) and `infra`. These packages have to respect these rules:

#### notes
- `core` contains the business code and its `domain` logic, and has no outward dependency: nor on frameworks (Hibernate for example, we use a persistence object to do it), nor on use_cases or `infra` packages.
- `infra` contains all the technical details, configuration, implementations (database, web services, etc.), and must not contain any business logic. `infra` has dependencies on `domain`, use_cases and frameworks.

###### obs:
```
- `usecases` situated at the `core` package are like a conductor. It will only depend on the `domain` package to execute the business logic. Use cases should not have any `infra` dependencies.
```

# About this simple project

Builded with `JAVA 17` and `maven`.

#### Authentication

Originally, `SWAGGER` documents the entire API in detail, but it is worth remembering that it is necessary to use an authenticated login to use most endpoints.

###### auth/login


```
request:
{
  "username": "admin",
  "password": "admin"
}
```

You will receive a `JWT` token, use the `Bearer ` prefix concatenated to the token and you will be able to access the endpoints.

```
response:
{
  "access_token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c"
}

```

### Tecnologies
- Hibernate
- [Spring Boot](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)
- Spring Security 6
- [Swagger API](https://swagger.io/docs/specification/about/)
- Lombok (reduce boilerplate code)
- JWT

## Install
```
mvn clean package
```

## Run
```
mvn spring-boot:run
```
