# CRUD Operation with Spring Boot

## Description
The **CRUD Operation with Spring Boot** project implements a robust RESTful API for managing department entities within a database. The application allows users to perform the following operations on departments:

- **Create**: Add a new department to the database.
- **Read**: Retrieve a list of all departments or fetch details of a specific department by its ID.
- **Update**: Modify the details of an existing department.
- **Delete**: Soft delete a department, marking it as inactive rather than removing it from the database.

### Key Features
- **Search Functionality**: Departments can be searched by their name using a case-insensitive search query.
- **Pagination and Sorting**: Lists of departments can be paginated and sorted based on specified parameters (not implemented in the provided code but can be easily added).
- **Soft Delete**: Departments are not permanently removed but marked as inactive, allowing for data retention and easy restoration.
- **DTO Implementation**: Data Transfer Objects (DTOs) are utilized to separate the entity logic from the data transfer logic, ensuring better encapsulation and clarity.
- **Validation**: Uses Jakarta validation to enforce data integrity by validating input fields.

### Technologies Used
- **Spring Boot**: Framework for building the application.
- **Spring Data JPA**: For data access and manipulation.
- **MySQL**: Relational database management system.
- **Lombok**: Java library to reduce boilerplate code.
- **Jakarta Validation**: For validating user input.

### Getting Started
1. **Clone the repository**:
   ```bash
   git clone https://github.com/Sandy-7061/CURD_Operation_In_SpringBoot.git
   cd crud-operation
   ```

2. **Setup MySQL**:
   - Create a database named `curd_test`.
   - Update the database credentials in `application.yml`. Here’s a sample configuration:

     ```yaml
     spring: {}
     server:
       port: "8080"
     application:
       name: "CURD operation"
     datasource:
       driver-class-name: "com.mysql.cj.jdbc.Driver"
       url: "jdbc:mysql://localhost:3306/curd_test"
       username: "root"
       password: "<YOUR_PASSWORD_HERE>"  # Replace with your actual MySQL password
     jpa:
       show-sql: "true"
     hibernate:
       ddl-auto: "update"
     ```

3. **Run the application**:
   - Use your IDE to run the Spring Boot application, or use Maven commands:
   ```bash
   mvn spring-boot:run
   ```

4. **Access the API**:
   - The application will run on `http://localhost:8080`.
   - Use tools like Postman or cURL to interact with the API.

### API Endpoints
- **POST** `/departments` - Create a new department.
- **GET** `/departments` - Retrieve all departments.
- **GET** `/departments/{id}` - Retrieve a specific department by ID.
- **PUT** `/departments/{id}` - Update an existing department.
- **DELETE** `/departments/{id}` - Soft delete a department.
- **GET** `/departments/search?name={name}` - Search for departments by name.

### Contact Information
For any inquiries or support, feel free to reach out to me:

[Contact Me](tel:+917024520740) - **7024520740**

### License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

### Author
**Sandeep Kushwaha**
```

### Notes:
- The contact link `[Contact Me](tel:+917024520740)` will create a clickable link that allows users to call your number directly if they view this on a compatible device (like a smartphone).
- Remember to replace `https://github.com/your-username/crud-operation.git` with the actual repository URL and `<YOUR_PASSWORD_HERE>` with your password when finalizing this README file. Let me know if you need further adjustments!
