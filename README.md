# House Painting Commissions Admin

## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup MySQL database](#setup-mysql-database)
* [Running the application locally](#running-the-application-locally)
* [Credentials](#credentials)

## General info
Web application that is capable of processing and storing client and commission data for a house painting business. This app is versatile enough to be used by any small business.
Authenticated users with admin privileges can create, read, update and delete data, while regular users are only able to create and read data.

## Technologies
Project is created with:
* Java version: 17
* Spring Boot version: 2.7.1
* Bootstrap version: 5
* Thymeleaf version: 3.0
* MySQL version: 8.0

## Setup MySQL database

You can execute the following MySQL script to create tables:

```
CREATE TABLE `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(45) NOT NULL,
  `full_name` varchar(45) NOT NULL,
  `password` varchar(64) NOT NULL,
  `enabled` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
);
 
CREATE TABLE `roles` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
);
 
CREATE TABLE `users_roles` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  KEY `user_fk_idx` (`user_id`),
  KEY `role_fk_idx` (`role_id`),
  CONSTRAINT `role_fk` FOREIGN KEY (`role_id`) REFERENCES `roles` (`role_id`),
  CONSTRAINT `user_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
);
```

Execute the following INSERT statements to insert 2 roles into the roles table:

```
INSERT INTO `roles` (`name`) VALUES ('USER');
INSERT INTO `roles` (`name`) VALUES ('ADMIN');
```

Run the following SQL statements to create 2 users in the users table:

```
INSERT INTO `users` (`username`, `password`, `enabled`) VALUES ('john', '$2a$10$E2UPv7arXmp3q0LzVzCBNeb4B4AtbTAGjkefVDnSztOwE7Gix6kea', '1');
INSERT INTO `users` (`username`, `password`, `enabled`) VALUES ('admin', '$2a$10$IqTJTjn39IU5.7sSCDQxzu3xug6z/LPU6IF0azE/8CkHCwYEnwBX.', '1');
```
The passwords are encoded in BCrypt format. They are same as usernames (ex. username: john; password: john).

To assign permissions to users based on the table above, execute the following script:

```
INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES (1, 1); 
INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES (2, 2); 
```
So user "admin" has role ADMIN and user "john" has role USER.

### application.properties

To use Spring Boot with Spring Data JPA and Hibernate, configure database connection information in the application.properties as follows
(remember to modify URL, username and password matching your MySQL database):
```
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url = jdbc:mysql://localhost:3306/your_database?createDatabaseIfNotExist=true
spring.datasource.username = root
spring.datasource.password = password
```

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the main method in the com.poecat.housepaintingadmin.HousePaintingAdminApplication class from your IDE.

Alternatively, you can use the Spring Boot Maven plugin in root directory:

```mvn spring-boot:run```

## Credentials 

You can login as admin (username: **poe**; password: **passing123**) to have access to editing functions, or regular user (username: **blaise**; password: **passing123**) - without access to these functions.
