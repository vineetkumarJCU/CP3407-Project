# System Design

## Overview

This section describes the architecture, database, and UI design of FeedMe.

## Architecture

* Android App (Frontend)
* Node.js Backend
* MySQL Database
* AWS Hosting

## Database Design

Entities:

* Users
* Restaurants
* Orders
* Reviews

## Interface Design

Screens:

* Login
* Home
* Restaurant List
* Order Screen

Design focuses on usability, simplicity, and efficiency.

## Architecture Diagram

The FeedMe application follows a layered architecture design:

### UI Layer
The UI layer consists of Android screens built using Jetpack Compose, including:
- Login
- Register
- Restaurant List
- Restaurant Details

This layer is responsible for handling user interaction and displaying data.

### Data Layer (Repository)
The DataRepository acts as the core logic layer of the application. It is responsible for:
- Managing user authentication
- Retrieving restaurant data
- Handling order placement
- Acting as a central source of truth for the application

The UI communicates only with the DataRepository, ensuring separation between presentation and business logic.

### Model Layer
The model layer defines the structure of application data using classes such as:
- User
- Restaurant
- Order

These models represent the core entities used throughout the system.

### Database and Cloud Integration
In the current prototype, data is managed locally through the DataRepository to simulate application behaviour.

For production deployment, the system is designed to integrate with a relational database using:
- MySQL as the database system
- Amazon RDS as the cloud hosting service

Amazon RDS provides a scalable and managed environment for hosting the MySQL database, allowing secure storage and retrieval of application data such as users, orders, and restaurants.

This design ensures that the DataRepository can be extended to communicate with a real backend without changing the UI layer.

### Architecture Flow

[ UI Layer ]  
(Login / Register / Screens)  
        ↓  
[ DataRepository ]  
(Business Logic & Data Handling)  
        ↓  
[ MySQL Database (Amazon RDS) ]  
(Cloud Data Storage)

### Design Justification

This layered architecture improves:

- Separation of concerns: UI, logic, and data are clearly separated
- Maintainability: changes in one layer do not affect others
- Scalability: supports integration with cloud services such as AWS
- Flexibility: allows easy transition from prototype to production system


<img width="1536" height="1024" alt="Architecture Design" src="https://github.com/user-attachments/assets/e8603338-856a-45d0-96d6-747689339059" />



**Database Diagram (ERD)**

The system uses a relational database with the following entities:

Users (id, name, email, role)
Restaurants (id, name, location)
Orders (id, user_id, restaurant_id, total)
Reviews (id, user_id, restaurant_id, rating)

Relationships:

A user can place multiple orders
A restaurant can receive multiple reviews
Orders connect users and restaurants


<img width="1536" height="1024" alt="ERD diagram" src="https://github.com/user-attachments/assets/7ff5c880-64c2-4a01-a506-8a68faa7a839" />

Interface Design Mockups

The application includes the following screens:

Login / Register
Home (restaurant browsing)
Restaurant details
Order / checkout

The UI focuses on simplicity, fast navigation, and user-friendly interaction.


<img width="1536" height="1024" alt="UI mockups" src="https://github.com/user-attachments/assets/b43b34df-dbc7-4d30-a4a0-53fd3eea414b" />



## Cloud Database Deployment (Amazon RDS)

A production-ready MySQL relational database was successfully deployed on Amazon RDS.

### Hosted Schema
The cloud-hosted schema currently includes the following core tables:

- `users`
- `restaurants`
- `menu_items`
- `orders`
- `reviews`
- `order_history`

Sample production data was inserted successfully to validate the cloud deployment and confirm that the schema supports the main system workflows.

### Supported Application Features
This deployed database currently supports:

- user authentication
- restaurant browsing
- menu management
- order placement
- future vendor analytics
- review system
- admin approval workflow

### Design Justification
This deployment choice improves:

- **Scalability** — supports future growth in users, restaurants, and orders
- **Maintainability** — centralised relational structure simplifies updates and feature expansion
- **Production Readiness** — cloud deployment on Amazon RDS reflects real-world software engineering practice
- **Security** — controlled access through AWS networking, MySQL authentication, and backend API separation




