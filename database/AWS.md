## Cloud Database Deployment (Amazon RDS)

A production-ready **MySQL relational database** was successfully deployed on **Amazon RDS**.

### Hosted Schema

The cloud-hosted schema currently includes the following core tables:

* `users`
* `restaurants`
* `menu_items`
* `orders`
* `reviews`
* `order_history`

Sample production data was inserted successfully to validate the cloud deployment and ensure the relational schema supports the main system workflows.

### Supported Application Features

This deployed database currently supports:

* user authentication
* restaurant browsing
* menu management
* order placement
* future vendor analytics
* review system
* admin approval workflow

### Design Justification

This deployment choice improves:

* **Scalability** — supports future growth in users, restaurants, and orders
* **Maintainability** — centralised relational structure simplifies updates and feature expansion
* **Production Readiness** — cloud deployment on Amazon RDS reflects real-world software engineering practices
* **Security** — controlled access through AWS networking and MySQL authentication

<img width="452" height="378" alt="image" src="https://github.com/user-attachments/assets/41055378-afd7-4760-b738-eaf4feb2ef2d" />
<img width="452" height="379" alt="image" src="https://github.com/user-attachments/assets/025e37be-b20a-41b7-9d2b-21e53ce204d5" />
<img width="452" height="383" alt="image" src="https://github.com/user-attachments/assets/2b852f6a-da93-49bc-82b9-58cd5c57e768" />

