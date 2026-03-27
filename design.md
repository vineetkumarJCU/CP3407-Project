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

**Architecture Diagram**

The system follows a client-server architecture:

Android App (Frontend)
Node.js Backend API
MySQL Database
AWS Cloud Hosting

The frontend communicates with the backend via REST APIs, and the backend interacts with the database to process requests.

<img width="1536" height="1024" alt="Architecture diagram" src="https://github.com/user-attachments/assets/62275423-9114-404e-bbca-62dc63ad670c" />

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


