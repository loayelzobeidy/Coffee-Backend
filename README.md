
 * Coffee API Backend (Kotlin)
 *
 * A RESTful backend application built with Kotlin for managing coffee information.
 * Features JWT authentication and role-based authorization (User/Admin).
 * Having two databases on the same application postgresql managing the coffee drinks, food & menus(joins). and Mongodb responsible for documents coffeeshop with address object, reviews
 * etc.
 *
 * Provides endpoints for:
 *  - Retrieving coffee drinks
 *  - Adding new coffee drinks (Admin only)
 *  - User registration and login
 *  - User role management (Admin only)
 *
 * Technologies used:
 *  - Kotlin
 *  - [Spring Boot]
 *  - JWT (JSON Web Tokens) for authentication
 *  - [Database used,PostgreSQL, MongoDB]
 *
 *  Example Usage (replace with actual endpoint)
 *  - GET /coffees - Returns a list of coffee drinks
 *  - POST /coffees - Adds a new coffee drink (Admin only)
 *  - POST /api/users - Registers a new user
 *  - POST /api/auth - Logs in a user and returns a JWT
 *
