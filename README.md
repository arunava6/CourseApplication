# 📚 CourseWeb Backend

A simple **Spring Boot backend project** for managing **courses** and **course purchases (orders)**.  
This project is intentionally built **without Spring Security** to keep the learning curve simple and focus on **REST APIs, JPA, validation, and database interactions**.

---

## 🚀 Features

### ✅ Course Management
1. Add new courses  
2. Get all available courses  
3. Get course details by ID  
4. Update course information  
5. Delete a course  

### 🛒 Course Purchase (Orders)
1. Purchase a course (place order)  
2. View all orders  
3. View order by ID  
4. Delete an order  

### 🧩 Other Highlights
- RESTful API design  
- Input validation using **Jakarta Validation**  
- Centralized exception handling  
- MySQL database integration using **Spring Data JPA**  
- CORS enabled for frontend integration (**Vite / React**)  

---

## 🛠 Tech Stack

| Technology | Description |
|----------|------------|
| Java | Java 21 |
| Spring Boot | 4.0.1 |
| Spring Web MVC | REST APIs |
| Spring Data JPA | ORM & database access |
| MySQL | Relational Database |
| Lombok | Reduce boilerplate code |
| Maven | Build & dependency management |

---

## 📂 Project Structure

```text
CourseWeb
│── pom.xml
│── mvnw
│── src
│   ├── main
│   │   ├── java/com/example/CourseWeb
│   │   │   ├── controller
│   │   │   ├── model
│   │   │   ├── repositories
│   │   │   ├── service
│   │   │   ├── exceptions
│   │   │   └── CourseWebApplication.java
│   │   └── resources
│   │       └── application.properties
│   └── test
└── target
```

## ⚙️ Configuration

### Database Configuration (`application.properties`)

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/courseweb
spring.datasource.username=your_username
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
```

# 🔌 API Endpoints

## 📘 Courses API
| Method | Endpoint                     | Description      |
| ------ | ---------------------------- | ---------------- |
| GET    | `/courses/allCourses`        | Get all courses  |
| GET    | `/courses/{courseId}`        | Get course by ID |
| POST   | `/courses/`                  | Add a new course |
| PUT    | `/courses/update/{courseId}` | Update course    |
| DELETE | `/courses/delete/{courseId}` | Delete course    |

## 🛍 Orders API
| Method | Endpoint            | Description     |
| ------ | ------------------- | --------------- |
| POST   | `/orders/`          | Place an order  |
| GET    | `/orders/`          | Get all orders  |
| GET    | `/orders/{orderId}` | Get order by ID |
| DELETE | `/orders/{orderId}` | Delete order    |


## 📦 Sample Request Payloads

### ➕ Create Course

```json
{
  "courseName": "Spring Boot Mastery",
  "courseDesc": "Complete backend development using Spring Boot",
  "tags": "spring,java,backend",
  "duration": 40,
  "listedOn": "2025-01-01",
  "price": 4999
}
```


### 🛒 Place Order
```json
{
  "course": {
    "courseId": 1
  },
  "purchaseDate": "2025-01-05",
  "amountPaid": 4999
}
```

## ▶️ Running the Project

1. Clone the repository
git clone https://github.com/your-username/CourseWeb.git

2. Navigate to the project directory
cd CourseWeb

3. Run the application
mvn spring-boot:run

4. Server will start at:
http://localhost:8080


### 🌐 Frontend Integration

CORS is enabled for:

http://localhost:5173

This makes it easy to connect with a React + Vite frontend.


# 👨‍💻 Author

Arunava Saha Roy
