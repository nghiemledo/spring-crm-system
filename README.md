# Spring Boot CRM System with Thymeleaf

## Overview
This is a Spring Boot crm system that manages companies, roles, and users using Thymeleaf as the templating engine. The application provides a simple admin panel for managing entities, including creating, updating, deleting, and viewing details.

## Technologies Used
- Java 17+
- Spring Boot
- Spring MVC
- Thymeleaf
- Spring Data JPA
- Hibernate
- MySQL 
- H2 Database

## Features
### Company Management
- List all companies (`/admin/company`)
- View company details (`/admin/company/{id}`)
- Create a new company (`/admin/company/create`)
- Update an existing company (`/admin/company/update/{id}`)
- Delete a company (`/admin/company/delete/{id}`)

### Role Management
- List all roles (`/admin/role`)
- Create a new role (`/admin/role/new`)
- Update an existing role (`/admin/role/update/{id}`)
- Delete a role (`/admin/role/delete/{id}`)

### User Management
- List all users (`/admin/user`)
- View user details (`/admin/user/{id}`)
- Create a new user (`/admin/user/create`)
- Update an existing user (`/admin/user/update/{id}`)
- Delete a user (`/admin/user/delete/{id}`)

## Installation & Setup
### Prerequisites
- Java 17+
- Maven
- MySQL 
- H2 Database

### Steps to Run the Project
1. Clone the repository:
   ```sh
   git clone https://github.com/nghiemledo/spring-crm-system.git
   cd spring-crm-system
   ```

2. Configure the database in `application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/spring-crm-system
   spring.datasource.username=...
   spring.datasource.password=...
   spring.jpa.hibernate.ddl-auto=update
   ```

3. Build and run the application:
   ```sh
   mvn spring-boot:run
   ```

4. Access the application at:
   - Home: `http://localhost:8000/`
   - Admin Panel: `http://localhost:8000/admin`

## Project Structure
```
|-- src/main/java/com/st22d/homework01
    |-- controllers
        |-- CompanyController.java
        |-- RoleController.java
        |-- UserController.java
    |-- domain
        |-- Company.java
        |-- Role.java
        |-- UserDemo.java
    |-- services
        |-- CompanyService.java
        |-- RoleService.java
        |-- UserService.java
```

## Contributing
Feel free to fork this repository and submit pull requests for improvements.

## License
This project is licensed under the MIT License.

## Contact
For any issues or inquiries, please contact `nghiemledo@gmail.com`.

