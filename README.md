# Spring boot learning course
__Getting Started__:https://spring.io/guides/gs/spring-boot/

---
## Requirements
__Build tool__: Maven

__Jave version__: 19, 17, 11

__Spring Boot version__: 3.0.x

__Database__ MongoDB

__API platform__ Postman

---
## Annotations
https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/package-summary.html

Example notations:
__@RestController__
__@RequestMapping__

Lombok annotations:
https://projectlombok.org/api/lombok/package-summary

## IntelliJ fix lombok annotations
https://www.baeldung.com/lombok-ide



## Application configuration
Responsible for all apllication configurations, ports, mongodb etc..

__Location__:src/main/resources/application.properties

https://www.javatpoint.com/spring-boot-properties

---
## MVC Patter (Model, View, Controller)
https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93controller
- __Model__ responsible for representing Object/Resource
- __Controller__ Accepts input and converts it to commands for the model or view
- __View__ Representing data in a view

### Controller:
#### Examples
-  src/main/java/com/example/demo/controller/BasicController.java
-  src/main/java/com/example/demo/controller/Calculator.java
-  src/main/java/com/example/demo/controller/Customer.java
-  src/main/java/com/example/demo/controller/Index.java

###### More advanced examples:

- src/main/java/com/example/demo/controller/BookController.java

### Models:
#### Examples
-  src/main/java/com/example/demo/model/Customer.java
###### More advanced examples:
-  src/main/java/com/example/demo/model/Book.java

### Views:
#### ALL VIEWS MUST BE HANDLED IN REACT

---

### Services and Repositories
__Repositories__: The repository is a gateway between your domain/business layer and a data mapping layer, which is the layer that accesses the database and does the operations.

__Service__: The service should provide an API to your business logic.

#### Book example
- src/main/java/com/example/demo/service/BookService.java
- src/main/java/com/example/demo/model/repository/BookRepository.java
- src/main/java/com/example/demo/service/BookServiceInterface.java
- src/main/java/com/example/demo/controller/BookController.java


#### Currency example
- src/main/java/com/example/demo/service/CurrencyServiceInterface.java
- src/main/java/com/example/demo/service/CurrencyService.java
- src/main/java/com/example/demo/model/Currency.java
- src/main/java/com/example/demo/model/repository/CurrencyRepository.java
- src/main/java/com/example/demo/dto/CurrencyDTO.java

---

### DTO (Data Transfer Object)
https://www.baeldung.com/java-dto-pattern

--- 

## Maven
Getting starter guide
- https://maven.apache.org/guides/getting-started/

---

## Postman

Tool widely used to debugging and developing APIs worldwide
https://www.postman.com/downloads/

---

## MongoDB
__MongoDB__
https://www.mongodb.com/what-is-mongodb

### MongoDB query
https://www.mongodb.com/docs/manual/tutorial/query-documents/

### MongoDB package name
             <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter-data-mongodb</artifactId>
             </dependency>

### MongoDB in spring boot
https://www.mongodb.com/compatibility/spring-boot


### Server installation:

__Windows__: https://www.mongodb.com/docs/manual/tutorial/install-mongodb-on-windows/

__MacOS__: https://www.mongodb.com/docs/manual/tutorial/install-mongodb-on-os-x/

__MongoDB compass__: UI client for managing mongoDB
https://www.mongodb.com/try/download/compass 

---

### Security
https://docs.spring.io/spring-security/reference/getting-spring-security.html

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-security</artifactId>
        </dependency>

--- 

### Validation

__Validation module__: jakarta.validation.constraints
https://jakarta.ee/specifications/bean-validation/3.0/apidocs/jakarta/validation/constraints/package-summary.html

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
        </dependency>
        <dependency>
            <groupId>jakarta.validation</groupId>
            <artifactId>jakarta.validation-api</artifactId>
        </dependency>
