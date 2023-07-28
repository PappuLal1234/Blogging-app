# Blog Application Backend

This is a backend application for a simple Blog platform, implemented using Java and Spring Boot following the Model-View-Controller (MVC) architecture.

## Technology Stack

The following technologies have been used to build this backend application:

- Java 17
- Spring Boot: A popular framework for building Java-based web applications.
- Maven: A build automation tool used for managing dependencies and building the project.
- Hibernate: An ORM (Object-Relational Mapping) framework used for mapping Java objects to database tables.
- Jakarta Persistence API (JPA): A Java EE specification for ORM that provides a common interface for working with relational databases.
- MYSQl Database: An  relational database used for storing user, post, and comment data during runtime (for simplicity in this example).

## Getting Started

To run the application, make sure you have Java 8 and Maven installed on your system. Then, follow these steps:

1. Clone the repository:
   git clone https://github.com/PappuLal1234/Blogging-app.git
   cd blog-backend

2. Build the project:
   mvn clean install

3. Run the application:

The application will be accessible at `http://localhost:8080`.

## MVC Architecture

The application follows the Model-View-Controller (MVC) architecture, which is a design pattern used for building scalable and maintainable web applications. The main components of the MVC pattern are as follows:

- Model: Represents the application's data and business logic. In this application, the model classes are `User`, `Post`, and `Comment`.
- View: Represents the user interface. In this backend application, the view is not present as it is responsible for the frontend interface.
- Controller: Acts as an intermediary between the model and the view. It handles user requests, processes data, and updates the model. In this application, the controller classes are `UserController`, `PostController`, and `CommentController`.

## API Endpoints

### User API

- `POST /api/users/signup` - Sign up a new user by providing user details in the request body.
- `POST /api/users/signIn` - Sign in a user by providing email and password in the request body.
- `GET /api/users` - Get all users.
- `GET /api/users/{userId}` - Get a specific user by their ID.
- `POST /api/users` - Create a new user by providing user details in the request body.
- `PUT /api/users/{email}/token/{token}` - Update user information by providing email, token, and updated user details in the request body.
- `DELETE /api/users/{userId}` - Delete a user by their ID.

### Post API

- `GET /api/posts` - Get all posts.
- `GET /api/posts/{postId}` - Get a specific post by its ID.
- `POST /api/posts` - Create a new post by providing post details in the request body.
- `PUT /api/posts/{postId}` - Update a post by providing its ID and updated post details in the request body.
- `DELETE /api/posts/{postId}` - Delete a post by its ID.

### Comment API

- `GET /api/comments` - Get all comments.
- `GET /api/comments/{commentId}` - Get a specific comment by its ID.
- `POST /api/comments` - Create a new comment by providing comment details in the request body.
- `PUT /api/comments/{commentId}` - Update a comment by providing its ID and updated comment details in the request body.
- `DELETE /api/comments/{commentId}` - Delete a comment by its ID.

## Database Schema

The application uses an H2 in-memory database to store user, post, and comment data. The database schema includes tables for `User`, `Post`, and `Comment`, with appropriate relationships.

## Note

This is a simplified version of a Blog application backend for demonstration purposes. In a real-world scenario, you may need to enhance security, add validation, error handling, and database persistence to make it production-ready.

---
