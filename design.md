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

- UI Layer: Android screens (Login, Register, Restaurant List, Details)
- Data Layer: DataRepository handles all application logic
- Model Layer: Data classes (User, Restaurant, Order)

The UI interacts with the DataRepository to retrieve and update data.  
The DataRepository acts as a central source of truth and manages application state.

This architecture improves:
- Separation of concerns
- Maintainability
- Scalability for future backend integration (e.g., Firebase or AWS)


<img width="1130" height="568" alt="Architecture diagram 1" src="https://github.com/user-attachments/assets/be87307b-1849-4156-b643-7f3e9608e18f" />



[ UI Layer ]
(Login / Register / Screens)
        ↓
[ DataRepository ]
(Business Logic)
        ↓
[ Models ]
(User / Restaurant / Order)


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

