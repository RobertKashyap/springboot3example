# Spring Boot 3 Example - Customer Management CRUD Project

This project is a simple Spring Boot 3 application that demonstrates basic CRUD (Create, Read, Update, Delete) operations for managing customer data. It utilizes Spring Data JPA for database interaction and PostgreSQL as the underlying database.

## Project Structure

The project is structured as follows:

- **Main.java**: Contains the main class with Spring Boot application configuration and REST API endpoints for managing customers.
- **Customer.java**: Represents the `Customer` entity with JPA annotations for database mapping.
- **CustomerRepository.java**: Spring Data JPA repository interface for performing CRUD operations on the `Customer` entity.
- **application.yml**: Configuration file containing settings such as the database connection details.
- **pom.xml**: Maven project configuration file with dependencies and build settings.

## Prerequisites

Before running the application, ensure that you have the following installed:

- Java Development Kit (JDK) 17
- Maven
- PostgreSQL

## Getting Started

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/springboot3example.git
   ```

2. Navigate to the project directory:

   ```bash
   cd springboot3example
   ```

3. Update the `application.yml` file with your PostgreSQL database connection details:

   ```yaml
   spring:
     datasource:
       url: jdbc:postgresql://localhost:5432/your_database_name
       username: your_database_username
       password: your_database_password
   ```

4. Build and run the application:

   ```bash
   mvn spring-boot:run
   ```

   The application will be accessible at [http://localhost:8080/api/v1/customers](http://localhost:8080/api/v1/customers).

## API Endpoints

- **GET /api/v1/customers**: Retrieve a list of all customers.
- **POST /api/v1/customers**: Add a new customer. Send a JSON payload in the request body with the customer details.
- **DELETE /api/v1/customers/{customerId}**: Delete a customer by ID.
- **PUT /api/v1/customers/{customerId}**: Update a customer by ID. Include optional parameters (`name`, `email`, `age`) in the request parameters to update specific fields.

## Examples

### Adding a Customer

```bash
curl -X POST -H "Content-Type: application/json" -d '{"name":"John Doe","email":"john@example.com","age":30}' http://localhost:8080/api/v1/customers
```

### Updating a Customer

```bash
curl -X PUT -H "Content-Type: application/json" -d '{"name":"Updated Name"}' http://localhost:8080/api/v1/customers/1
```

### Deleting a Customer

```bash
curl -X DELETE http://localhost:8080/api/v1/customers/1
```

## Dependencies

- **Spring Boot Starter Data JPA**: Simplifies database access using the Java Persistence API (JPA).
- **PostgreSQL Driver**: JDBC driver for connecting to PostgreSQL databases.
- **Spring Boot Starter Web**: Starter for building web applications with Spring MVC.
- **Spring Boot Starter Test**: Starter for testing Spring Boot applications.

## Building and Packaging

The project is configured with Maven. You can build a JAR file using the following command:

```bash
mvn clean package
```

The resulting JAR file will be in the `target` directory.

## Running Tests

Run unit tests with the following command:

```bash
mvn test
```

## Docker Support

The project includes Docker support. You can build a Docker image using the following command:

```bash
mvn spring-boot:build-image
```

This will create a Docker image with the name specified in the `pom.xml` file.

## Additional Notes

- The project uses Spring Data JPA for database interactions, and the `CustomerRepository` interface provides a convenient way to perform CRUD operations on the `Customer` entity.
- The `Main` class includes REST API endpoints for managing customers. These endpoints follow RESTful conventions for CRUD operations.
- Make sure to update the database connection details in the `application.yml` file before running the application.

Feel free to explore and modify the code according to your requirements! If you encounter any issues or have questions, please refer to the [official Spring Boot documentation](https://docs.spring.io/spring-boot/docs/current/reference/html/index.html) or open an issue in this repository.