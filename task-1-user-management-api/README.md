# User Management API

A simple and clean **Spring Boot REST API** that manages user data with full CRUD operations.  
Built using **MVC architecture**, **DTOs**, **validation**, and **JSON file persistence** (no external database needed).  

---

## 🚀 Features

### ✔ Full CRUD Endpoints
- Create a user  
- Fetch all users  
- Fetch a single user by ID  
- Update user details  
- Delete a user  

### ✔ MVC Architecture
- Controller → handles HTTP requests  
- Service → business logic  
- Model → user entity  
- DTOs → request/response separation  
- Exception → custom + global error handlers  

### ✔ Validation
- Name cannot be empty  
- Email must be valid  
- Age must be positive  

### ✔ JSON Persistence (No Database Required)
- Automatically loads users from `users.json` on startup  
- Saves users back to `users.json` on shutdown  
- Makes the API persistent across restarts  

### ✔ Clean Error Handling
- `404 Not Found` for invalid user ID  
- `400 Bad Request` for validation failures  

---

## 📁 Project Structure

com.ayush.user_management_api
├── UserManagementApiApplication.java
├── controller
│ └── UserController.java
├── service
│ └── UserService.java
├── model
│ └── User.java
├── dto
│ ├── UserRequest.java
│ └── UserResponse.java
└── exception
├── UserNotFoundException.java
└── GlobalExceptionHandler.java


---

## ⚙️ Tech Stack
- Java  
- Spring Boot  
- Spring Web  
- Jakarta Validation  
- Jackson (JSON serialization)  
- Maven  

---

## ▶️ How to Run

### **Using IntelliJ IDEA**
1. Clone the repo  
2. Open the project in IntelliJ  
3. Run the class:  
   `UserManagementApiApplication.java`

### **Using Terminal**
```bash
mvn spring-boot:run

