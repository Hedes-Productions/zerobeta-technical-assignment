# Order Management System

This is a Spring Boot based order management system using MySQL for data storage.

## ERD Diagram

![ERD Diagram](ERD%20Diagram.png)

## DDL Script

You can find the database [DDL Script](DDL%20Script.sql) here. This script includes the table definitions and constraints for the orders and users tables.

## Installation

1. Clone this repository to your local machine.

```
git clone https://github.com/Hedes-Productions/zerobeta-technical-assignment.git
```

2. Navigate to the project directory.

3. Run `mvn clean install` to build the project and generate the JAR file.

   - Note: Make sure the JAR file is generated in the target directory.

## Running with Docker Compose

1. Navigate to the root directory of the project.

2. Run the following command.

```
docker compose up -d
```

## Endpoints

Once the application is running, you can access the following endpoints:

- ### Sign up : http://localhost:8080/api/auth/signup - POST

  - #### Example JSON body

```
{
    "email":"pass@gmail.com",
    "password":"pass",
    "firstName":"test",
    "lastName":"testing"
}
```

- ### Sign in : http://localhost:8080/api/auth/signin - POST

  - #### Example JSON body

```
{
    "email":"pass@gmail.com",
    "password":"pass"
}
```

- ### Place order : http://localhost:8080/api/orders/placeorder - POST

  - Make sure to pass a `Bearer Token` (which got from signing up or signing) in the authorization header.

  - #### Example JSON body

```
{
    "itemName":"carrot",
    "quantity": 5,
    "address": "123 Main Street, Anytown, USA"
}
```

- ### Cancel order : http://localhost:8080/api/orders/cancelorder - POST

  - Make sure to pass a `Bearer Token` (which got from signing up or signing) in the authorization header.
  - Make sure to use the `orderId` which got from placing order.

  - #### Example JSON body

```
{
    "orderId":"536e9b50-7de6-433a-96ad-96d16b98212b"
}
```

- ### Get history : http://localhost:8080/api/orders/history?page={page_number}&size={page_size} - GET

  - Make sure to pass a `Bearer Token` (which got from signing up or signing) in the authorization header.
  - Make sure to replace {`page_number`} and {`page_size`} with the page number and the size of the page.
