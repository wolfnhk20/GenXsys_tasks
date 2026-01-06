# GenXsys Backend Internship Tasks

This repository contains all backend development tasks completed as part of the GenXsys Internship Program.

All tasks are implemented using Spring Boot and demonstrate real-world backend development concepts such as REST APIs, database persistence, authentication, and role-based access control.

---

## 🧩 Tasks Overview

| Task | Description |
|----|-----------|
| Task-1 | Basic REST API with CRUD operations and input validation |
| Task-2 | MongoDB integration and persistent storage |
| Task-3 | JWT Authentication and Role-Based Authorization |

---

## 🛠 Tech Stack

- Java
- Spring Boot
- MongoDB
- Spring Security
- JWT Authentication
- Maven

---

## 📁 Folder Structure
```
GenXsys_tasks/
├── Task-1-user-api
├── Task-2-db-integration
└── Task-3-jwt-auth
```

Each task folder contains its own detailed README explaining functionality and APIs.

---

## ▶ How to Run the Project

### Prerequisites
- Java 17 or above  
- Maven  
- MongoDB installed and running  

---

### Run Using Command Line (Without IDE)

```bash
cd Task-3-jwt-auth/user_management_api
mvn clean
mvn spring-boot:run
```

## Server will start at:
```
http://localhost:8080
```

## Run Using IDE (IntelliJ / Eclipse / VS Code)

- Open the user_management_api folder in your IDE
- Allow Maven to download dependencies
- Run: UserManagementApiApplication.java

## Server starts at:
```
http://localhost:8080
```

---

### API Testing
## Use Postman or any REST client.

| Method	| Endpoint	| Description |
| ------ | -------- | ----------- |
| POST | 	/auth/register	| Register new user |
| POST |	/auth/login |	Login and get JWT token |
| GET |	/users |	Get users list (Requires JWT Token) |

- Add JWT token in request header:
- Authorization: Bearer <your_token_here>

---

## 👨‍💻 Author

Ayush Kulal
Backend Development Intern – GenXsys
