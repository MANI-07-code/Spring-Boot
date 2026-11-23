csrf - cross site request forgery

It is a security attack where an attacker tricks a user who is already logged in to a website into performing an unwanted action without their knowledge.

CSRF protection is generally not needed for GET requests, provided that GET is used only to read data and does not change the application's state.

HTTP         method	Purpose	               CSRF protection
GET	         Read data	Generally          not required
POST	       Create or submit data	       Usually required
PUT	         Update data	                 Usually required
PATCH	       Partially update data	       Usually required
DELETE	     Delete data	                 Usually required

HTTP by default stateless - so we have session id that the browser remember us

Spring Security can protect against CSRF by requiring a valid CSRF token with requests that change data.
Think of the token as an extra security check.
1. The server generates a CSRF token.
2. The legitimate application receives the token.
3. When submitting a state-changing request, the application sends the token along with the request.
4. Spring Security validates the token. If it is missing or invalid, the request is rejected.

for POST 
IN Headers
   key : X-CSRF-TOKEN

   get token from HttpServletRequest where reuest.getArribute("_csrf);




   
# Spring Boot Learning Repository

A hands-on repository documenting my journey of learning Spring Boot, Spring Security, and backend development using Java.

This repository contains practical implementations, experiments, notes, and examples that help me understand how Spring Boot applications work — from fundamentals to security and backend architecture.

---

## 🎯 Objectives

- Understand Spring Boot architecture and its core features.
- Learn how Spring manages objects using IoC and Dependency Injection.
- Build REST APIs using Spring MVC.
- Understand authentication and authorization.
- Explore Spring Security and its security mechanisms.
- Learn JWT-based authentication.
- Work with databases using Spring Data JPA.
- Understand security concepts through practical implementation rather than memorization.

---

## 🛠️ Tech Stack

| Technology | Purpose |
|---|---|
| Java 21 | Programming language |
| Spring Boot 4.1.1 | Backend application framework |
| Spring MVC | Building web applications and REST APIs |
| Spring Security | Application security |
| Spring Data JPA | Database access and ORM |
| PostgreSQL | Relational database |
| JWT | Token-based authentication |
| Maven | Dependency management and build tool |

---

## 📚 Topics Covered

### Spring Boot
- Spring Boot fundamentals
- Application configuration
- Dependency Injection
- IoC Container
- Beans and component scanning
- Spring Boot application lifecycle

### Spring MVC & REST APIs
- Controllers
- Request mapping
- HTTP methods
- REST API fundamentals
- Request and response handling

### Spring Security
- Authentication vs Authorization
- Security filter chain
- Security configuration
- Session-based authentication
- CSRF (Cross-Site Request Forgery)
- CSRF protection and tokens
- HTTP security considerations

### Database & Persistence
- Spring Data JPA
- Entity mapping
- Repository pattern
- PostgreSQL integration

### Authentication
- JWT (JSON Web Token)
- Token-based authentication
- Authentication flow
- Authorization

> This repository is continuously evolving as I learn and implement new concepts.

---

## 📂 Project Structure

```text
Spring-Boot/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/springsecurity/
│   │   │
│   │   └── resources/
│   │
│   └── test/
│
├── .mvn/
│   └── wrapper/
│
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
```

---

## 🚀 Getting Started

### Prerequisites

Make sure you have installed:

- Java 21 or later compatible with the project
- Git
- PostgreSQL (when working with database-dependent features)

Verify Java installation:

```bash
java -version
```

### Clone the Repository

```bash
git clone https://github.com/MANI-07-code/Spring-Boot.git
```

Navigate into the project:

```bash
cd Spring-Boot
```

### Run the Application

Using Maven Wrapper:

**Windows**

```powershell
.\mvnw.cmd spring-boot:run
```

**Linux / macOS**

```bash
./mvnw spring-boot:run
```

Alternatively, if Maven is installed:

```bash
mvn spring-boot:run
```

---

## 📖 Learning Approach

My learning approach focuses on understanding the concepts behind the framework.

For every topic, I try to understand:

1. What is the concept?
2. Why is it required?
3. How does it work internally?
4. How is it used in real-world applications?
5. What problems does it solve?
6. What are the common mistakes?

The goal is to build a strong foundation in Java backend development and understand how real-world Spring Boot applications are designed.

---

## 📈 Progress

This repository is actively maintained as I continue learning.

- [x] Spring Boot project setup
- [x] Maven project configuration
- [x] Spring MVC fundamentals
- [x] Spring Security fundamentals
- [x] Understanding CSRF protection
- [ ] REST API development practice
- [ ] Database integration using PostgreSQL
- [ ] Spring Data JPA implementation
- [ ] JWT authentication implementation
- [ ] Authentication and authorization
- [ ] Testing Spring Boot applications
- [ ] Advanced Spring Boot concepts

---

## 🔗 Resources

- [Spring Boot Documentation](https://docs.spring.io/spring-boot/)
- [Spring Framework Documentation](https://docs.spring.io/spring-framework/reference/)
- [Spring Security Documentation](https://docs.spring.io/spring-security/reference/)
- [Spring Guides](https://spring.io/guides)
- [Java Documentation](https://docs.oracle.com/en/java/)


