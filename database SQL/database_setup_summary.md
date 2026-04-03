## Database Setup Summary

The FeedMe project uses a cloud-hosted MySQL database on Amazon RDS.

The setup process included:

1. creating a MySQL database instance in Amazon RDS
2. configuring AWS security rules for MySQL access
3. connecting to the hosted database using MySQL Workbench
4. creating the FeedMe relational schema
5. inserting sample restaurant data
6. connecting a Node.js backend API to the hosted database
7. connecting the Android app to the backend API using Retrofit

This allowed the Android application to retrieve live restaurant data from the cloud database rather than relying only on hardcoded local demo data.

<img width="940" height="268" alt="image" src="https://github.com/user-attachments/assets/7c556c48-0bee-4bfd-a2db-36dcc6ea9d42" />

<img width="940" height="1082" alt="image" src="https://github.com/user-attachments/assets/38277264-a781-4a07-a7af-0e791185842c" />
  
# Cloud Database and Backend Setup Report

## Overview
This report explains how the FeedMe project was extended from a local Android prototype into a full-stack system using a cloud-hosted database and backend API.

The final architecture is:

Android App → Node.js Backend API → MySQL on Amazon RDS

This design separates the mobile frontend from the database layer and follows a more realistic production structure.

---

## 1. Amazon RDS Database Setup

The first stage was creating a hosted MySQL database using Amazon RDS.

### Steps completed
- opened AWS Console
- selected Amazon RDS
- created a new MySQL database instance
- configured master username and password
- enabled public accessibility for development and testing
- configured AWS security groups to allow MySQL access on port 3306 from the development machine

### Result
The database became available in AWS and could be accessed externally using the provided RDS endpoint.

---

## 2. MySQL Workbench Connection

After creating the RDS instance, MySQL Workbench was used to connect to the hosted cloud database.

### Connection configuration
- Host: Amazon RDS endpoint
- Port: 3306
- Username: RDS master username
- Password: configured during database creation

### Result
A successful MySQL Workbench connection confirmed that the cloud database was reachable and correctly configured.

---

## 3. Relational Schema Creation

A production-oriented relational schema was created in the hosted `feedme` database.

### Main tables
- `users`
- `restaurants`
- `menu_items`
- `orders`
- `reviews`
- `order_history`

### Purpose
This schema supports:
- user authentication
- restaurant browsing
- menu management
- order placement
- future reviews and ratings
- admin approval and analytics extensions

### Result
The cloud database contained a structured relational schema suitable for future iterations of the project.

---

## 4. Sample Data Insertion

Sample restaurant data was inserted into the hosted database to validate the schema and test the application workflow.

### Example records
- Burger House
- Pizza Palace
- Sushi Wave
- Spice Hub
- Green Bowl

### Result
The database could return live restaurant records through SQL queries.

---

## 5. Backend API Setup

A backend API was built using Node.js and Express.

### Backend setup steps
- created a backend folder
- added `server.js`, `package.json`, and `.env`
- installed dependencies with npm:
  - express
  - mysql2
  - cors
  - dotenv

### `.env` configuration
The backend used environment variables to securely connect to Amazon RDS:

- database host
- port
- username
- password
- database name

### Result
The backend connected successfully to MySQL on Amazon RDS.

---

## 6. API Route Testing

A `/restaurants` route was created in the backend.

### Function
This route executes a SQL query against the `restaurants` table and returns JSON data.

### Browser test
The route was tested in the browser using:

`http://localhost:3000/restaurants`

### Result
The backend returned live JSON data from the Amazon RDS database.

---

## 7. Android App Integration

The Android application was updated to consume live backend data.

### Android changes
- added internet permission in `AndroidManifest.xml`
- enabled cleartext traffic for local backend development
- added Retrofit dependencies
- created API client and service files
- replaced hardcoded restaurant repository logic with backend API calls

### Result
The Android emulator successfully loaded restaurant data from the backend, which in turn queried the hosted cloud database.

---

## 8. Final Working Flow

The final implemented flow is:

Android App → Retrofit → Node.js Backend → Amazon RDS MySQL

This confirms that the FeedMe project now uses a real full-stack architecture instead of only local hardcoded data.

---

## 9. How Database Updates Affect the App

If restaurant data is added or edited in MySQL Workbench, the changes are saved directly in the Amazon RDS database.

Because the backend route reads directly from the `restaurants` table, the application will show the updated data the next time it fetches the restaurant list.

This means:

- updating the SQL data updates the backend response
- updating the backend response updates the Android restaurant list on the next reload or fetch

This behaviour demonstrates real database-driven application functionality.

---

## 10. Conclusion

The cloud database and backend integration significantly improved the technical quality of the FeedMe project.

This setup demonstrates:
- real-world deployment planning
- cloud database hosting
- backend API integration
- scalable and maintainable architecture
- stronger evidence for HD-level design, implementation, and tool usage
