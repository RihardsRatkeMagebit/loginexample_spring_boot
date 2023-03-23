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


## Application configuration
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

### Models:
#### Examples
-  src/main/java/com/example/demo/model/Customer.java

### Views:
#### ALL VIEWS MUST BE HANDLED IN REACT

---

## Maven
Getting starter guide
https://maven.apache.org/guides/getting-started/

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

